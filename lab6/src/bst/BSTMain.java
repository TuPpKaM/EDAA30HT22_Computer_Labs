package bst;

public class BSTMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<Integer>();
        BSTVisualizer visualiser = new BSTVisualizer("searchTree", 500, 500);
        visualiser.drawTree(searchTree);
        
        System.out.println("---HEIGHT:" + searchTree.height() + "---");
        searchTree.add(8);
        System.out.println("---HEIGHT:" + searchTree.height() + "---");
        searchTree.add(5);
        System.out.println("---HEIGHT:" + searchTree.height() + "---");
        searchTree.add(3);
        searchTree.add(4);
        System.out.println("---HEIGHT:" + searchTree.height() + "---");
        searchTree.add(6);
        System.out.println("---HEIGHT:" + searchTree.height() + "---");
        searchTree.add(9);
        System.out.println("---HEIGHT:" + searchTree.height() + "---");
        searchTree.add(7);
        System.out.println("---HEIGHT:" + searchTree.height() + "---");
        searchTree.add(1);
        searchTree.add(2);

        searchTree.printTree();
    }
}
