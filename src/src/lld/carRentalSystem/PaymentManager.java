package lld.carRentalSystem;

import lld.carRentalSystem.model.Bill;
import lld.carRentalSystem.model.Payment;
import lld.carRentalSystem.model.PaymentMode;
import lld.carRentalSystem.payment.CreditCardPaymentStrategy;
import lld.carRentalSystem.payment.DebitCardPaymentStrategy;
import lld.carRentalSystem.payment.PaymentStrategy;
import lld.carRentalSystem.payment.UpiPaymentStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentManager {

    private static final AtomicLong ID_COUNTER = new AtomicLong(1);

    private final Map<PaymentMode, PaymentStrategy> strategyMap = new HashMap<PaymentMode, PaymentStrategy>() {{
        put(PaymentMode.CREDIT_CARD, new CreditCardPaymentStrategy());
        put(PaymentMode.DEBIT_CARD, new DebitCardPaymentStrategy());
        put(PaymentMode.UPI, new UpiPaymentStrategy());
    }};

    private final ConcurrentHashMap<Long, Payment> paymentMap = new ConcurrentHashMap<>();
    private final BillingManager billingManager;

    public PaymentManager(BillingManager billingManager) {
        this.billingManager = billingManager;
    }

    public Payment processPayment(long billId, PaymentMode paymentMode) {
        Bill bill = billingManager.getBillById(billId);
        if (bill == null) {
            throw new IllegalArgumentException("Bill not found");
        }
        if (bill.isPaid()) {
            throw new IllegalStateException("Bill is already paid");
        }

        PaymentStrategy strategy = strategyMap.get(paymentMode);
        boolean success = strategy.pay(bill.getTotalAmount());

        Payment payment = Payment.builder()
                .paymentId(ID_COUNTER.getAndIncrement())
                .billId(billId)
                .amount(bill.getTotalAmount())
                .paymentMode(paymentMode)
                .success(success)
                .build();
        paymentMap.put(payment.getPaymentId(), payment);

        if (success) {
            billingManager.markPaid(billId);
        }
        return payment;
    }
}
