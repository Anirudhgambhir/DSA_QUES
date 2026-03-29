package lld.carRentalSystem.payment;

public interface PaymentStrategy {
    boolean pay(long amount);
}
