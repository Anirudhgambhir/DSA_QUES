package lld.designpattern.strategy;

public class DemoStrategyMain {
    public static void main(String[] args) throws IllegalAccessException {

        String input = "ANIRUDH";

        StrategySelector.selctStrategy(1).processRequest(input);
        StrategySelector.selctStrategy(2).processRequest(input);
    }
}
