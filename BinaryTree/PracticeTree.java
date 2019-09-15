package practicetree;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class PracticeTree {

    TreeNode createBinaryTree(){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.left.left=new TreeNode(3);
        return root;
    }
    
    public static void main(String[] args) {
        PracticeTree pt = new PracticeTree();
        BinaryTree bt = new BinaryTree();
        TreeNode head = pt.createBinaryTree();
        System.out.print("\nPreOrder:-");
        bt.preOrder(head);
        System.out.print("\nInOrder:-");
        bt.inOrder(head);
        System.out.print("\nPostOrder:-");
        bt.postOrder(head);
        System.out.print("\nLevelOrder:-");
        bt.levelOrder(head);
        bt.findMax(head);
        bt.searchElement(head, 4);
        bt.insertElement(head, 15);
        bt.sizeOfTree(head);
        bt.deleteElement(head, 1);
        System.out.print("\nTree after deletion:-");
        bt.levelOrder(head);
    }
    
}
