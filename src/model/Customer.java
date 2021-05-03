package model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private String address;
    private int code;

    @Override
    public String toString() {
        return
                "Tên chủ hộ: '" + name + '\'' +
                ", Địa chỉ: '" + address + '\'' +
                ", Mã số công tơ: " + code ;
    }

    public Customer(String name, String address, int code) {
        this.name = name;
        this.address = address;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
