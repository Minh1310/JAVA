/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Task;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nhat Anh
 */
public class TaskBO {

    private List<Task> list;

     public TaskBO() {
        list = new ArrayList<>();
        list.add(new Task("Dev Program", "Code", "28/08/2015", 7.5,16, "Dev", "Lead"));
        list.add(new Task("Dev Program", "Code", "29/08/2015", 7,15, "Dev", "Lead"));
        list.add(new Task("Dev Program", "Code", "30/08/2015", 10, 17, "Dev", "Lead"));
        list.add(new Task("Dev Program", "Code", "31/08/2015", 11,13, "Dev", "Lead"));
    }
    
    public TaskBO(List<Task> list) {
        this.list = list;
    }

    public List<Task> getList() {
        return list;
    }

    public void setList(List<Task> list) {
        this.list = list;
    }

    /**
     * Use to check task existed in task list
     * 
     * @param list list about information of task take from input
     * @param Id ID of task take from input
     * @return true if ID existed or false if ID not check
     */
    private boolean exist(Task task){
       for(Task ls : list){
           if(
            ls.getName().equalsIgnoreCase(task.getName())&&
            ls.getTaskType()==task.getTaskType()&&
            ls.getDate().equalsIgnoreCase(task.getDate())&&
            ls.getFrom()==task.getFrom()&&
            ls.getTo()==task.getTo()&&
            ls.getReviewer().equalsIgnoreCase(task.getReviewer())&&
            ls.getAssignee().equalsIgnoreCase(task.getAssignee())       
            ){
               return true;
           }
       }
       return false;   
    }
    
    /**
     * 
     * @param list 
     */
    public boolean add(){
        Task task = new Task();
        task.input();
        if(exist(task)){
            return false;
        }
        list.add(task);
        return true;
        
    }
    
    public boolean delete(int id){
        for (Task task : list) {
            if(task.getId()==id){
                list.remove(task);
                return true;
            }
        }
        return false;
    }
    
   /**
    * 
    */
    public void display(){
        list.forEach(a -> {a.display();});
    }
}
