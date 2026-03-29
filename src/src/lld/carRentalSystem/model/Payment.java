package lld.carRentalSystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Payment {
    private long paymentId;
    private long billId;
    private long amount;
    private PaymentMode paymentMode;
    private boolean success;
}
