package Practise;

public class UnionOfSortedArrays {

    public static void main(String[] args) {
        new UnionOfSortedArrays().union(new int[]{1,2,3,4,4,4,5}, new int[]{2,3,3,3,4,4,4,5,5,6});
    }
    void union(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            if (a[i] < b[j])
                System.out.println(a[i++]);
            else if (a[i] > b[j])
                System.out.println(b[j++]);
            else {
                System.out.println(a[i++]);
                j++;
            }
        }
    }
}
