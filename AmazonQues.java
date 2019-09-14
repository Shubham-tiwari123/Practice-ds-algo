package socketpro;

import java.util.LinkedList;
import java.util.Queue;
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
        for(int i=0;i<4;i++){
            newNode = new Node();
            newNode.data = 1;
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
        head.next.data=1;
        head.next.next.data=1;
        head.next.next.next.data=3;
        System.out.println("Print List");
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        removeDuplicate(head);
        //temp = head.next.next;
        //deleteWithoutHeadPointer(temp);
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
    
    void YshapedList(Node headA,Node headB){
        Node tempA=headA;
        Node tempB=headB;
        int count1=0;
        int count2=0;
        while(tempA!=null || tempB!=null){
            if(tempA!=null){
                count1++;
                tempA=tempA.next;
            }
            if(tempB!=null){
                count2++;
                tempB=tempB.next;
            }
        }
        if(count1>count2){
            int diff= count1-count2;
            tempA=headA;
            tempB=headB;
            for(int i=0;i<diff;i++)
                tempA=tempA.next;
            while(tempA!=tempB){
                if(tempA.next!=tempB.next){
                    tempA = tempA.next;
                    tempB = tempB.next;
                }
                else{
                    System.out.println("Found:-"+tempA.next.data+" tempB:-"+tempB.next.data);
                    break;
                }
            }
        }
        else if(count2>count1){
            System.out.println("elif");
            int diff= count2-count1;
            tempA=headA;
            tempB=headB;
            for(int i=0;i<diff;i++)
                tempB=tempB.next;
            while(tempA!=tempB){
                if(tempA.next!=tempB.next){
                    tempA = tempA.next;
                    tempB = tempB.next;
                }
                else{
                    System.out.println("Found:-"+tempA.next.data+" tempB:-"+tempB.next.data);
                    break;
                }
            }
        }
        else{
            tempA=headA;
            tempB=headB;
            while(tempA!=tempB){
                if(tempA.next!=tempB.next){
                    tempA = tempA.next;
                    tempB = tempB.next;
                }
                else{
                    System.out.println("Found:-"+tempA.next.data+" tempB:-"+tempB.next.data);
                    break;
                }
            }
        }       
    }
    
    void removeDuplicate(Node root){
        Node temp1 = root;
        Node temp2 = temp1.next;
        while(temp2!=null){
            if(temp1.data!=temp2.data){
                temp1.next=temp2;
                temp1 = temp2;
                temp2=temp2.next;
            }
            else{
                temp2 = temp2.next;
                temp1.next=temp2;
            }
        }
        System.out.println("\nPrint List2");
        Node temp=root;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    
    void countPairs(LinkedList<Integer> head1,LinkedList<Integer> head2 , int x){
        int count=0;
        for(int i=0;i<head1.size();i++){
            if(head2.contains(x-head1.get(i)))
                count++;
        }
        System.out.println("count:-"+count);
    }
}
