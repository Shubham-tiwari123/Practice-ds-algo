package treeque;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node right=null;
    Node left = null;
    public Node(int data){
        this.data = data;
        right=left=null;
    }
}
public class TreeQue {
    
    void printInorder(Node temp){
        if(temp==null)
            return;
        printInorder(temp.left);
        System.out.print(temp.data+" ");
        printInorder(temp.right);
    }
    
    //Delete a node from tree
    
    void deleteNode(Node root,Node d_node){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null;
        Node val = null;
        while(!q.isEmpty()){
            temp = q.peek();
            q.poll();
            if(temp == d_node){
                temp=null;
                return;
            }
            if(temp.left!=null){
                if(temp.left==d_node){
                    temp.left=null;
                    return;
                }
                else
                    q.add(temp.left);
            }
            if(temp.right!=null){
                if(temp.right==d_node){
                    temp.right=null;
                    return;
                }
                else
                    q.add(temp.right);
            }
        }
    }
    
    Node findLastNode(int data,Node root){
        if(root == null)
            return null;
        if(root.left==null && root.right==null){
            if(root.data==data)
                return null;
            else
                return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null;
        Node val = null;
        while(!q.isEmpty()){
            temp = q.peek();
            q.poll();
            if(temp.data == data)
                val = temp;
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        if(val!=null){
            int x = temp.data;
            deleteNode(root, temp);
            val.data=x;
        }
        return root;
    }
    
    //level order traversal or breadth first search 
    void levelOrderTraversel(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp;
        while(!q.isEmpty()){
            temp=q.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
    }
    //size of tree is the number of elements in the tree
    void sizeOfTree(Node root){
        int count=0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp;
        while(!q.isEmpty()){
            temp=q.poll();
            count++;
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        System.out.println("\n\nSize:-"+count);
    }
    
    void heightOfTree(Node root){
        int height=0;
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        boolean flag1=true;
        boolean flag2=true;
        q1.add(root);
        Node temp;
        while(!q1.isEmpty()||!q2.isEmpty()){
            while(!q1.isEmpty()){
                temp=q1.poll();
                if(temp.left!=null)
                    q2.add(temp.left);
                if(temp.right!=null)
                    q2.add(temp.right);
                flag1=true;
                flag2=false;
            }
            if(flag1)
                height++;
            while(!q2.isEmpty()){
                temp=q2.poll();
                if(temp.left!=null)
                    q1.add(temp.left);
                if(temp.right!=null)
                    q1.add(temp.right);
                flag1=false;
                flag2=true;
            }
            if(flag2)
                height++;
        }
        System.out.println("\n\nHeight:-"+height);
    }
    
    public static void main(String[] args) {
        Node head = new Node(10);
        head.left = new Node(11);
        head.right= new Node(9);
        head.left.left = new Node(7);
        head.left.right = new Node(12);
        head.right.left = new Node(15);
        head.right.right = new Node(8);
        TreeQue que = new TreeQue();
        que.printInorder(head);
        /*head = que.findLastNode(11, head);
        System.out.println("\n\n");
        que.printInorder(head);*/
        System.out.print("\n\nLevel order\n");
        que.levelOrderTraversel(head);
        que.sizeOfTree(head);
        que.heightOfTree(head);
    }
}
