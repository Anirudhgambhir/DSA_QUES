package learn.java;

import java.time.DateTimeException;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            handler();
        } catch (Exception e) {
            System.out.println("main exception caught =>" + e.getMessage());
            System.out.println("main exception cause caught =>" + e.getCause().getMessage());
        }
    }

    public static void handler() {
        try {
            throwExceptions(1);
        } catch (ArithmeticException e) {
            System.out.println("Handler exception caught =>" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void throwExceptions(int i) {
        switch (i) {
            case 1:
                throw new ArithmeticException("Exception occured");
            case 2:
                throw new DateTimeException("Exception occured 2");
            default:
                throw new RuntimeException("Exception is Runtime");
        }
    }
}
