package LinkedList.Lesson2_3.Exercise2;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        DoublyLinkedList numberLinkesList = new DoublyLinkedList();
        int option;
        do {
            System.out.println("=================> Functionn <================");
            System.out.println("= 1 . Insert head                            =");
            System.out.println("= 2.  Insert tail                            =");
            System.out.println("= 3.  Insert node after value X              = ");
            System.out.println("= 4.  Insert node before value X             =");
            System.out.println("= 5.  Inset node after order K               =");
            System.out.println("= 6.  Find node middle                       =");
            System.out.println("= 7.  Insert node after middle in list       =");
            System.out.println("= 8.  Show node from head to tail            =");
            System.out.println("= 9.  Show node from tail to head            =");
            System.out.println("= 0.  End of the program                     =");
            System.out.println("==============================================");
            option = input.nextInt();
            switch (option) {
                case 0:
                    System.out.println("======> End of the program <=======");
                    break;
                case 1:
                    System.out.println("Enter value node insert head :");
                    var valueHead = input.nextInt();
                    numberLinkesList.insertHead(valueHead);
                    break;
                case 2:
                    System.out.println("Enter value  node inset tail : ");
                    var valueTail = input.nextInt();
                    numberLinkesList.insertTail(valueTail);
                    break;
                case 3:
                    System.out.println("Enter value X = ");
                    var xAfter = input.nextInt();
                    System.out.println("Enter value insert after " + xAfter + " : ");
                    var valueAfter = input.nextInt();
                    numberLinkesList.insertAfter(valueAfter, xAfter);
                    break;
                case 4:
                    System.out.println("Enter value X = ");
                    var xBefore = input.nextInt();
                    System.out.println("Enter value insert before " + xBefore + " : ");
                    var valueBefore = input.nextInt();
                    numberLinkesList.insertBefore(valueBefore, xBefore);
                    break;
                case 5:
                    System.out.println("Enter order K = ");
                    var k = input.nextInt();
                    System.out.println("Enter valeu insert after order " + k + " : ");
                    var valueK = input.nextInt();
                    numberLinkesList.insertAfterOrder(valueK, k);
                    break;
                case 6:
                    numberLinkesList.showNodeMiddle();
                    break;
                case 7:
                    System.out.println("Enter value node insert middle  : ");
                    var valueMiddle =input.nextInt();
                    numberLinkesList.insertAfterMiddle(valueMiddle);
                    break;
                case 8:
                    numberLinkesList.showHeadToTail();
                    break;
                case 9:
                    numberLinkesList.showNodeTailToHead();
                    break;
                default:
                    System.out.println("====> Function seleced invalid ! Please try again <====");
                    break;

            }
        } while (option != 0);
    }
}
