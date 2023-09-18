package Practise;

public class RemoveAllDuplicatesFromGivenString {
    String removeDuplicatesEfficient(String str) {
        //NAIVE solution
        char[] a = str.toCharArray();
        String ans = "";
        boolean[] arr = new boolean[58];
        for(int i = 0; i<a.length; i++){
            if(!arr[a[i] - 'A']){
                arr[a[i] - 'A'] = true;
                ans += a[i];
            }

        }
        return ans;
    }

    String removeDuplicatesNaive(String str) {
        //NAIVE solution
        char[] a = str.toCharArray();
        String ans = "";
        int count = 0;
        for(int i = 0; i<a.length; i++){
            int j = 0;
            for(j = 0; j < i; j++){
                if (a[i] == a[j]){
                    break;
                }
            }
            if(i == j){
                ans += a[i];
            }
        }
        return ans;
    }
}
