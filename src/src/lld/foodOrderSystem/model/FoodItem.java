package lld.foodOrderSystem.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodItem {

    private String itemName;

    private String itemDescription;

    private String addOns;

}
