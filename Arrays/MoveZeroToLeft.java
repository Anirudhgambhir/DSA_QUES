

void moveZerosToLeft(int[] A) {
    //TODO: Write - Your - Code
    int left =A.length-1,right = A.length-1;
        if(A.length > 1){
           while(right >= 0){
            if(A[right] == 0){
                right--;
                continue;
            }
            else if(A[right] != 0 && A[left] == 0){
                int temp = A[right];
                A[right] = A[left];
                A[left] = temp;
                
            }
            right--; left--;
        } 
        }
  }
