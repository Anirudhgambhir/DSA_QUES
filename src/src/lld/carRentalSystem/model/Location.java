package lld.carRentalSystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Location {
    private long locationId;
    private String address;
    private String city;
    private String state;
    private String zipCode;
}
