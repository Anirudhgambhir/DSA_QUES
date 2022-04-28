static ArrayList<String> powerSet(String s)
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        return subsets(s,0,list);
    }
    
    public static ArrayList<String> subsets(String s, int i, ArrayList<String> list){
        
        if(i == s.length()-1){
            list.add(s);
        }
        for(int j = i; j<s.length();j++){
            s = swap(s,i,j);
            subsets(s,i+1,list);
            s = swap(s,i,j);
        }
        return list;
    }
    
    public static String swap(String s, int i, int j){
        char[] ch = s.toCharArray();
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
        return String.valueOf(ch);
    }
