package treeque;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
}
public class Tree2 {
    TreeNode head=null;
    void createTreeFormList(List<Integer> list){
        TreeNode newNode = new TreeNode();
        
        newNode.data=list.get(0);
        newNode.left=null;
        newNode.right=null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(newNode);
        int i=1;
        while(!q.isEmpty()){
            if(head==null)
                head = newNode;
            else{
                TreeNode temp = q.poll();
                if(i<list.size()){
                    TreeNode newNode1 = new TreeNode();
                    newNode1.data=list.get(i);
                    newNode1.left=null;
                    newNode1.right=null;
                    temp.left=newNode1;
                    q.add(newNode1);
                }
                i++;
                if(i<list.size()){
                    TreeNode newNode2 = new TreeNode();
                    newNode2.data=list.get(i);
                    newNode2.left=null;
                    newNode2.right=null;
                    temp.right=newNode2;
                    q.add(newNode2);
                }
                i++;
            }
        }
        inoder(head);
    }
    void inoder(TreeNode node){
        if(node==null)
            return;
        inoder(node.left);
        System.out.print(node.data+" ");
        inoder(node.right);
    }
    void createList(){
        List<Integer> list = new LinkedList();
        list.add(10);
        list.add(12);
        list.add(15);
        list.add(25);
        list.add(30);
        list.add(36);
        System.out.println(list);
        createTreeFormList(list);
    }
}
