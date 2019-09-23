package practicetree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinarySearch{
    int data;
    BinarySearch left;
    BinarySearch right;

    public BinarySearch(int data) {
        this.data = data;
        this.left=null;
        this.right=null;
    }
}

public class BinarySearchTree {
    Scanner sc = new Scanner(System.in);
    BinarySearch root=null;
    
    BinarySearch createBST(){
        int totalData = sc.nextInt();
        for(int i=0;i<totalData;i++){
            int data = sc.nextInt();
            BinarySearch newNode = new BinarySearch(data);
            if(root==null)
                root=newNode;
            else{
                BinarySearch temp = root;
                BinarySearch temp1=temp;
                while(temp!=null){
                    if(temp.data>data){
                        temp1=temp;
                        temp=temp.left;
                    }
                    else{
                        temp1=temp;
                        temp=temp.right;
                    }
                }
                if(temp1.data>data)
                    temp1.left=newNode;
                else
                    temp1.right=newNode;
            }
        }
        return root;
    }
    
    void levelOrderBST(BinarySearch node){
        Queue<BinarySearch> q =new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            BinarySearch temp= q.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
    }
    
    void insertNodeBST(BinarySearch root,int data){
        BinarySearch newNode = new BinarySearch(data);
        BinarySearch temp = root;
        BinarySearch temp1 = temp;
        while(temp!=null){
            if(temp.data>data){
                temp1=temp;
                temp=temp.left;
            }
            else{
                temp1=temp;
                temp=temp.right;
            }
        }
        if(temp1.data>data)
            temp1.left=newNode;
        else
            temp1.right=newNode;
    }
    
    void searchData(BinarySearch root,int data){
        BinarySearch temp=root;
        boolean flag =false;
        while(temp!=null){
            if(temp.data==data){
                flag = true;
                break;
            }
            else if(temp.data>data){
                temp = temp.left;
            }
            else if(temp.data<=data){
                temp = temp.right;
            }
        }
        if(flag)
            System.out.print("\nData found");
        else
            System.out.print("\nData notfound");
        
    }
    
    void findMax(BinarySearch root){
        BinarySearch temp = root;
        while(temp.right!=null)
            temp=temp.right;
        System.out.print("\nmax found:-"+temp.data);
    }
    
    void findMin(BinarySearch root){
        BinarySearch temp = root;
        while(temp.left!=null)
            temp=temp.left;
        System.out.print("\nMin found:-"+temp.data);
    }
    
    void deleteNode(BinarySearch root,int data){
        BinarySearch temp=root;
        BinarySearch temp1=temp;
        boolean flag =false;
        while(temp!=null){
            if(temp.data==data){
                flag = true;
                break;
            }
            else if(temp.data>data){
                temp1=temp;
                temp = temp.left;
            }
            else if(temp.data<=data){
                temp1=temp;
                temp = temp.right;
            }
        }
        if(flag){
            if(temp.left==null && temp.right==null){
                if(temp1.data<temp.data)
                    temp1.right=null;
                else
                    temp1.left=null;
            }
            else if(temp.left!=null && temp.right==null){
                if(temp1.data<temp.data)
                    temp1.right=temp.left ;
                else
                    temp1.left=temp.left;
            }
            else if(temp.left==null && temp.right!=null){
                if(temp1.data<temp.data)
                    temp1.right=temp.right ;
                else
                    temp1.left=temp.right;
            }
        }
    }
}
