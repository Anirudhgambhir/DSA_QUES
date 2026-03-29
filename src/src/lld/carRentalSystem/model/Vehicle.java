package lld.carRentalSystem.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class Vehicle {

    private long vehicleId;
    private String vehicleNumber;
    private long dailyRental;
    private VehicleStatus vehicleStatus;
    private VehicleType vehicleType;

}
