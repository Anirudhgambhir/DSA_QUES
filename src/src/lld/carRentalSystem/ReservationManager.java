package lld.carRentalSystem;

import lld.carRentalSystem.model.Reservation;
import lld.carRentalSystem.model.ReservationStatus;
import lld.carRentalSystem.model.User;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class ReservationManager {

    private static final AtomicLong ID_COUNTER = new AtomicLong(1);

    private final ReservationRepository reservationRepository;
    private final VehicleInventoryManager vehicleInventoryManager;

    public ReservationManager(ReservationRepository reservationRepository, VehicleInventoryManager vehicleInventoryManager) {
        this.reservationRepository = reservationRepository;
        this.vehicleInventoryManager = vehicleInventoryManager;
    }

    public void addReservation(Reservation reservation) {
        reservationRepository.add(reservation);
    }

    public Reservation getReservationById(long id) {
        return reservationRepository.getById(id);
    }

    public Reservation createReservation(User user, long vehicleId, Date startDate, Date endDate) {
        long reservationId = ID_COUNTER.getAndIncrement();

        // Book first — throws if vehicle is unavailable or dates are invalid
        vehicleInventoryManager.bookVehicle(vehicleId, reservationId, startDate, endDate);

        Reservation newReservation = Reservation.builder()
                .reservationId(reservationId).userId(user.getUserId())
                .reservationStatus(ReservationStatus.CONFIRMED)
                .startDate(startDate)
                .endDate(endDate)
                .vehicleId(vehicleId).build();
        addReservation(newReservation);
        return newReservation;
    }

    public void cancelReservation(long reservationId) {
        Reservation reservation = reservationRepository.getById(reservationId);
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation not found");
        }
        vehicleInventoryManager.releaseVehicle(reservation.getVehicleId(), reservationId);
        reservation.setReservationStatus(ReservationStatus.CANCELLED);
    }


}
