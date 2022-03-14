QUESTION: https://practice.geeksforgeeks.org/problems/check-for-bst/1/

boolean isBST(Node root)
    {
        // code here.
        if(root == null){
            return true;
        }
        return checkValue(root,null,null);
    }
    
    private boolean checkValue(Node root, Integer min,Integer max){
        if(root == null){
            return true;
        }
        else if(min != null && root.data < min || max != null && root.data > max ){
            return false;
        }
        return checkValue(root.left, min, root.data) && checkValue(root.right, root.data, max);
    }
