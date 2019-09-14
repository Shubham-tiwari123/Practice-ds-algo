package socketpro;

import java.util.Stack;

class Node{
    int data;
    Node next;
}
public class AmazonQues {
    Node head=null;
    Node headA=null;
    Node headB=null;
    void addNode(){
        
        Node newNode;
        for(int i=0;i<5;i++){
            newNode = new Node();
            newNode.data = i;
            newNode.next=null;
            
            if(head==null)
                head=newNode;
            else{
                Node temp = head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=newNode;
            }
        }
        System.out.println("Print List");
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        temp = head.next.next;
        deleteWithoutHeadPointer(temp);
    }
    
    void deleteWithoutHeadPointer(Node temp){
        temp.data = temp.next.data;
        temp.next=temp.next.next;
        System.out.println("data\n");
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    
    void checkPalindrome(){
        Stack<Integer> s = new Stack<>();
        Node temp=head;
        boolean flag=true;
        while(temp!=null){
            s.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.data!=s.pop()){
                flag = false;
                break;
            }
            else{
                temp = temp.next;
            }
        }
        if(flag)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
    
    void createTwoList(){
        for(int i=0;i<5;i++){
            Node newNode = new Node();
            newNode.data=i;
            newNode.next=null;
            if(headA==null)
                headA=newNode;
            else{
                Node temp= headA;
                while(temp.next!=null)
                    temp=temp.next;
                temp.next=newNode;
            }
        }
        int num=90;
        for(int i=0;i<2;i++){
            Node newNode = new Node();
            newNode.data=num;
            newNode.next=null;
            if(headB==null)
                headB=newNode;
            else{
                Node temp= headB;
                while(temp.next!=null)
                    temp=temp.next;
                temp.next=newNode;
            }
            num++;
        }
        Node temp=headB;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = headA.next.next.next;
        
        YshapedList(headA, headB);
    }
    
    
    
}
