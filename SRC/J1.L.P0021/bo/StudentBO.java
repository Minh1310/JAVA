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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Nhat Anh
 */
public class StudentBO {

    private List<Student> list;
    private String messageNameNotMatchWithId = "Name not match with id";

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
    private boolean exist(Student student) {
        return list.stream().anyMatch(ls -> (ls.getId().equalsIgnoreCase(student.getId()) &&
                ls.getStudentName().equalsIgnoreCase(student.getStudentName()) &&
                ls.getSemester().equalsIgnoreCase(student.getSemester()) &&
                ls.getCourseName().equalsIgnoreCase(student.getCourseName())));
    }

    /**
     * Use to check student existed in student list
     * 
     * @param list list about information of student take from input
     * @param id   is ID of student take from input
     * @return true if ID existed and same semester or false if ID not exist
     */
    private boolean exist(String id, String name) {
        return list.stream().anyMatch(ls -> (ls.getId().equalsIgnoreCase(id) &&
                !ls.getStudentName().equalsIgnoreCase(name)));
    }

    private boolean exist(String id, String semester, String course) {
        return list.stream().anyMatch(ls -> (ls.getId().equalsIgnoreCase(id) &&
                ls.getSemester().equalsIgnoreCase(semester) &&
                ls.getCourseName().equalsIgnoreCase(course)));
    }

    /**
     * Use to check student is valid 
     * 
     * @param student
     * @return
     */
    private boolean validStudent(Student student) {
        if (exist(student.getId(), student.getStudentName())) {
            System.out.println(messageNameNotMatchWithId);
            student.setStudentName(
                    Validation.getString(
                            "Student name must is: " +
                            list.get(searchId(student.getId()).get(0)).getStudentName(),
                            "Name must is " +
                            list.get(searchId(student.getId()).get(0)).getStudentName(),
                            list.get(searchId(student.getId()).get(0)).getStudentName()).trim());
        }

        while (exist(student)) {
            student.display();
            System.out.println(Constant.messageStudentExist);
            int choice = Validation.getInt(
                    "Enter 1 to continue set, 2 to continue add",
                    "Out of range",
                    "Invalid number",
                    1, 2);
            if (choice == 1) {
                student.setSemester(
                        Validation.getString(
                                "Enter your semester: ",
                                "Must follow fomat",
                                Constant.CONDITION_SEMESTER));
                student.setCourseName(
                        Validation.getString(
                                "Enter your course name: ",
                                "Must follow fomat: JAVA, .NET, C/C++",
                                Constant.CONDITION_COURSE_NAME));
            } else {
                return false;
            }
        }
        return !exist(student);
    }

    /**
     * Use to get new student from input
     * 
     * @return
     */
    public boolean add() {
        Student student = new Student();
        student.input();
        return validStudent(student) ? list.add(student) : false;
    }

    /**
     * Use to find student list find by name
     * 
     * @param text
     * @return
     */
    public List<Student> searchName(String text) {
        List<Student> listFind = new ArrayList<>();
        list.forEach(a -> {
            if (a.getStudentName().toLowerCase().contains(text.toLowerCase())) {
                listFind.add(a);
            }
        });
        list.sort((o1, o2) -> o1.getStudentName().compareTo(o2.getStudentName()));
        return listFind;
    }

    /**
     * 
     * @param id
     * @return
     */
    public boolean remove(String id) {
        ListIterator<Student> iterator = list.listIterator();
        int count = 0;
        while (iterator.hasNext()) {
            if (iterator.next().getId().equalsIgnoreCase(id)) {
                iterator.remove();
                count++;
            }
        }
        return count > 0;
    }

    /**
     * 
     * @param id
     * @return a Integer list have value is index of ID
     */
    private List<Integer> searchId(String id) {
        List<Integer> number = new ArrayList<>();
        int index = 0;
        for (Student obj : list) {
            if (obj.getId().equalsIgnoreCase(id)) {
                number.add(index);
            }
            index++;
        }
        return number;
    }

    /**
     * 
     * @param id
     * @return
     */
    public boolean update(String id) {
        List<Integer> listIndex = searchId(id);
        if (listIndex.isEmpty()) {
            return false;
        }
        int index = 0;
        for (Integer integer : listIndex) {
            System.out.print(index + ". ");
            list.get(integer).display();
            index++;
        }
        int choice = 0;
        int count = 0;
        Student student = null;
        while (choice != 3) {
            System.out.println("1. update name");
            System.out.println("2. update semester and course");
            System.out.println("3. exit");
            choice = Validation.getInt(
                    "Enter your choice:",
                    "Your choice must be 1 to 4!",
                    "Number is not valid!",
                    1, 3);
            if (choice == 2 && count == 0) {
                int positionChange = Validation.getInt(
                        "Enter number line you want update: ",
                        "Out of range",
                        "Invalid number",
                        0, listIndex.size());
                student = list.get(listIndex.get(positionChange));
                count++;
            }
            switch (choice) {
                case 1:
                    String newName = Validation.getString(
                            "Enter new student name: ",
                            "Your name just have character and digit",
                            Constant.CONDITION_STUDENT_NAME);
                    listIndex.forEach((index1) -> {
                        list.get(index1).setStudentName(newName);
                    });
                    break;
                case 2:
                    String semester, courseName;
                    do {
                        semester = Validation.getString(
                                "Enter new your semester: ",
                                "Your semester just have character and digit",
                                Constant.CONDITION_SEMESTER);
                        courseName = Validation.getString(
                                "Enter new your course name: ",
                                "Must follow fomat: JAVA, .NET, C/C++",
                                Constant.CONDITION_COURSE_NAME);
                        if (!exist(student.getId(), semester, courseName)) {
                            break;
                        }
                        System.out.println(Constant.messageStudentExist);
                    } while (true);
                    student.setSemester(semester);
                    student.setCourseName(courseName);
                    break;
                case 3:
                    break;
            }
        }
        return true;
    }

    /**
     * 
     * @param list
     */
    public void report(String course) {
        List<Student> listCourse = new ArrayList<>();
        Set<String> uniqueId = new HashSet<>();
        list.forEach(a -> {
            if (a.getCourseName().equalsIgnoreCase(course)) {
                listCourse.add(a);
                uniqueId.add(a.getId());
            }
        });
        if (listCourse.isEmpty()) {
            System.out.println("Don have information");
        }
        // Map to store the counts
        Map<String, Integer> countMap = new HashMap<>();

        // Process the data
        for (Student student : listCourse) {
            String id = student.getId();
            countMap.put(id, countMap.getOrDefault(id, 0) + 1);
        }
        uniqueId.forEach(a -> {
            for (Student student : listCourse) {
                if (a.equalsIgnoreCase(student.getId())) {
                    System.out.printf("%10s|%10s|%10s",
                            student.getStudentName(),
                            student.getCourseName(),
                            countMap.get(student.getId()));
                    System.out.println();
                    break;
                }
            }
        });
    }

    /**
     * 
     * @param list
     */
    public void display(List<Student> list) {
        if (list.isEmpty()) {
            System.out.println("Empty");
            return;
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
            return;
        }
        list.forEach(a -> {
            a.display();
        });
    }
}
