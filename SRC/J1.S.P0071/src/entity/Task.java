/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import constant.Constant;
import utils.Validation;

/**
 *
 * @author Nhat Anh
 */
public class Task {
    public static int makeID=0;
    private int  id;
    private String name;
    private String taskType;
    private String date;
    private double from;
    private double to;
    private double time;
    private String assignee;
    private String reviewer;
    
    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public Task() {
        makeID++;
    }

    public Task(String name, String taskType, String date, double from,
                double to, String assignee, String reviewer
            ) {
        makeID++;
        this.id = makeID;
        this.name = name;
        this.taskType = taskType;
        this.date = date;
        this.time = to - from;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name=" + name + ", taskType=" + taskType + 
                ", date=" + date + ", time=" + time + ", assignee=" + assignee 
                + ", reviewer=" + reviewer + '}';
    }

    public void display(){
        System.out.printf("|%5s |%5s |%5s |%5s |%5s |%5s |%5s|",
             id, name, taskType, date, time, assignee, reviewer);
        System.out.println();
    }

    /**
     * use to take information of task
     */
    public void input(){
        this.id = makeID;
        this.name = Validation.getString(
                "Enter requirement name: ", 
                "Must have (a-zA_Z0-9)", 
                "Invalid String", 
                Constant.REGEX_NAME);
        int taskTypeId = Validation.getInt(
                "Enter task type ID(1-4)", 
                "Must from 1 to 4", 
                "Invalid number", 
                1, 4);
        switch(taskTypeId){
            case 1:
                this.taskType = "Code";
                break;
            case 2:
                this.taskType = "Test";
                break;
            case 3:
                this.taskType = "Design";
                break;
            case 4:
                this.taskType = "Review";
                break;
        }
        this.date = Validation.getString(
                "Enter your date: ", 
                "Must follow dd/mm/yy", 
                "Invalid String", 
                Constant.REGEX_DATE_OF_BIRTH);
        do{
            this.from = Validation.getDouble(
                    "Enter time from: ", 
                    "Must from 8 to 17.5", 
                    "Invalid number", 
                    8, 17.5);
            this.to = Validation.getDouble(
                    "Enter time to: ", 
                    "Must from 8 to 17.5", 
                    "Invalid number", 
                    8, 17.5);
            this.time = this.to - this.from;
        } while(this.from >= this.to); 
        this.assignee = Validation.getString(
                "Enter assignee name: ", 
                "Must have (a-zA_Z0-9)", 
                "Invalid String", 
                Constant.REGEX_NAME);
        this.reviewer = Validation.getString(
                "Enter reviewer name: ", 
                "Must have (a-zA_Z0-9)", 
                "Invalid String", 
                Constant.REGEX_NAME);

    }   
}
