package LinkedList.Lesson2_2.Exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        SinglyLinkedList<Integer> numberLinkedList
                = new SinglyLinkedList<>();
        numberLinkedList.insertHead(4);
        numberLinkedList.insertHead(3);
        numberLinkedList.insertHead(2);
        numberLinkedList.insertHead(1);

        int choice;
        do {
            System.out.println("====================> Functions <====================");
            System.out.println("= 1. Insert Node before X                           = ");
            System.out.println("= 2. Insert Node after k                            = ");
            System.out.println("= 3. Find Node location between in linked list      =");
            System.out.println("= 4. Insert Node after location between linked list =");
            System.out.println("= 5. Show node in linked list                       =");
            System.out.println("= 0. End of program                                 =");
            System.out.println("=====================================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("=========> End of program <=======");
                    break;
                case 1:
                    System.out.println("Enter value X = ");
                    int x = input.nextInt();
                    System.out.println("Enter value node want to insert : ");
                    int data = input.nextInt();
                    numberLinkedList.insertBeforeX(x, data);
                    break;
                case 2:
                    System.out.println("Enter K = ");
                    int k = input.nextInt();
                    System.out.println("Enter value node wanr to insert : ");
                    int nodeK = input.nextInt();
                    numberLinkedList.insertAfterK(k,nodeK);
                    break;
                case 3:
                    numberLinkedList.nodeBetween();
                    break;
                case 4:
                    System.out.println("Enter value insert : ");
                    int value = input.nextInt();
                    numberLinkedList.insertAfterBetween(value);
                    break;
                case 5:
                    numberLinkedList.showNode();
                    break;
                default:
                    System.out.println("====> Selected function invalid ! Please try again <====");
                    break;
            }
        } while (choice != 0);
    }
}
