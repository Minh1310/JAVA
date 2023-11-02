/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import constant.Constant;
import entity.Account;
import utils.Validation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nhat Anh
 */
public class AccountBO {
    private List<Account> list;
    private String messageNotMatchPassword = "New password not match each other";
    public AccountBO() {
        list = new ArrayList<>();
        list.add(new Account(
                "minhDepTrai",
                "minh1310",
                "Minh handsome",
                "1234567890",
                "minhbqhe171754@fpt.edu.vn",
                "daiHocFPT",
                "13/10/2003"
        ));
    }

    public AccountBO(List<Account> list) {
        this.list = list;
    }

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }

    /**
     * 
     * @param list
     * @param userName
     * @return
     */
    private boolean exist(String userName) {
        for (Account ls : list) {
            if (ls.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @return
     */
    public boolean add() {
        Account account = new Account();
        account.input();
        while (exist(account.getUserName())) {
            String userName = Validation.getString(
                    "Enter user name: ",
                    "Must have a-zA-Z0-9",
                    "Invalid String",
                    Constant.REGEX_USER_NAME);
            account.setUserName(userName);
        }
        return list.add(account);
    }

    /**
     * 
     * @param userName
     * @param password
     */
    public int login(String userName, String password) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserName().equals(userName) &&
                    list.get(i).getPassword().equals(Validation.getMd5(password))) {
                System.out.println("");
                System.out.println("--------Welcome " + userName + "---------");
                System.out.println("");
                return i;
            }
        }
        return -1;
    }

    public boolean setPassword(int index) {
        String oldPass = Validation.getMd5(
            Validation.getString(
                "Enter old password: ",
                "Must have a-zA-Z0-9",
                "Invalid String",
                Constant.REGEX_PASS_WORD)
        );      
        if (list.get(index).getPassword().equals(oldPass)) {
            do{
                String newPass = Validation.getString(
                    "Enter new password: ",
                    "Must have a-zA-Z0-9",
                    "Invalid String",
                    Constant.REGEX_PASS_WORD);
                String renewPass = Validation.getString(
                    "Enter renew password: ",
                    "Must have a-zA-Z0-9",
                    "Invalid String",
                    Constant.REGEX_PASS_WORD);
                if (newPass.equals(renewPass)) {
                    list.get(index).setPassword(Validation.getMd5(newPass));
                    return true;
                }
                System.out.println(messageNotMatchPassword);
            } while(true);      
        }
        return false;
    }

    public void display(){
        list.forEach(a -> {a.display();});
    }
}
