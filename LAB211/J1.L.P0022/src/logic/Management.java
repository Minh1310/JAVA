package logic;

import java.util.ArrayList;

import constant.Constant;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import validation.Validation;

public class Management {
    /**
     * Use to add new experience into list
     * 
     * @param list is list information about Experience
     */
    public void addExperience(ArrayList<Experience> list){

        String id = Validation.getString(
                    "Enter your ID: ", 
                    "Must follow fomat " + Constant.REGEX_ID, 
                    "Your ID not valid", 
                    Constant.REGEX_ID
        );
        String firstName = Validation.getString(
                    "Enter your first name: ", 
                    "Must have(a-zA-Z)", 
                    "Invalid string", 
                    Constant.REGEX_NAME
        );
        String lastName = Validation.getString(
                    "Enter your last name: ", 
                    "Must have(a-zA-Z)", 
                    "Invalid string", 
                    Constant.REGEX_NAME
        );
        String birthDate = Validation.getString(
                    "Enter your birth date: ", 
                    "Must follow dd/mm/yy", 
                    "Invalid string", 
                    Constant.REGEX_DATE_OF_BIRTH
        ); 
        String address = Validation.getString(
                    "Enter your address: ", 
                    "Must follow (a-zA-Z0-9)", 
                    "Invalid string", 
                    Constant.REGEX_NORMAL
        );
        String phone = Validation.getString(
                    "Enter your phone: ", 
                    "Must have 10 or 11 number", 
                    "Invalid string", 
                    Constant.REGEX_PHONE
        );
        String email = Validation.getString(
                    "Enter your email: ", 
                    "Must follow fomat email", 
                    "Invalid string", 
                    Constant.REGEX_EMAIL
        ); 
        int type = 0;
        
        int yearOfExp = Validation.getInt(
                    "Enter year of experience: ", 
                    "It's invalid experience", 
                    "Invalid number", 
                    0,100
        );
        String proSkill = Validation.getString(
                    "Enter professional skill: ", 
                    "Must follow format", 
                    "Invalid string", 
                    Constant.REGEX_NORMAL
        );

        list.add(new Experience(id, firstName, lastName, 
                                birthDate, address, phone, 
                                email, type, yearOfExp, proSkill)
        );
    }

    /**
     * Use to add new experience into list
     * 
     * @param list is list information about Fresher
     */
    public void addFresher(ArrayList<Fresher> list){
        String id = Validation.getString(
                    "Enter your ID: ", 
                    "Must follow fomat: HE171754", 
                    "Your ID not valid", 
                    Constant.REGEX_ID
        );
        String firstName = Validation.getString(
                    "Enter your first name: ", 
                    "Must have(a-zA-Z)", 
                    "Invalid string", 
                    Constant.REGEX_NAME
        );
        String lastName = Validation.getString(
                    "Enter your last name: ", 
                    "Must have(a-zA-Z)", 
                    "Invalid string", 
                    Constant.REGEX_NAME
        );
        String birthDate = Validation.getString(
                    "Enter your birth date: ", 
                    "Must follow dd/mm/yy", 
                    "Invalid string", 
                    Constant.REGEX_DATE_OF_BIRTH
        ); 
        String address = Validation.getString(
                    "Enter your address: ", 
                    "Must follow (a-zA-Z0-9)", 
                    "Invalid string", 
                    Constant.REGEX_NORMAL
        );
        String phone = Validation.getString(
                    "Enter your phone: ", 
                    "Must have 10 or 11 number", 
                    "Invalid string", 
                    Constant.REGEX_PHONE
        );
        String email = Validation.getString(
                    "Enter your email: ", 
                    "Must follow fomat email", 
                    "Invalid string", 
                    Constant.REGEX_EMAIL
        ); 
        int type = 1;
        String graduationDate = Validation.getString(
                    "Enter your graduation date: ", 
                    "Must follow fomat email", 
                    "Invalid string", 
                    Constant.REGEX_DATE_OF_BIRTH
        ); 

        String graduationRank = Validation.getString(
                "Enter your graduation rank: ",
                "Must follow: " + Constant.REGEX_GRADUATE_RANK,
                "Invalid string",
                Constant.REGEX_GRADUATE_RANK
        );
        
        String education = Validation.getString(
                    "Enter your education: ", 
                    "Must follow fomat email", 
                    "Invalid string", 
                    Constant.REGEX_NORMAL
        ); 

        list.add(new Fresher(
                    id, firstName, lastName, birthDate, 
                    address, phone, email, type, graduationDate, 
                    graduationRank, education));
    }

    /**
     * Use to add new intern into list
     * 
     * @param list is list information about Intern
     */
    public void addIntern(ArrayList<Intern> list){
        String id = Validation.getString(
                    "Enter your ID: ", 
                    "Must follow fomat: HE171754", 
                    "Your ID not valid", 
                    Constant.REGEX_ID
        );
        String firstName = Validation.getString(
                    "Enter your first name: ", 
                    "Must have(a-zA-Z)", 
                    "Invalid string", 
                    Constant.REGEX_NAME
        );
        String lastName = Validation.getString(
                    "Enter your last name: ", 
                    "Must have(a-zA-Z)", 
                    "Invalid string", 
                    Constant.REGEX_NAME
        );
        String birthDate = Validation.getString(
                    "Enter your birth date: ", 
                    "Must follow dd/mm/yy", 
                    "Invalid string", 
                    Constant.REGEX_DATE_OF_BIRTH
        ); 
        String address = Validation.getString(
                    "Enter your address: ", 
                    "Must follow (a-zA-Z0-9)", 
                    "Invalid string", 
                    Constant.REGEX_NORMAL
        );
        String phone = Validation.getString(
                    "Enter your phone: ", 
                    "Must have 10 or 11 number", 
                    "Invalid string", 
                    Constant.REGEX_PHONE
        );
        String email = Validation.getString(
                    "Enter your email: ", 
                    "Must follow fomat email", 
                    "Invalid string", 
                    Constant.REGEX_EMAIL
        ); 
        int type = 2;
        String majoy = Validation.getString(
                    "Enter your majoy: ", 
                    "Must follow fomat", 
                    "Invalid string", 
                    Constant.REGEX_NAME
        ); 
        String semester = Validation.getString(
                    "Enter your semester: ", 
                    "Must follow fomat", 
                    "Invalid string", 
                    Constant.REGEX_NORMAL
        ); 
        String nameUniversity = Validation.getString(
                    "Enter your university name: ", 
                    "Must follow fomat", 
                    "Invalid string", 
                    Constant.REGEX_NAME
        ); 
        list.add(new Intern(id, firstName, lastName, 
                            birthDate, address, phone, email, 
                            type, majoy, semester, nameUniversity));
    }
    
    /**
     * 
     * @param list
     */
    public void search(
                ArrayList<Experience> expList,
                ArrayList<Fresher> freList,
                ArrayList<Intern> intList
    ) {

        String name = Validation.getString(
                    "Enter your first name or last name : ", 
                    "Must have(a-zA-Z)", 
                    "Invalid string", 
                    Constant.REGEX_NAME
        ).toLowerCase();
        int candidateType = Validation.getInt(
                    "Enter your candidate type: ", 
                    "Must from 1-3", 
                    "Invalid string", 
                    0,2
        );
        
        switch(candidateType){
            case 0:
                for(Experience ls : expList){
                    if(
                        ls.getFirstName().toLowerCase().contains(name)|| 
                        ls.getLastName().toLowerCase().contains(name)
                    ) {
                        System.out.println(
                        ls.getFirstName()+" "+ls.getLastName()+ " | " +
                        ls.getBirthDate() +" | "+ ls.getAddress() + " | "+
                        ls.getPhone() +" | "+ ls.getEmail() +" | "+
                        ls.getCandidateType()
                        );
                    }
                }
            break;
            case 1:
                for(Fresher ls : freList){
                    if(
                        ls.getFirstName().toLowerCase().contains(name)|| 
                        ls.getLastName().toLowerCase().contains(name)
                    ) {
                        System.out.println(
                        ls.getFirstName()+" "+ls.getLastName()+ " | " +
                        ls.getBirthDate() +" | "+ ls.getAddress() + " | "+
                        ls.getPhone() +" | "+ ls.getEmail() +" | "+
                        ls.getCandidateType()
                        );
                    }
                }
            break;
            case 2:
                for(Intern ls : intList){
                    if(
                        ls.getFirstName().toLowerCase().contains(name)|| 
                        ls.getLastName().toLowerCase().contains(name)
                    ) {
                        System.out.println(
                        ls.getFirstName()+" "+ls.getLastName()+ " | " +
                        ls.getBirthDate() +" | "+ ls.getAddress() + " | "+
                        ls.getPhone() +" | "+ ls.getEmail() +" | "+
                        ls.getCandidateType()
                        );
                    }
                }
            break;
        }
    }

    /**
     * 
     * @param list
     */
    public void display(ArrayList list) {
        if(list.isEmpty()){
            System.out.println("Empty!");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
