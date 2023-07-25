package LinkedList.Lesson2_2.Exercise2;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        SinglyLinkedList<Integer> numberLinkedList = new SinglyLinkedList();
        int choice;
        do {
            System.out.println("================> Functions <===============");
            System.out.println("= 1. Insert head                           =");
            System.out.println("= 2. Insert tail                           =");
            System.out.println("= 3. Insert node after value X             =");
            System.out.println("= 4. Insert node before value X            =");
            System.out.println("= 5. Insert node after order K             =");
            System.out.println("= 6. Find the node in the middle position  =");
            System.out.println("= 7. Insert node after the middle position = ");
            System.out.println("= 8. Show node in linked list              =");
            System.out.println("= 0. End of the program                    =");
            System.out.println("============================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("====> End of the program <=====");
                    break;
                case 1:
                    System.out.println("Enter the value to insert : ");
                    var valueHead = input.nextInt();
                    numberLinkedList.insertHead(valueHead);
                    break;
                case 2:
                    System.out.println("Enter the value to insert : ");
                    var valueTail = input.nextInt();
                    numberLinkedList.insertTail(valueTail);
                    break;
                case 3:
                    System.out.println("Enter value X = ");
                    var x = input.nextInt();
                    System.out.println("Enter the node value to insert after : ");
                    var value = input.nextInt();
                    numberLinkedList.insertAfter(value, x);
                    break;
                case 4:
                    System.out.println("Enter value X = ");
                    var valueX = input.nextInt();
                    System.out.println("Enter the node value to insert before : ");
                    var dataBefore = input.nextInt();
                    numberLinkedList.insertBefore(dataBefore, valueX);
                    break;
                case 5:
                    System.out.println("Enter location K = ");
                    var k = input.nextInt();
                    System.out.println("Enter the node to insert : ");
                    var valueK = input.nextInt();
                    numberLinkedList.insertAfterLocationK(k, valueK);
                    break;
                case 6:
                    numberLinkedList.showNodeMiddle();
                    break;
                case 7:
                    System.out.println("Enter value node tp insert : ");
                    var valueMiddle = input.nextInt();
                    numberLinkedList.nodeMiddle(valueMiddle);
                    break;
                case 8:
                    numberLinkedList.showNode();
                    break;
                default:
                    System.out.println("==> Invalid selected function ! Please try a again <===");
                    break;
            }
        } while (choice != 0);
    }
}
