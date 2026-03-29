package lld.designpattern.strategy;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StrategySelector {

    Strategy selctStrategy(int strategyNumber) throws IllegalAccessException {
        if (strategyNumber == 1) {
            return new StrategyImpl1();
        } else if (strategyNumber == 2) {
            return new StrategyImpl2();
        }
        else {
            throw new IllegalAccessException("NO STRATEGY DEFINED");
        }
    }
}
