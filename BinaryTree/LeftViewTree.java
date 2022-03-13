QUESTION: https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1/

ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        fillList(root,list,0);
        return list;
    }
    
    void fillList(Node root,List<Integer> list,int level){
        if(root == null){
            return;
        }
        if(level >= list.size()){
            list.add(level,root.data);
        }
        else if(list.get(level) == null){
            list.set(level,root.data);
        }
        fillList(root.left,list,level+1);
        fillList(root.right,list,level+1);
    }
