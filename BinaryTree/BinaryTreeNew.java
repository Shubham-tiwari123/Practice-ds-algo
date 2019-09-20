package practicetree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeNew {
    
    void traverseTreeZigZag(TreeNode node){
        System.out.print("\nZig-Zag:-");
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(node);
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                TreeNode temp = s1.pop();
                System.out.print(temp.data+" ");
                if(temp.left!=null)
                    s2.push(temp.left);
                if(temp.right!=null)
                    s2.push(temp.right);
            }
            while(!s2.isEmpty()){
                TreeNode temp = s2.pop();
                System.out.print(temp.data+" ");
                if(temp.right!=null)
                    s1.push(temp.right);
                if(temp.left!=null)
                    s1.push(temp.left);
            }
        }
        
    }
    
    void connectSiblings(SiblingTree root){
        Queue<SiblingTree> q1 = new LinkedList<>();
        Queue<SiblingTree> q2 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()||!q2.isEmpty()){
            while(!q1.isEmpty()){
                SiblingTree temp = q1.poll();
                if(q1.isEmpty()){
                    temp.nextSibling=null;
                }
                else{
                    temp.nextSibling=q1.peek();
                }
                if(temp.left!=null)
                    q2.add(temp.left);
                if(temp.right!=null)
                    q2.add(temp.right);
            }
            while(!q2.isEmpty()){
                SiblingTree temp = q2.poll();
                if(q2.isEmpty()){
                    temp.nextSibling=null;
                }
                else{
                    temp.nextSibling=q2.peek();
                }
                if(temp.left!=null)
                    q1.add(temp.left);
                if(temp.right!=null)
                    q1.add(temp.right);
            }
        }
        taverseSibling(root);
    }
    
    void taverseSibling(SiblingTree root){
        Queue<SiblingTree> q = new LinkedList<>();
        q.add(root);
        SiblingTree temp = root;
        while(temp.left!=null){
            SiblingTree temp1 = temp;
            while(temp1!=null){
                System.out.println(temp1.data);
                temp1 = temp1.nextSibling;
            }
            if(temp.left!=null && temp.right==null){
                temp = temp.left;
            }
            else if(temp.left==null && temp.right!=null){
                temp = temp.right;
            }
            else if(temp.left!=null && temp.right!=null)
                temp=temp.left;
        }
    }
}
