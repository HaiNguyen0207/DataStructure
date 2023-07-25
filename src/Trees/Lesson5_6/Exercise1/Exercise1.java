package Trees.Lesson5_6.Exercise1;

public class Exercise1 {
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
//        trees.add(18);
//        trees.add(20);
//        trees.add(19);
//        trees.add(1);
//        trees.add(4);
//        trees.add(16);
//        trees.add(8);
        System.out.println("Prev Order : ");
        trees.prevOrder();
        System.out.println("\n In Order : ");
        trees.inOrder();
        System.out.println("\nPost Order : ");
        trees.postOrder();
//        System.out.println("\nSum node = " + trees.countNodes());
//        System.out.println("\nSum leaf node = " + trees.countLeafNode());
//        System.out.println("Seah 99 ? : "+trees.search(99));
    }
}
