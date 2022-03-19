QUESTION: https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1#

public static Node addOne(Node head) 
    { 
        //code here.
        head = reverseList(head);
        Node temp = head;
        while(temp != null){
            if(temp.data < 9){
                temp.data++;
                break;
            }
            else{
                temp.data = 0;
                if(temp.next != null){
                    temp = temp.next;
                }
                else{
                    Node n = new Node(1);
                    temp.next = n;
                    break;
                }
                
            }
        }
        return reverseList(head);
    }
    
    public static Node reverseList(Node head){
        Node curr = head;
        Node next = null;
        Node prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
