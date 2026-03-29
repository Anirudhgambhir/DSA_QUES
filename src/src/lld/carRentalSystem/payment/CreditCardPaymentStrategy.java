package lld.carRentalSystem.payment;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(long amount) {
        // process credit card payment
        return true;
    }
}
