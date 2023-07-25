package Trees.Lesson5_5.Exercise1;

public class Test {
    public static void main(String[] args) {
        BinarySearchTrees<Integer> trees = new BinarySearchTrees<>();
        BinarySearchTrees<Integer> trees1 = new BinarySearchTrees<>();
        trees.add(8);
        trees.add(7);
        trees.add(6);
        trees.add(9);
        trees.add(10);
        trees.add(12);
        trees.add(11);
        trees.add(5);
        trees.add(3);
        trees.add(13);
//        trees1.addUsingLoop(8);
//        trees1.addUsingLoop(7);
//        trees1.addUsingLoop(6);
//        trees1.addUsingLoop(9);
//        trees1.addUsingLoop(10);
//        trees1.addUsingLoop(12);
//        trees1.addUsingLoop(11);
//        trees1.addUsingLoop(5);
//        trees1.addUsingLoop(3);
//        trees1.addUsingLoop(13);
        System.out.println(" Prev order : ");
        trees.pervOrder();
        System.out.println("\nIn order : ");
        trees.inOrder();
        System.out.println("\nPost order : ");
        trees.postOrder();
        System.out.println("\nSearch 5 ? : " + trees.search(5));
        System.out.println(trees.countNode());
        System.out.println(trees.countLeafNode());

    }
}
