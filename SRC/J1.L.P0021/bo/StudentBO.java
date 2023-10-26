/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import constant.Constant;
import entity.Student;
import utils.Validation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nhat Anh
 */
public class StudentBO {

    private List<Student> list;

    public StudentBO() {
        this.list = new ArrayList<>();
        list.add(new Student("HE171754", "A", "Summer", "java"));
        list.add(new Student("HE171754", "A", "Fall", "java"));
        list.add(new Student("HE171755", "B", "Summer", "java"));
        list.add(new Student("HE171755", "B", "Fall", "java"));
        list.add(new Student("HE171754", "A", "Spring", "java"));
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public StudentBO(List<Student> list) {
        this.list = list;
    }

    /**
     * Use to check student existed in student list
     * 
     * @param list list about information of student take from input
     * @param id   is ID of student take from input
     * @return true if ID existed and same semester or false if ID not exist
     */
    private boolean exist(String id, String semester, String course) {
        return list.stream().anyMatch((ls) -> (ls.getId().equalsIgnoreCase(id) &&
                ls.getSemester().equalsIgnoreCase(semester) &&
                ls.getCourseName().equalsIgnoreCase(course)));
    }

    /**
     * Use to get new student from input
     * 
     * @return 
     */
    public boolean add() {
        Student student = new Student();
        student.input();
        if (exist(student.getId(), student.getSemester(), student.getCourseName())) {
            return false;
        }
        list.add(student);
        return true;
    }

    /**
     * Use to find student list find by name
     * 
     * @param text
     * @return 
     */
    public List<Student> search(String text) {
        List<Student> listFind = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentName().contains(text)) {
                listFind.add(list.get(i));
            }
        }
        list.sort((o1, o2) -> o1.getStudentName().compareTo(o2.getStudentName()));
        return listFind;
    }

    /**
     * 
     * @param id
     * @return
     */
    public boolean remove(String id) {
        Integer[] index = searchIndex(id);
        int count = 0;
        for (Integer index1 : index) {
            list.remove(index1 - count);
            count++;
        }
        return true;
    }

    /**
     * 
     * @param id
     * @return a Integer array have value is index search
     */
    private Integer[] searchIndex(String id) {
        LinkedList<Integer> number = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                number.add(i);
            }
        }
        return number.toArray(new Integer[number.size()]);
    }

    /**
     * 
     * @param id
     * @return
     */
    public boolean update(String id) {
        Integer[] index = searchIndex(id);
        if (index.length == 0) {
            return false;
        }
        int choice = 0;
        int count = 0;
        int indexChange = -1;
        while (choice != 4) {
            System.out.println("1. update name");
            System.out.println("2. update semester");
            System.out.println("3. update course");
            System.out.println("4. exit");
            choice = Validation.getInt(
                    "Enter your choice:",
                    "Your choice must be 1 to 4!",
                    "Number is not valid!",
                    1, 4);
            String newName;
            String semester = "";
            String courseName = "";
            if (index.length != 1) {
                if (choice != 1 && choice != 4 && count == 0) {
                    String semesterUpdate = Validation.getString(
                            "Enter your semester you update: ",
                            "Your semester just have character and digit",
                            "Your ID not valid",
                            Constant.CONDITION_SEMESTER);
                    for (int i = 0; i < index.length; i++) {
                        if (list.get(index[i]).getSemester().equalsIgnoreCase(semesterUpdate)) {
                            indexChange = i;
                        }
                    }
                    count++;
                }
            }
            switch (choice) {
                case 1:
                    newName = Validation.getString(
                            "Enter new student name: ",
                            "Your name just have character and digit",
                            "Your ID not valid",
                            Constant.CONDITION_STUDENT_NAME);
                    for (Integer index1 : index) {
                        list.get(index1).setStudentName(newName);
                    }

                    break;
                case 2:
                    boolean check2 = true;
                    do {
                        semester = Validation.getString(
                                "Enter new your semester: ",
                                "Your semester just have character and digit",
                                "Your ID not valid",
                                Constant.CONDITION_SEMESTER);
                        if (!exist(list.get(indexChange).getId(),
                                semester, list.get(indexChange).getCourseName())) {
                            check2 = false;
                        }
                    } while (check2);
                    list.get(indexChange).setSemester(semester);
                    break;
                case 3:
                    boolean check3 = true;
                    do {
                        courseName = Validation.getString(
                                "Enter new your course name: ",
                                "Must follow fomat: JAVA, .NET, C/C++",
                                "Your ID not valid",
                                Constant.CONDITION_COURSE_NAME);
                        if (!exist(list.get(indexChange).getId(),
                                list.get(indexChange).getSemester(), courseName)) {
                            check3 = false;
                        }
                    } while (check3);
                    list.get(indexChange).setCourseName(courseName);
                    break;
                case 4:
                    break;
            }
        }
        return true;
    }

    /**
     * 
     * @param list
     */
    public void display(List<Student> list) {
        if (list.isEmpty()) {
            System.out.println("Empty");
        }
        list.forEach(a -> {
            a.display();
        });
    }

    /**
     * Use to display information of student
     * 
     */
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Empty");
        }
        list.forEach(a -> {
            a.display();
        });
    }
}
