QUESTION: https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1/

String reverseWords(String S)
    {
        char[] ch = S.toCharArray();
        int behind=-1;
        for(int i=0;i<ch.length;i++){
            if(ch[i] == '.'){
                reverse(ch,behind+1,i-1);
                behind = i;
            }
        }
        reverse(ch,behind+1,ch.length-1);
        reverse(ch,0,ch.length-1); 
        return String.valueOf(ch);
        // code here 
    }
    
    void reverse(char[] ch, int left, int right){
        if(left == right){
            return ;
        }
        while(left<right){
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
            
        }
    }
