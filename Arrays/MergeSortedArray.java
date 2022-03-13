QUESTION: https://leetcode.com/problems/merge-sorted-array/submissions/

public void merge(int[] a, int m, int[] b, int n) { 
        int i = a.length-1;
        int left = m-1;
        int right = n-1;
        if(n!=0){
            while(left >= 0 && right >= 0){
                if(a[left] >= b[right]){
                    a[i] = a[left];
                    left--;
                }
                else if(a[left] < b[right]){
                    a[i] = b[right];
                    right--;
                }
                i--;
            }
            while(left>=0){
                a[i] = a[left];
                left--;i--;
            }
            while(right>=0){
                a[i] = b[right];
                right--;i--;
            }
        }
       
        
    }
