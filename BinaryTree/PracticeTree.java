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

class SiblingTree{
    int data;
    SiblingTree left;
    SiblingTree right;
    SiblingTree nextSibling;

    public SiblingTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.nextSibling = null;
    }
    
}

public class PracticeTree {

    TreeNode createBinaryTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        return root;
    }
    TreeNode createSecBinaryTree(){
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left=new TreeNode(4);
        root2.left.right=new TreeNode(5);
        root2.right.left=new TreeNode(6);
        root2.right.right=new TreeNode(7);
        return root2;
    }
    
    SiblingTree createSiblingTree(){
        SiblingTree root = new SiblingTree(1);
        root.left = new SiblingTree(2);
        root.right = new SiblingTree(3);
        root.left.left=new SiblingTree(4);
        root.left.right=new SiblingTree(5);
        root.right.left=new SiblingTree(6);
        return root;
    }
    
    public static void main(String[] args) {
        PracticeTree pt = new PracticeTree();
        BinaryTree bt = new BinaryTree();
        /*TreeNode head = pt.createBinaryTree();
        
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
        bt.insertElement(head, 7);
        bt.sizeOfTree(head);
        bt.deleteElement(head, 1);
        System.out.print("\nTree after deletion:-");
        bt.levelOrder(head);
        bt.printLevelOrderReverse(head);
        bt.deepestNode(head);
        bt.totalLeaves(head);
        bt.fullNodes(head);
        bt.halfNodes(head);
        
        TreeNode root1 = pt.createBinaryTree();
        TreeNode root2 = pt.createSecBinaryTree();
        
        bt.checkTwoTreeStructuralIdentical(root1, root2);
        bt.levelThatHasMaxSum(root2);
        System.out.print("\nRoot to leaf nodes:-");
        bt.printRootToLeaf(root1);
        System.out.print("\nmirror tree:-");
        bt.mirrorTree(root1);
        bt.levelOrder(root1);
        
        TreeNode root3 = pt.createBinaryTree();
        bt.checkMirror(root1, root2);
        System.out.print("\nAncestors:-");
        bt.printAccestor(root3, 1);
        
        BinaryTreeNew btn = new BinaryTreeNew();
        btn.traverseTreeZigZag(root3);*/
        
        BinaryTreeNew btn = new BinaryTreeNew();
        SiblingTree st = pt.createSiblingTree();
        btn.connectSiblings(st);
        //btn.taverseSibling(st);
    }
}
