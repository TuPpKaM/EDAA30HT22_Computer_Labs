package bst;

public class BSTMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<Integer>();
        BSTVisualizer visualiser = new BSTVisualizer("Input", 500, 500);
        BSTVisualizer visualiser2 = new BSTVisualizer("Output", 500, 500);
        
        for (int i = 25; i>0 ; i--) {
            searchTree.add(i);
        }

        searchTree.printTree();
        visualiser.drawTree(searchTree);
        searchTree.rebuild();
        visualiser2.drawTree(searchTree);
    }
}
