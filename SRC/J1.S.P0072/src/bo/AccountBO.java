/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

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
    public AccountBO() {
        list = new ArrayList<>();
        list.add(new Account(
                "minhDepTrai",
                "Minh1",
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
     * @return
     */
    public boolean add() {
        Account account = new Account();
        account.input(list);
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

    public boolean checkPassword(int index, String oldPass){
        return list.get(index).getPassword().equals(Validation.getMd5(oldPass));
    }

    public boolean setPassword(int index,String newPass,String renewPass) {     
        if (newPass.equals(renewPass)) {
            list.get(index).setPassword(newPass);
            return true;
        }
        return false;
               
    }

    public void display(){
        list.forEach(a -> {a.display();});
    }
}
