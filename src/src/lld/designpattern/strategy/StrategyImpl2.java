package lld.designpattern.strategy;

public class StrategyImpl2 implements Strategy{
    @Override
    public void processRequest(String input) {
        System.out.println("STRATEGY 2 - " + input);
    }
}
