package lld.carRentalSystem;

import lld.carRentalSystem.billing.BillingStrategy;
import lld.carRentalSystem.model.Bill;
import lld.carRentalSystem.model.Reservation;
import lld.carRentalSystem.model.Vehicle;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class BillingManager {

    private static final AtomicLong ID_COUNTER = new AtomicLong(1);
    private final ConcurrentHashMap<Long, Bill> billMap = new ConcurrentHashMap<>();
    private BillingStrategy billingStrategy;

    public BillingManager(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

    public void setBillingStrategy(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

    public Bill generateBill(Reservation reservation, Vehicle vehicle) {
        long amount = billingStrategy.calculateAmount(reservation, vehicle);
        Bill bill = Bill.builder()
                .billId(ID_COUNTER.getAndIncrement())
                .reservationId(reservation.getReservationId())
                .totalAmount(amount)
                .paid(false)
                .build();
        billMap.put(bill.getBillId(), bill);
        return bill;
    }

    public void markPaid(long billId) {
        Bill bill = billMap.get(billId);
        if (bill == null) {
            throw new IllegalArgumentException("Bill not found");
        }
        bill.setPaid(true);
    }

    public Bill getBillById(long billId) {
        return billMap.get(billId);
    }
}
