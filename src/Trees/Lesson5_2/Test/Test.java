package Trees.Lesson5_2.Test;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(6);
        tree.add(9);
        tree.add(4);
        tree.add(5);
        tree.inOrder();


    }
}
