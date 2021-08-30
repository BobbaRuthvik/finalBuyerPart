package com.example.optverification;

public class Messages {
    String price;
    String image;
    String address;
    String phonenumber;
    String product;

    public Messages() {
    }

    public Messages(String price, String image, String address, String phonenumber, String product) {
        this.price = price;
        this.image = image;
        this.address = address;
        this.phonenumber = phonenumber;
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
