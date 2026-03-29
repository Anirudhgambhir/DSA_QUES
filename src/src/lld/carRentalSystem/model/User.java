package lld.carRentalSystem.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {

    private long userId;
    private String drivingLicenseNo;
    private String userName;
}
