package View;

import controller.Manager;
import model.Customer;
import model.Receipt;
import storage.fileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        List<Receipt> receiptList = new ArrayList<>();
        try{
            receiptList = fileManager.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Manager hai = new Manager("Hai", receiptList);

        while (true){
            System.out.println("moi nhap lua chon: ");
            System.out.println("1: them moi: ");
            System.out.println("2: hien thi: ");
            System.out.println("3: xoa: ");
            System.out.println("4: tinh tien dien.");
            System.out.println("5: ket thuc: ");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            switch (choose){
                case 1:
                    Scanner s = new Scanner(System.in);
                    System.out.println("nhap so luong ho dan: ");
                    int n = s.nextInt();
                    for (int i = 0; i <n ; i++) {
                        System.out.println("moi nhap ten chu ho " + (i+1) + ": ");
                        Scanner scanner1 = new Scanner(System.in);
                        String name = scanner1.nextLine();
                        System.out.println("moi nhap dia chi " + (i+1) + ": ");
                        Scanner scanner2 = new Scanner(System.in);
                        String address = scanner2.nextLine();
                        System.out.println("moi nhap so cong to " + (i+1) + ": ");
                        Scanner scanner3 = new Scanner(System.in);
                        int code = scanner3.nextInt();
                        Customer customer = new Customer(name,address,code);

                        System.out.println("moi ban nhap chi so cu " + (i+1) + ": ");
                        Scanner scanner4 = new Scanner(System.in);
                        int oldIndex = scanner4.nextInt();
                        System.out.println("moi ban nhap chi so moi " + (i+1) + ": ");
                        Scanner scanner5 = new Scanner(System.in);
                        int newIndex = scanner5.nextInt();
                        double money = Receipt.getMoneyToBePaid(newIndex, oldIndex);

                        Receipt receipt = new Receipt(oldIndex, newIndex,money);
                        receipt.setCustomer(customer);
                        hai.addNewReceipt(receipt);
                    }

                    break;
                case 2:
                    hai.show();
                    break;
                case 3:
                    Scanner scanner5 = new Scanner(System.in);
                    System.out.println("moi nhap ma so cong to de xoa: ");
                    int code = scanner5.nextInt();
                    hai.deleteReceipt(code);
                    break;
                case 4:
                    Scanner scanner6 = new Scanner(System.in);
                    System.out.println("nhap ma so cong to de tinh tien: ");
                    int code1 = scanner6.nextInt();
                    hai.showMoney(code1);
                    break;
                case 5:
                    return;


            }
        }
    }
}
