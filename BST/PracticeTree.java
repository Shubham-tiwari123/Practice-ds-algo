package practicetree;

public class PracticeTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearch root = bst.createBST();
        bst.levelOrderBST(root);
        bst.insertNodeBST(root, 79);
        bst.searchData(root, 10);
        bst.findMax(root);
        bst.deleteNode(root, 4);
        System.out.print("\nBST after deletion:-");
        bst.levelOrderBST(root);
        
        int dis = bst.distanceBetween2(root, 3, 9);
        System.out.print("\nDistance between two nodes:-"+dis);
        bst.LCA(root, 3, 9);
        if(bst.isBST(root, null, null))
            System.out.print("\nBST");
        else
            System.out.print("\nNot bst");
        bst.bstToDLL(root);
        System.out.print("\nPrinting dll:-");
        bst.printDLL(bst.getDLLRoot());
        bst.sortedLLToBST();
    }
}
