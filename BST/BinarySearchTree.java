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

class DLL{
    int data;
    DLL left;
    DLL right;

    public DLL(int data) {
        this.data = data;
        this.left=null;
        this.right=null;
    }
}

class LinkList{
    int data;
    LinkList next;

    public LinkList(int data) {
        this.data = data;
        this.next=null;
    }
}
public class BinarySearchTree {
    Scanner sc = new Scanner(System.in);
    BinarySearch root=null;
    static DLL dllRoot=null;
    LinkList head = null;
    
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
    
    //handling only one child or no child
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
    
    int distanceFromRoot(BinarySearch root,int val){
        if(root.data==val)
            return 0;
        else if(root.data>val)
            return 1+distanceFromRoot(root.left, val);
        else
            return 1+distanceFromRoot(root.right, val);
    }
    
    int distanceBetween2(BinarySearch root,int a,int b){
        if(root==null)
            return 0;
        if(root.data>a && root.data>b)
            return distanceBetween2(root.left, a, b);
        if(root.data<a && root.data<b)
            return distanceBetween2(root.right, a, b);
        if(root.data>=a && root.data<=b)
            return distanceFromRoot(root, a)+distanceFromRoot(root, b);
        return 0;
    }
    
    //Lowest common ancestor:-
    void LCA(BinarySearch root, int a,int b){
        BinarySearch temp=root;
        while (temp!=null) {            
            if(temp.data>a && temp.data>b)
                temp=temp.left;
            else if(temp.data<a && temp.data<b)
                temp= temp.right;
            else
                break;
        }
        System.out.print("\nLCA of "+a+" and "+b+" is:"+temp.data);
    }
    
    boolean isBST(BinarySearch root,BinarySearch left,BinarySearch right){
        if(root==null)
            return true;
        if(left!=null && root.data<=left.data)
            return false;
        if(right!=null && root.data>right.data)
            return false;
        return isBST(root.left, left, root) && isBST(root.right, root   , right);
    }
    
    void createDll(int data){
        DLL newNode = new DLL(data);
        if(dllRoot==null)
            dllRoot = newNode;
        else{
            DLL dllTemp = dllRoot;
            while(dllTemp.right!=null)
                dllTemp=dllTemp.right;
            dllTemp.right=newNode;
            newNode.left = dllTemp;
        }
    }
    void bstToDLL(BinarySearch root){
        if(root==null)
            return;
        bstToDLL(root.left);
        createDll(root.data);
        bstToDLL(root.right);
    }
    DLL getDLLRoot(){
        return dllRoot;
    }
    void printDLL(DLL root){
        while(root!=null){
            System.out.print(root.data+" ");
            root = root.right;
        }
    }
    
    void createList(int data){
        LinkList node = new LinkList(data);
        if(head==null)
            head=node;
        else{
            LinkList temp = head;
            while(temp.next!=null)
                temp=temp.next;
            temp.next=node;
        }
    }
    void sortedLLToBST(){
        createList(1);
        createList(2);
        createList(3);
        createList(4);
        createList(5);
        createList(6);
        createList(7);
        BinarySearch rootTemp = createBSTFromLL(7);
        System.out.print("\nPrinting list to bst:-");
        levelOrderBST(rootTemp);
    }
    BinarySearch createBSTFromLL(int len){
        if(len<=0)
            return null;
        BinarySearch left = createBSTFromLL(len/2);
        BinarySearch newRoot = new BinarySearch(head.data);
        newRoot.left = left;
        head = head.next;
        newRoot.right = createBSTFromLL(len-len/2-1);
        return newRoot;
    }
}
