package revision;

public class Count_Digits {

    public static void main(String[] args) {
        evenlyDivides(12);
    }


    static int evenlyDivides(int N){
        int ans = 0;
        int temp = N;
        while (temp > 0) {
            double divisor = temp % 10;
            temp = temp / 10;
            float val = (float) (N % divisor);
            ans = (float) (N % divisor) == 0 ? ans + 1 : ans;
        }
        return ans;
    }
}
