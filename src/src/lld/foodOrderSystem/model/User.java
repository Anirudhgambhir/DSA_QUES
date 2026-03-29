package lld.foodOrderSystem.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String userName;

    private String userAddress;

    private boolean isUPIEnabled;

    private long walletBalance;
}
