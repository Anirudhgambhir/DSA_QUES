package lld.carRentalSystem.payment;

public class DebitCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(long amount) {
        // process debit card payment
        return true;
    }
}
