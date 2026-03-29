package lld.carRentalSystem;

import lld.carRentalSystem.billing.DailyBillingStrategy;
import lld.carRentalSystem.billing.HourlyBillingStrategy;
import lld.carRentalSystem.model.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CarRentalDemo {

    public static void main(String[] args) {
        // Setup shared repository
        ReservationRepository reservationRepository = new ReservationRepository();

        // Setup managers
        VehicleInventoryManager vehicleManager = new VehicleInventoryManager(reservationRepository);
        ReservationManager reservationManager = new ReservationManager(reservationRepository, vehicleManager);
        BillingManager billingManager = new BillingManager(new DailyBillingStrategy());
        PaymentManager paymentManager = new PaymentManager(billingManager);

        // Setup store 1 - Mumbai
        Location mumbaiLocation = Location.builder()
                .locationId(1).address("123 Main St").city("Mumbai").state("MH").zipCode("400001").build();
        CarRentalStore mumbaiStore = new CarRentalStore(1, mumbaiLocation, vehicleManager, reservationManager, billingManager, paymentManager);

        // Setup store 2 - Delhi
        Location delhiLocation = Location.builder()
                .locationId(2).address("456 Ring Rd").city("Delhi").state("DL").zipCode("110001").build();
        CarRentalStore delhiStore = new CarRentalStore(2, delhiLocation, vehicleManager, reservationManager, billingManager, paymentManager);

        // Setup system
        CarRentalSystem system = new CarRentalSystem();
        system.addStore(mumbaiStore);
        system.addStore(delhiStore);

        // Add users
        User user1 = User.builder().userId(1).userName("John").drivingLicenseNo("DL123").build();
        User user2 = User.builder().userId(2).userName("Jane").drivingLicenseNo("DL456").build();
        system.addUser(user1);
        system.addUser(user2);

        // Add vehicles
        Vehicle car1 = Vehicle.builder().vehicleId(1).vehicleNumber("MH01AB1234")
                .dailyRental(1000).vehicleStatus(VehicleStatus.AVAILABLE).vehicleType(VehicleType.FOUR_WHEELER).build();
        Vehicle car2 = Vehicle.builder().vehicleId(2).vehicleNumber("MH01CD5678")
                .dailyRental(2000).vehicleStatus(VehicleStatus.AVAILABLE).vehicleType(VehicleType.FOUR_WHEELER).build();
        Vehicle bike = Vehicle.builder().vehicleId(3).vehicleNumber("MH01EF9012")
                .dailyRental(500).vehicleStatus(VehicleStatus.AVAILABLE).vehicleType(VehicleType.TWO_WHEELER).build();
        Vehicle maintenanceCar = Vehicle.builder().vehicleId(4).vehicleNumber("MH01GH3456")
                .dailyRental(1500).vehicleStatus(VehicleStatus.MAINTENANCE).vehicleType(VehicleType.FOUR_WHEELER).build();
        mumbaiStore.addVehicle(car1);
        mumbaiStore.addVehicle(car2);
        mumbaiStore.addVehicle(bike);
        mumbaiStore.addVehicle(maintenanceCar);

        // Date range: tomorrow to +3 days
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date start1 = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, 3);
        Date end1 = cal.getTime();

        // === 1. Available vehicles (maintenance car excluded) ===
        System.out.println("=== 1. Initial Availability ===");
        List<Vehicle> available = mumbaiStore.getAvailableVehicles(start1, end1);
        System.out.println("Available vehicles: " + available.size()); // 3 (car1, car2, bike)

        // === 2. User1 books car1 ===
        System.out.println("\n=== 2. User1 Books Car1 ===");
        Reservation res1 = mumbaiStore.createReservation(user1, 1, start1, end1);
        System.out.println("Reservation ID: " + res1.getReservationId() + ", Status: " + res1.getReservationStatus());
        available = mumbaiStore.getAvailableVehicles(start1, end1);
        System.out.println("Available after booking: " + available.size()); // 2

        // === 3. User2 tries to book same car1 for overlapping dates — should fail ===
        System.out.println("\n=== 3. Double Booking Attempt ===");
        try {
            mumbaiStore.createReservation(user2, 1, start1, end1);
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // === 4. User2 books car1 for non-overlapping dates — should succeed ===
        System.out.println("\n=== 4. Non-Overlapping Booking ===");
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date start2 = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, 2);
        Date end2 = cal.getTime();
        Reservation res2 = mumbaiStore.createReservation(user2, 1, start2, end2);
        System.out.println("Reservation ID: " + res2.getReservationId() + ", Status: " + res2.getReservationStatus());

        // === 5. Generate bill with daily billing ===
        System.out.println("\n=== 5. Daily Billing ===");
        Bill bill1 = mumbaiStore.generateBill(res1.getReservationId());
        System.out.println("Bill ID: " + bill1.getBillId() + ", Amount: " + bill1.getTotalAmount() + ", Paid: " + bill1.isPaid());

        // === 6. Switch to hourly billing and generate bill ===
        System.out.println("\n=== 6. Hourly Billing ===");
        billingManager.setBillingStrategy(new HourlyBillingStrategy());
        Bill bill2 = mumbaiStore.generateBill(res2.getReservationId());
        System.out.println("Bill ID: " + bill2.getBillId() + ", Amount: " + bill2.getTotalAmount() + ", Paid: " + bill2.isPaid());
        billingManager.setBillingStrategy(new DailyBillingStrategy()); // switch back

        // === 7. Payment via different modes ===
        System.out.println("\n=== 7. Payments ===");
        Payment pay1 = mumbaiStore.makePayment(bill1.getBillId(), PaymentMode.CREDIT_CARD);
        System.out.println("Payment ID: " + pay1.getPaymentId() + ", Mode: " + pay1.getPaymentMode() + ", Success: " + pay1.isSuccess());
        System.out.println("Bill1 paid: " + bill1.isPaid());

        Payment pay2 = mumbaiStore.makePayment(bill2.getBillId(), PaymentMode.UPI);
        System.out.println("Payment ID: " + pay2.getPaymentId() + ", Mode: " + pay2.getPaymentMode() + ", Success: " + pay2.isSuccess());

        // === 8. Double payment attempt — should fail ===
        System.out.println("\n=== 8. Double Payment Attempt ===");
        try {
            mumbaiStore.makePayment(bill1.getBillId(), PaymentMode.DEBIT_CARD);
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // === 9. Cancel reservation and verify availability restored ===
        System.out.println("\n=== 9. Cancel Reservation ===");
        mumbaiStore.cancelReservation(res1.getReservationId());
        System.out.println("Reservation " + res1.getReservationId() + " status: " + res1.getReservationStatus());
        available = mumbaiStore.getAvailableVehicles(start1, end1);
        System.out.println("Available after cancellation: " + available.size()); // 3

        // === 10. Cancel already cancelled — should fail ===
        System.out.println("\n=== 10. Release Already Cancelled ===");
        try {
            mumbaiStore.cancelReservation(res1.getReservationId());
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // === 11. Invalid date validations ===
        System.out.println("\n=== 11. Date Validations ===");
        try {
            mumbaiStore.createReservation(user1, 2, end1, start1); // end before start
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
        try {
            mumbaiStore.createReservation(user1, 2, null, end1); // null date
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // === 12. Multi-store lookup ===
        System.out.println("\n=== 12. Store Lookups ===");
        System.out.println("Store by ID 1: " + system.getStoreById(1).getLocation().getCity());
        System.out.println("Store by ID 2: " + system.getStoreById(2).getLocation().getCity());
        System.out.println("Stores in Mumbai: " + system.getStoresByCity("Mumbai").size());
        System.out.println("Stores in Delhi: " + system.getStoresByCity("Delhi").size());
        System.out.println("Stores in Pune: " + system.getStoresByCity("Pune").size());

        // === 13. User lookup ===
        System.out.println("\n=== 13. User Lookups ===");
        System.out.println("User 1: " + system.getUserById(1).getUserName());
        System.out.println("User 2: " + system.getUserById(2).getUserName());

        System.out.println("\n=== All tests passed! ===");
    }
}
