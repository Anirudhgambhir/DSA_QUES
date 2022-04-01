QUESTION: https://leetcode.com/problems/ransom-note/

public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;
        int[] ch = new int[26];
        for(int i=0;i<magazine.length();i++){
            ch[magazine.charAt(i) - 'a'] += 1;
        }
        for(int j=0;j<ransomNote.length();j++){
            ch[ransomNote.charAt(j) - 'a'] -= 1;
        }
        for(int k=0;k<ch.length;k++){
            if(ch[k] < 0)
                return false;
        }
        return true;
    }
