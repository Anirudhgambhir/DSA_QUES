package lld.carRentalSystem.payment;

public class UpiPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(long amount) {
        // process UPI payment
        return true;
    }
}
