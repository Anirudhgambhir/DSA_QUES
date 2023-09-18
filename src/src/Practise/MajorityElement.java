package Practise;

public class MajorityElement {
    static int majorityElement(int a[], int size)
    {
        int ans = 0;
        int count = 0;

        // To check if there is any element
        for (int i = 0; i < size; i++){
            if(a[i] == a[ans]){
                count++;
            }
            else {
                count--;
            }

            if (count == 0){
                ans = i;
                count = 1;
            }
        }

        // If there is a majority element get its count.
        if(count > 0){
            count = 0;
            for (int i = 0; i< size; i++){
                if (a[i] ==  a[ans])
                    count++;
            }

            if (count > size/2)
                return a[ans];
        }
        return -1;
    }
}
