package Practise;

public class NumberOfTimesArrayIsRotated {
    public static void main(String[] args) {

        System.out.println(findKRotation(new int[]{2, 3, 4, 1}));
    }

    public static int findKRotation(int []arr){
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] < arr[(mid + arr.length -1) % arr.length] && arr[mid] < arr[(mid + 1) % arr.length])
                return mid;
            else if (arr[mid] < arr[j])
                j = mid - 1;
            else
                i = mid + 1;
        }
        return 0;
    }
}
