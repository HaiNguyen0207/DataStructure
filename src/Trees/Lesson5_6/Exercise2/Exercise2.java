package Trees.Lesson5_6.Exercise2;


import java.util.stream.StreamSupport;

public class Exercise2 {
    public static void main(String[] args) {
        BinarySearchTrees<Integer> trees = new BinarySearchTrees<>();
        trees.add(10);
        trees.add(8);
        trees.add(12);
        trees.add(5);
        trees.add(9);
        trees.add(2);
        trees.add(13);
        trees.add(7);
        trees.add(15);
        trees.add(16);
        trees.add(11);
        trees.add(4);
        trees.add(14);
        trees.add(1);
        System.out.println("Prev Order : ");
        trees.prevOrder();
        System.out.println("\nIn Order ");
        trees.inOrder();
        System.out.println("\nPost Order : ");
        trees.postOrder();
        System.out.println("\nFind 22 ? "+trees.search(22));
        System.out.println("Sum Node : "+ trees.countNode());
        System.out.println("Sum leaf  node: "+trees.countLeafNode());
        System.out.println("Remove 5 : ");
        trees.remove(5);
        System.out.println("Prev Order : ");
        trees.prevOrder();
        System.out.println("\nIn Order ");
        trees.inOrder();
        System.out.println("\nPost Order : ");
        trees.postOrder();
    }
}
