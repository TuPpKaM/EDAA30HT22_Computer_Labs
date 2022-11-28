package bst;

public class BSTMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<Integer>();
        BSTVisualizer visualiser = new BSTVisualizer("Input", 500, 500);
        BSTVisualizer visualiser2 = new BSTVisualizer("Output", 500, 500);
        
        /*
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
        */
        /*
        searchTree.add(1);
        searchTree.add(3);
        searchTree.add(5);
        searchTree.add(7);
        searchTree.add(8);
        searchTree.add(11);
        searchTree.add(13);
        searchTree.add(15);
        searchTree.add(10);
        searchTree.add(12);
        searchTree.add(4);
        searchTree.add(8);
        searchTree.add(6);
        searchTree.add(2);
        */

        /*
        for (int i = 25; i>0 ; i--) {
            searchTree.add(i);
        }
        */

        searchTree.printTree();
        visualiser.drawTree(searchTree);
        searchTree.rebuild();
        visualiser2.drawTree(searchTree);
    }
}
