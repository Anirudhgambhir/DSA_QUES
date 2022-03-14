QUESTION: https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1

//BRUTE FORCE APPROACH
public Node removeDuplicates(Node head) 
    {
        
         Node temp = head;
         while(temp != null && temp.next != null){
             Node temp1 = temp;
             while(temp1.next != null){
                if(temp.data == temp1.next.data){
                 temp1.next = temp1.next.next;
                }
                else{
                 temp1 = temp1.next;
                }
             }
             temp = temp.next;
         }
         return head;
}

// OPTIMISED APPROACH
public Node removeDuplicates(Node head) {
        Set<Integer> set = new HashSet<Integer>();    
        set.add(head.data);
        Node temp = head;
        while(temp != null && temp.next != null){
            if(set.contains(temp.next.data)){
                temp.next = temp.next.next;
            }
            else{
                set.add(temp.next.data);
                temp = temp.next;
            }
        }
        return head;
    }
