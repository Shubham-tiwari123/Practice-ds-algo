package practicetree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    //DLR
    void preOrder(TreeNode node){
        if(node==null)
            return;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    //LDR
    void inOrder(TreeNode node){
        if(node==null)
            return;
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    //LRD
    void postOrder(TreeNode node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }
    
    void levelOrder(TreeNode node){
        Queue<TreeNode> q =new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode temp= q.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
    }
    
    void findMax(TreeNode node){
        Queue<TreeNode> q =new LinkedList<>();
        q.add(node);
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            TreeNode temp= q.poll();
            if(temp.data>max)
                max=temp.data;
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        System.out.print("\nMax:-"+max);
    }
    
    void searchElement(TreeNode node,int val){
        Queue<TreeNode> q =new LinkedList<>();
        q.add(node);
        boolean flag=false;
        int position=0;
        while(!q.isEmpty()){
            TreeNode temp= q.poll();
            position++;
            if(temp.data==val){
                flag=true;
                break;
            }
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        if(flag)
            System.out.print("\nElement found at position:-"+position);
        else
            System.out.print("\nNot found");
    }
    
    void insertElement(TreeNode node,int val){
        Queue<TreeNode> q =new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode temp= q.poll();
            if(temp.left==null || temp.right==null){
                if(temp.left==null){
                    TreeNode newNode = new TreeNode(val);
                    temp.left=newNode;
                    break;
                }
                else{
                    TreeNode newNode = new TreeNode(val);
                    temp.left=newNode;
                    break;
                }
            }
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        System.out.print("\nElement inserted...level order of new tree:-\n");
        levelOrder(node);
    }
    //number of element
    void sizeOfTree(TreeNode node){
        Queue<TreeNode> q =new LinkedList<>();
        if(node==null)
            System.out.print("\nSize of tree is 0");
        else{
            q.add(node);
            int size=0;
            while(!q.isEmpty()){
                TreeNode temp= q.poll();
                size++;
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            System.out.print("\nSize of tree is:"+size);
        }
    }
    
    void deleteElement(TreeNode node,int val){
        Queue<TreeNode> q =new LinkedList<>();
        TreeNode tempNode = null;
        TreeNode lastNode;
        TreeNode temp = null;
        int lastValue = 0;
        q.add(node);
        while(!q.isEmpty()){
            temp= q.poll();
            lastValue=temp.data;
            if(temp.data == val){
                tempNode = temp;
            }
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        tempNode.data = lastValue;
        lastNode = temp;
        q.add(node);
        while(!q.isEmpty()){
            temp= q.poll();
            if(temp.left!=null){
                if(temp.left==lastNode){
                    temp.left=null;
                    break;
                }
                q.add(temp.left);
            }
            if(temp.right!=null){
                if(temp.right==lastNode){
                    temp.right=null;
                    break;
                }
                q.add(temp.right);
            }
        }
    }
}
