package lld.carRentalSystem;

import lld.carRentalSystem.model.ReservationStatus;
import lld.carRentalSystem.model.Vehicle;
import lld.carRentalSystem.model.VehicleStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class VehicleInventoryManager {

    private final ConcurrentHashMap<Long, Vehicle> vehicleConcurrentHashMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, List<Long>> vehicleReservationsMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, ReentrantLock> vehicleLocks = new ConcurrentHashMap<>();

    private final ReservationRepository reservationRepository;

    public VehicleInventoryManager(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleConcurrentHashMap.put(vehicle.getVehicleId(), vehicle);
        vehicleLocks.putIfAbsent(vehicle.getVehicleId(), new ReentrantLock());
    }

    public void bookVehicle(long vehicleId, long reservationId, Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start date and end date must not be null");
        }
        if (!endDate.after(startDate)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
        if (startDate.before(new Date())) {
            throw new IllegalArgumentException("Start date must not be in the past");
        }

        ReentrantLock lock = vehicleLocks.computeIfAbsent(vehicleId, k -> new ReentrantLock());
        lock.lock();
        try {
            if (!isAvailable(vehicleId, startDate, endDate)) {
                throw new IllegalStateException("Vehicle is not available for the requested date range");
            }
            vehicleReservationsMap.computeIfAbsent(vehicleId, k -> Collections.synchronizedList(new ArrayList<>()))
                    .add(reservationId);
        } finally {
            lock.unlock();
        }
    }

    public void releaseVehicle(long vehicleId, long reservationId) {
        ReentrantLock lock = vehicleLocks.computeIfAbsent(vehicleId, k -> new ReentrantLock());
        lock.lock();
        try {
            List<Long> reservationIds = vehicleReservationsMap.get(vehicleId);
            if (reservationIds == null || !reservationIds.remove(reservationId)) {
                throw new IllegalStateException("Reservation not found for this vehicle");
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean isAvailable(long vehicleId, Date startDate, Date endDate) {
        List<Long> reservationIds = vehicleReservationsMap.get(vehicleId);
        if (reservationIds == null || reservationIds.isEmpty()) {
            return true;
        }
        return reservationIds.stream()
                .map(reservationRepository::getById)
                .filter(r -> r != null && r.getReservationStatus() == ReservationStatus.CONFIRMED)
                .noneMatch(r -> r.getStartDate().before(endDate) && r.getEndDate().after(startDate));
    }

    public List<Vehicle> getAvailableVehicles(Date startDate, Date endDate) {
        return vehicleConcurrentHashMap.values().stream()
                .filter(v -> v.getVehicleStatus() != VehicleStatus.MAINTENANCE)
                .filter(v -> isAvailable(v.getVehicleId(), startDate, endDate))
                .collect(Collectors.toList());
    }

    public void updateVehicleStatus(long vehicleId, VehicleStatus vehicleStatus) {
        Vehicle vehicle = vehicleConcurrentHashMap.get(vehicleId);
        vehicle.setVehicleStatus(vehicleStatus);
        vehicleConcurrentHashMap.put(vehicleId, vehicle);
    }

    public Vehicle getVehicleById(long vehicleId) {
        return vehicleConcurrentHashMap.get(vehicleId);
    }
}
