package com.loans;

public class DataLoans {
    private String first_name;
    private String last_name;
    private String money;
    private String date;

    public DataLoans(String first_name, String last_name, String money, String date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.money = money;
        this.date = date;
    }

    public DataLoans() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
