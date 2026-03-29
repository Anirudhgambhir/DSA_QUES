package lld.carRentalSystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class Reservation {
    private long reservationId;
    private long vehicleId;
    private long userId;
    private ReservationStatus reservationStatus;
    private Date startDate;
    private Date endDate;
}
