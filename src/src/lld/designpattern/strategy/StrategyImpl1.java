package lld.designpattern.strategy;

public class StrategyImpl1 implements Strategy{
    @Override
    public void processRequest(String input) {
        System.out.println("Strategy 1 - impl - " + input);
    }
}
