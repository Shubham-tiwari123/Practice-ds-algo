package practicetree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
                    temp.right=newNode;
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
    
    void printLevelOrderReverse (TreeNode node){
        Stack<Integer> ans = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            ans.push(temp.data);
            if(temp.right!=null)
                q.add(temp.right);
            if(temp.left!=null)
                q.add(temp.left);
        }
        System.out.print("\nReverse lvel order:-");
        while(!ans.empty())
            System.out.print(" "+ans.pop());
    }
    
    void deepestNode(TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        int lastNode = 0;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            lastNode = temp.data;
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        System.out.print("\nLast node:-"+lastNode);
    }
    
    void totalLeaves(TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        int count = 0;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left==null && temp.right==null)
                count++;
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        System.out.print("\nTotal leave nodes:-"+count);
    }
    
    void fullNodes(TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        int count = 0;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left!=null && temp.right!=null)
                count++;
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        System.out.print("\nTotal full nodes:-"+count);
    }
    
    void halfNodes(TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        int count = 0;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left!=null && temp.right==null)
                count++;
            if(temp.left==null && temp.right!=null)
                count++;
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        System.out.print("\nHalf nodes:-"+count);
    }
    
    void checkTwoTreeStructuralIdentical(TreeNode head1, TreeNode head2){
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2= new LinkedList<>();
        q1.add(head1);
        q2.add(head2);
        boolean flag=true;
        while(!q1.isEmpty()){
            TreeNode temp1 = q1.poll();
            TreeNode temp2 = q2.poll();
            
            if((temp1.left==null && temp2.left!=null)||(temp1.right==null && temp2.right!=null)){
                flag =false;
                break;
            }
            if((temp1.left!=null && temp2.left==null)||(temp1.right!=null && temp2.right==null)){
                flag =false;
                break;
            }
            if(temp1.left!=null && temp2.left!=null){
                q2.add(temp2.left);
                q1.add(temp1.left);
            }
            if(temp1.right!=null && temp2.right!=null){
                q2.add(temp2.right);
                q1.add(temp1.right);
            }
        }
        if(flag)
            System.out.print("\nTrees are structural identical");
        else
            System.out.print("\nTrees are not structural identical");
    }
    
    void levelThatHasMaxSum(TreeNode node){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        q.add(null);
        int currSum = 0;
        int maxSum=0;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp!=null){
                currSum=currSum+temp.data;
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            else{
                if(currSum>=maxSum){
                    maxSum=currSum;
                }
                currSum=0;
                if(!q.isEmpty())
                    q.add(null);
            }
        }
        System.out.print("\nMax sum: "+maxSum);
        
    }
    
    void printRootToLeaf(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        s.push(root);
        parent.put(root, null);
        while(!s.isEmpty()){
            TreeNode temp = s.pop();
            if(temp.left==null && temp.right==null)
                printNode(temp, parent);
            
            if(temp.right!=null){
                s.push(temp.right);
                parent.put(temp.right, temp);
            }
            if(temp.left!=null){
                s.push(temp.left);
                parent.put(temp.left, temp);
            }
        }
    }
    void printNode(TreeNode cur,HashMap<TreeNode,TreeNode> parent){
        Stack<TreeNode> ans = new Stack<>();
        while(cur!=null){
            ans.push(cur);
            cur=parent.get(cur);
        }
        System.out.print("\n");
        while(!ans.isEmpty()){
            cur=ans.pop();
            System.out.print(cur.data+" ");
        }
        
    }
}
