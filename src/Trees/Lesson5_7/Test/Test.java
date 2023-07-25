package Trees.Lesson5_7.Test;

public class Test {
    public static void main(String[] args) {
        BinarySearchTrees<Integer> trees = new BinarySearchTrees<>();

        trees.addNodeUsingLoop(40);
        trees.addNodeUsingLoop(20);
        trees.addNodeUsingLoop(60);
        trees.addNodeUsingLoop(10);
        trees.addNodeUsingLoop(30);
        trees.addNodeUsingLoop(50);
        trees.addNodeUsingLoop(70);
        trees.addNodeUsingLoop(35);
        trees.addNodeUsingLoop(100);
        trees.addNodeUsingLoop(99);
        trees.inOrder();
        System.out.println("\n" + trees.countNode());
        System.out.println(  trees.countLeafNode());
        trees.remove(20);
        trees.remove(60);
        trees.inOrder();
        System.out.println("\n" + trees.countNode());
        System.out.println(  trees.countLeafNode());
    }
}
