package CSD201_AS2_FX11317;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AS2_Main {
    public static void showMenu() {
        System.out.println("===================================");

        System.out.println("Choose one of this options:");

        System.out.println("Product list:");

        System.out.println("1. Load data from file and display");

        System.out.println("2. Input & add to the end.");

        System.out.println("3. Display data");

        System.out.println("4. Save product list to file.");

        System.out.println("5. Search by ID");

        System.out.println("6. Delete by ID");

        System.out.println("7. Sort by ID.");

        System.out.println("8. Convert to Binary");

        System.out.println("9. Load to stack and display");

        System.out.println("10. Load to queue and display.");

        System.out.println("0. Exit");

        System.out.println("===================================");

    }

    public static void main(String[] args) throws IOException {
        int chon, n = 0;
        Scanner sc = new Scanner(System.in);
        MyList list = new MyList();
        MyStack stack = new MyStack();
        MyQueue queue = new MyQueue();
        OperationToProduct t = new OperationToProduct();
        t.danhsachSP(list);

        do{
            showMenu();
            System.out.print("Choice = ");
            chon = sc.nextInt();
            switch (chon){
                case 0:// thoat chuong trinh va ghi loi chao
                    System.out.println("Thanks!");
                    break;
                case 1: //Load data from file and display
                    System.out.println("ID |  Title   | Quantity | price");
                    System.out.println("--------------------------------");
                    t.getAllItemsFromFile("CSD201_AS2_FX11317\\data.txt",list);
                    break;
                case 2: //Input & add to the end.
                    t.createProduct(list);
                    break;
                case 3://Display data
                    System.out.println("ID |  Title   | Quantity | price");
                    System.out.println("--------------------------------");
                    System.out.println(list);
                    t.writeconsole("CSD201_AS2_FX11317\\output.txt",list.toString());
                    break;
                case 4://Save product list to file
                    t.writeAllItemsToFile("CSD201_AS2_FX11317\\data.txt",list);
                    break;
                case 5://Search by ID
                    System.out.print("Input the IDto search= ");
                    String bcode = sc.next();
                    System.out.println(list.searchByCode(bcode));
                    t.writeconsole("CSD201_AS2_FX11317\\output.txt",list.searchByCode(bcode));
                    break;
                case 6://Delete by ID
                    list.deleteElement();
                    break;
                case 7: //Sort by ID
                    list.sortByID();
                    t.writeAllItemsToFile("CSD201_AS2_FX11317\\data.txt",list);
                    break;
                case 8://Convert to Binary
                    System.out.print("Quantity="+ list.searchQuantity() + "=>");
                    list.convertToBinary(list.searchQuantity());
                    System.out.println();
                    break;
                case 9: //Load to stack and display
                    System.out.println("ID |  Title   | Quantity | price");
                    System.out.println("--------------------------------");
                    t.getAllItemsFromFile("CSD201_AS2_FX11317\\data.txt",stack);
                    break;
                case 10://Load to queue and display
                    System.out.println("ID |  Title   | Quantity | price");
                    System.out.println("--------------------------------");
                    t.getAllItemsFromFile("CSD201_AS2_FX11317\\data.txt",queue);
                    break;
            }
        } while(chon != 0);// neu chon 0 thoat chuong trinh
    }
}
