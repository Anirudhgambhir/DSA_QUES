package practise;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length() - 1, n = num2.length() - 1;
        int val1 = 0, val2 = 0;
        int multiplier = 1;
        while (m >= 0) {
            val1 += Integer.parseInt(String.valueOf(num1.charAt(m--))) * multiplier;
            multiplier *= 10;
        }
        multiplier = 1;
        while (n >= 0) {
            val2 += Integer.parseInt(String.valueOf(num2.charAt(n--))) * multiplier;
            multiplier *= 10;
        }
        return String.valueOf(val1 * val2);
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("123", "456"));
    }
}
