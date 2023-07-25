package LinkedList.Lesson2_3.Exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        DoublyLinkedList numberLinkedList = new DoublyLinkedList();
        var input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===============> Functions <==============");
            System.out.println("= 1. Insert node  head                   =");
            System.out.println("= 2. Insert node tail                    =");
            System.out.println("= 3. Insert node  after  X               =");
            System.out.println("= 4. Insert node  before  X              =");
            System.out.println("= 5. Insert after position K             = ");
            System.out.println("= 6. Find node in the middle             =");
            System.out.println("= 7. Insert node after position middle   =");
            System.out.println("= 8. Show node in order head -> tail     =");
            System.out.println("= 9. Show node in order tail -> head     =");
            System.out.println("= 0. End of the program                  =");
            System.out.println("==========================================");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("======> End of the program <========");
                    break;
                case 1:
                    System.out.println("Enter value want to insert head : ");
                    var valueHead = input.nextInt();
                    numberLinkedList.insertHead(valueHead);
                    break;
                case 2:
                    System.out.println("Enter value want to insert tail : ");
                    var valueTail = input.nextInt();
                    numberLinkedList.insertTail(valueTail);
                    break;
                case 3:
                    System.out.println("Enter location X = ");
                    var xAfter = input.nextInt();
                    System.out.println("Enter value wanto to insert after  "
                            + xAfter + " : ");
                    var valueXAfter = input.nextInt();
                    numberLinkedList.insertAfter(valueXAfter, xAfter);
                    break;
                case 4:
                    System.out.println("Enter location X = ");
                    var xBefore = input.nextInt();
                    System.out.println("Enter value want to insert before "
                            + xBefore + ":  ");
                    var valueBefore = input.nextInt();
                    numberLinkedList.insertBefore(valueBefore, xBefore);
                    break;
                case 5:
                    System.out.println("Enter order K = ");
                    var k = input.nextInt();
                    System.out.println("Enter value node wanto insert after K : ");
                    var valueAfterK = input.nextInt();
                    numberLinkedList.insertAfterK(valueAfterK, k);
                    break;
                case 6:
                    numberLinkedList.findNodeMiddle();
                    break;
                case 7:
                    System.out.println("Enter value node want to insert after middle :");
                    var valueMiddle = input.nextInt();
                    numberLinkedList.insetAfterMiddle(valueMiddle);
                    break;
                case 8:
                    numberLinkedList.showNodeHeadTail();
                    break;
                case 9:
                    numberLinkedList.showNodeTailHead();
                    break;
                default:
                    System.out.println("===> Function selected invalid ! Pleaes try agin <===");
                    break;
            }
        } while (choice != 0);
    }
}
