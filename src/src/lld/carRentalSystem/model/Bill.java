package lld.carRentalSystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Bill {
    private long billId;
    private long reservationId;
    private long totalAmount;
    private boolean paid;
}
