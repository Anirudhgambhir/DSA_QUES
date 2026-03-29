package lld.carRentalSystem;

import lld.carRentalSystem.model.*;

import java.util.Date;
import java.util.List;

public class CarRentalStore {

    private final long storeId;
    private final Location location;
    private final VehicleInventoryManager vehicleInventoryManager;
    private final ReservationManager reservationManager;
    private final BillingManager billingManager;
    private final PaymentManager paymentManager;

    public CarRentalStore(long storeId, Location location,
                          VehicleInventoryManager vehicleInventoryManager,
                          ReservationManager reservationManager,
                          BillingManager billingManager,
                          PaymentManager paymentManager) {
        this.storeId = storeId;
        this.location = location;
        this.vehicleInventoryManager = vehicleInventoryManager;
        this.reservationManager = reservationManager;
        this.billingManager = billingManager;
        this.paymentManager = paymentManager;
    }

    public long getStoreId() { return storeId; }

    public Location getLocation() { return location; }

    public void addVehicle(Vehicle vehicle) {
        vehicleInventoryManager.addVehicle(vehicle);
    }

    public List<Vehicle> getAvailableVehicles(Date startDate, Date endDate) {
        return vehicleInventoryManager.getAvailableVehicles(startDate, endDate);
    }

    public Reservation createReservation(User user, long vehicleId, Date startDate, Date endDate) {
        return reservationManager.createReservation(user, vehicleId, startDate, endDate);
    }

    public void cancelReservation(long reservationId) {
        reservationManager.cancelReservation(reservationId);
    }

    public Bill generateBill(long reservationId) {
        Reservation reservation = reservationManager.getReservationById(reservationId);
        Vehicle vehicle = vehicleInventoryManager.getVehicleById(reservation.getVehicleId());
        return billingManager.generateBill(reservation, vehicle);
    }

    public Payment makePayment(long billId, PaymentMode paymentMode) {
        return paymentManager.processPayment(billId, paymentMode);
    }
}
