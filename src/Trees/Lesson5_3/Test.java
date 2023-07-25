package Trees.Lesson5_3;

public class Test {
    public static void main(String[] args) {
        BinarySearchTrees<Integer> trees = new BinarySearchTrees<>();
        trees.add(100);
        trees.add(95);
        trees.add(200);
        trees.add(94);
        trees.add(97);
        trees.add(190);
        trees.add(201);
        trees.add(96);
        trees.add(202);


        System.out.println("Duyệt cây theo thứ tự pre-order: ");
        trees.prevOrder();
        System.out.println("\nDuyệt cây theo thứ tự in-order: ");
        trees.inOrder();
        System.out.println("\nDuyệt cây theo thứ tự post-order: ");
        trees.postOrder();
    }
}
