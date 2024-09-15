package learn;

import experiment.DI;

import java.util.Optional;

public class OptionalTest {

    DI object = new DI();

    public static void main(String[] args) {
        OptionalTest.testing();
    }
    public static void testing() {
        String a = "AAAAAAAAAAAAAA";
        int s = Optional.ofNullable(a)
                .map(String::length)
                .map(Integer::bitCount)
                .orElse(-1);
        System.out.println("VALUE - " + s);
    }
}
