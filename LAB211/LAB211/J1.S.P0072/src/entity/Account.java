/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


/**
 *
 * @author Nhat Anh
 */
public class Account {

    private String userName;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String dateOfBirth;

    public Account() {
    }

    public Account(
            String userName, String password,
            String name, String phone,
            String email, String address,
            String dateOfBirth) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Account{" + "userName=" + userName + ", password=" + password + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address + ", dateOfBirth=" + dateOfBirth + '}';
    }
    

}
