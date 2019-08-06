package payu;


class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        left=right=null;
    }
}
public class Tree {
    Node root;
    int VAL;
    int minHeight(Node temp,int level){
        if(temp==null)
            return level;
        level++;
        return Math.min(minHeight(temp.left,level), minHeight(temp.right,level));
    }
    
    void printInorder(Node temp){
        if(temp==null)
            return;
        printInorder(temp.left);
        System.out.print(temp.data+" ");
        printInorder(temp.right);
    }
    
    int findMaxPath(Node temp, int value){
        if(temp==null)
            return 0;
        int l = findMaxPath(temp.left, value);
        int r = findMaxPath(temp.right, value);
        int max_sin = Math.max(Math.max(l, r)+temp.data,temp.data);
        int max_top = Math.max(max_sin, l+r+temp.data);
        VAL = Math.max(VAL, max_top);
        return max_sin;
    }
    
    boolean isFullBinaryTree(Node temp){
        if(temp==null)
            return true;
        if(temp.left==null && temp.right==null)
            return true;
        if(temp.left!=null && temp.right!=null)
            return (isFullBinaryTree(temp.left) && isFullBinaryTree(temp.right));
        return false;
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node(10); 
        tree.root.left = new Node(20); 
        tree.root.right = new Node(30); 
        tree.root.left.right = new Node(40); 
        tree.root.left.left = new Node(50); 
        tree.root.right.left = new Node(60); 
        tree.root.left.left.left = new Node(80); 
        tree.root.right.right = new Node(70); 
        tree.root.left.left.right = new Node(90); 
        tree.root.left.right.left = new Node(80); 
        tree.root.left.right.right = new Node(90); 
        tree.root.right.left.left = new Node(80); 
        tree.root.right.left.right = new Node(90); 
        tree.root.right.right.left = new Node(80); 
        tree.root.right.right.right = new Node(90); 
        tree.printInorder(tree.root);
        int val2 = tree.minHeight(tree.root, 0);
        System.out.println("\n\nval2:-"+val2);
        
        tree.VAL=Integer.MIN_VALUE;
        tree.findMaxPath(tree.root,tree.VAL);
        System.out.println("\n\nval:-"+tree.VAL);
        
        System.out.println(tree.isFullBinaryTree(tree.root));
    }
    
}
