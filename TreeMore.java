package treeque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeMore {
    
    //boundry traversal of tree
    void boundryTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp;
        Queue<Integer> leaves = new LinkedList<>();
        Queue<Integer> left = new LinkedList<>();
        Queue<Integer> right = new LinkedList<>();
        while(!q.isEmpty()){
            temp = q.poll();
            if(temp.right==null && temp.left==null)
                leaves.add(temp.data);
            else{
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
        }
        q.add(root);
        while(!q.isEmpty()){
            temp = q.poll();
            if(temp.left!=null){
                left.add(temp.data);
                q.add(temp.left);
            }
            else if(temp.right!=null){
                right.add(temp.data);
                q.add(temp.right);
            }
        }
        q.add(root.right);
        while(!q.isEmpty()){
            temp = q.poll();
            if(temp.right!=null){
                right.add(temp.data);
                q.add(temp.right);
            }
            else if(temp.left!=null){
                right.add(temp.data);
                q.add(temp.left);
            }
        }
        System.out.println(left);
        System.out.println(leaves);
        System.out.println(right);
    }
    //zig zag spiral traversal
    void zigzagSpiralTraversal(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.add(root);
        Node temp;
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                temp=s1.pop();
                System.out.print(temp.data+" ");
                if(temp.left!=null)
                    s2.add(temp.left);
                if(temp.right!=null)
                    s2.add(temp.right);
            }
            while(!s2.isEmpty()){
                temp=s2.pop();
                System.out.print(temp.data+" ");
                if(temp.right!=null)
                    s1.add(temp.right);
                if(temp.left!=null)
                    s1.add(temp.left);
            }
        }
    }
    //given tree print mirror image of tree
    void mirrorImage(Node root){
        Queue<Node> mirror = new LinkedList<>();
        Node temp;
        mirror.add(root);
        while(!mirror.isEmpty()){
            temp=mirror.poll();
            System.out.print(temp.data+" ");
            if(temp.right!=null)
                mirror.add(temp.right);
            if(temp.left!=null)
                mirror.add(temp.left);
        }
    }
    //check if tree is mirror of itself
    void checkMirror(Node root1,Node root2){
        Node temp1;
        Node temp2;
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(root1);
        q2.add(root2);
        boolean flag=true;
        while(!q1.isEmpty() && !q2.isEmpty()){
            temp1=q1.poll();
            temp2=q2.poll();
            if(temp1.data!=temp2.data){
                flag=false;
                break;
            }
            else if(temp1.left==null && temp2.right!=null){
                flag=false;
                break;
            }
            else if(temp1.right==null && temp2.left!=null){
                flag=false;
                break;
            }
            else{
                if(temp1.left!=null && temp2.right!=null){
                    q1.add(temp1.left);
                    q2.add(temp2.right);
                }
                if(temp1.right!=null && temp2.left!=null){
                    q1.add(temp1.right);
                    q2.add(temp2.left);
                }
            }
        }
        if(flag)
            System.out.println("Mirror");
        else
            System.out.println("Not mirror");
    }
}
