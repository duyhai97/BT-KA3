package model;

import java.io.Serializable;

public class Receipt implements Serializable {
    private Customer customer;
    private int oldIndex;
    private int newIndex;
    private double moneyToBePaid;

    public Receipt(int oldIndex, int newIndex, double moneyToBePaid) {
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        this.moneyToBePaid = moneyToBePaid;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                  customer +
                ", Chỉ số cũ: " + oldIndex +
                ", Chỉ số mới: " + newIndex +
                ", Số tiền phải trả: " + moneyToBePaid +
                '}';
    }

//    public Receipt(Customer customer, int oldIndex, int newIndex, double moneyToBePaid) {
//        this.customer = customer;
//        this.oldIndex = oldIndex;
//        this.newIndex = newIndex;
//        this.moneyToBePaid = moneyToBePaid;
//    }

    public static double getMoneyToBePaid(int newIndex, int oldIndex) {
        return (newIndex-oldIndex)*750;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(int oldIndex) {
        this.oldIndex = oldIndex;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(int newIndex) {
        this.newIndex = newIndex;
    }



    public void setMoneyToBePaid(double moneyToBePaid) {
        this.moneyToBePaid = moneyToBePaid;
    }
}
