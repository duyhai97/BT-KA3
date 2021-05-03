package controller;

import model.Customer;
import model.Receipt;
import storage.fileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private String name;
    private   List<Receipt> receiptList = new ArrayList<>();

    public Manager(String name, List<Receipt> receiptList) {
        this.name = name;
        this.receiptList = receiptList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public void setReceiptList(List<Receipt> receiptList) {
        this.receiptList = receiptList;
    }

    public void showMoney(int code){
        for (Receipt r: receiptList
             ) {
            if (r.getCustomer().getCode() == code){
                System.out.println(r);
            }
        }
    }


    public void addNewReceipt(Receipt receipt) throws IOException {
        receiptList.add(receipt);
        fileManager.writeFile(receiptList);
    }

    public void deleteReceipt(int code){
        for (int i = 0; i < receiptList.size(); i++) {
            if (receiptList.get(i).getCustomer().getCode() == code){
                receiptList.remove(receiptList.get(i));
            }
        }
    }

    public  void show(){
        for (Receipt r: receiptList
             ) {
            System.out.println(r);
        }
    }

}
