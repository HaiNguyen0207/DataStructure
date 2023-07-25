package LinkedList.Lesson2_4.Exercise4;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        DoublyLinkedList<BankAccount> bankLinkedList = new DoublyLinkedList();
        int choice;
        addBankAccount(bankLinkedList);
        do {
            System.out.println("================> Functions <==============");
            System.out.println("= 1. Add new bank account                 =");
            System.out.println("= 2. Update surplus by number account     =");
            System.out.println("= 3. Show bank account                    =");
            System.out.println("= 4. End of the program                   =");
            System.out.println("===========================================");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    addNewBank(bankLinkedList, input);
                    System.out.println("Success !");
                    break;
                case 2:
                    var result = updateSurplus(bankLinkedList, input);
                    if (result) {
                        System.out.println("Success !");
                    } else {
                        System.out.println("Fail !");
                    }
                    break;
                case 3:
                    showBankAccount(bankLinkedList);
                    break;
                case 4:
                    System.out.println("===> End of the program <===");
                    break;
                default:
                    System.out.println("===> Fuction selected invalid ! Please try again <===");
                    break;
            }
        } while (choice != 4);
    }

    private static boolean updateSurplus(DoublyLinkedList<BankAccount> bankLinkedList,
                                         Scanner input) {
        System.out.println("Enter number account want to update : ");
        input.nextLine();
        var numberAccount = input.nextLine();
        var bankOld = bankLinkedList.getNode(new BankAccount(numberAccount));
        if (bankOld != null) {
            System.out.println("Enter new surplus : ");
            var surplus = Float.parseFloat(input.nextLine());
            var newBank = bankOld;
            newBank.setSurplus(surplus);
            if (bankLinkedList.updateNodeData(bankOld, newBank)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static void showBankAccount(DoublyLinkedList<BankAccount> bankLinkedList) {
        System.out.printf("%-20s%-20s%-20s%-20s%-15s\n", "Owner", "NumberId", "NumberAccount"
                , "NameBank", "Surplus");
        for (var node = bankLinkedList.getHead();
             node != null; node = node.getNext()) {
            System.out.printf("%-20s%-20s%-20s%-20s%-15s\n", node.getData().getFullName(),
                    node.getData().getNumberId(), node.getData().getNumberAccount(),
                    node.getData().getNameBank(), node.getData().getSurplus());
        }
    }

    private static void addNewBank(DoublyLinkedList<BankAccount> bankLinkedList, Scanner input) {
        System.out.println("Enter full name : ");
        input.nextLine();
        var name = input.nextLine();
        System.out.println("Enter number ID : ");
        var numberId = input.nextLine();
        System.out.println("Enter number account : ");
        var numberAccount = input.nextLine();
        System.out.println("Enter name bank : ");
        var nameBank = input.nextLine();
        System.out.println("Enter surplus : ");
        var surplus = Float.parseFloat(input.nextLine());
        bankLinkedList.insertTail(new BankAccount(name, numberId, numberAccount, nameBank, surplus));
    }

    private static void addBankAccount(DoublyLinkedList<BankAccount> bankLinkedList) {
        bankLinkedList.insertTail(new BankAccount("Nguyễn Văn Hải",
                "00000001", "12345678", "XBank", 9000f));
        bankLinkedList.insertHead(new BankAccount("Nguyễn Bá Trung",
                "14300022", "12345679", "XBank", 10000f));
        bankLinkedList.insertHead(new BankAccount("Lê Thị Hồng",
                "0012001", "12345675", "XBank", 5600f));
        bankLinkedList.insertTail(new BankAccount("Nguyễn Văn Hoàng",
                "12100001", "12345677", "XBank", 9800f));
        bankLinkedList.insertTail(new BankAccount("Trần Công Minh",
                "00009911", "12345672", "XBank", 7900f));
    }
}
