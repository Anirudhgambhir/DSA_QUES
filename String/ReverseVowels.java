QUESTION: https://leetcode.com/problems/reverse-vowels-of-a-string/

public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o');
        set.add('u'); set.add('A'); set.add('E'); set.add('I');
        set.add('O'); set.add('U');
        char[] str = s.toCharArray();
        int i = 0;
        int j = str.length - 1;
        while(i < j){
            if(!set.contains(str[i]))
                i++;
            if(!set.contains(str[j]))
                j--;
            if(set.contains(str[i]) && set.contains(str[j])){
                char ch = str[i];
                str[i] = str[j];
                str[j] = ch;
                i++;
                j--;
            }
        }
        return new String(str);
    }
