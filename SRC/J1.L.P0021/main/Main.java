package main;

import bo.StudentBO;
import constant.Constant;
import utils.Validation;

public class Main {
	public static void main(String[] args) {
		StudentBO studentBO = new StudentBO();
		System.out.println("----------------");

		int choice;
		do {
			System.out.println("1. Create");
			System.out.println("2. Find and Sort");
			System.out.println("3. Update/Delete");
			System.out.println("4. Report");
			System.out.println("5. Exit");
			choice = Validation.getInt("Enter your choice:", "Your choice must be 1 to 5!", "Number is not valid!", 1,
					5);
			switch (choice) {
			case 1:
				System.out.println("1");
				int count = 0;
				int choice1 = 0;
				do {
					System.out.println(studentBO.add() ? "success" : "fail");
					count++;
					if (count == 1) {
						System.out.println("Do you want continue add?");
						System.out.println("1. Continue");
						System.out.println("2. Exit");
						choice1 = Validation.getInt("Enter your choice: ", "Out of range", "Invalid", 1, 2);
						switch (choice) {
						case 1:
							count=0;
							break;
						case 2:
							break;
						}
					}
				} while (choice1 != 2);
				studentBO.display();
				break;
			case 2:
				System.out.println("2");
				String text = Validation.getString(
					"Enter text: ", 
					"Must follow fomat: Minh",
					Constant.CONDITION_STUDENT_NAME);
				studentBO.display(studentBO.searchName(text));
				break;
			case 3:
				System.out.println("3");
				int choice3 = 0;
				String id = Validation.getString(
					"Enter your ID: ", 
					"Must follow fomat: HE171754",
					Constant.CONDITION_ID);
				System.out.println("1. Update");
				System.out.println("2. Delete");
				choice3 = Validation.getInt(
					"Enter your choice:", 
					"Your choice must be 1 to 5!", 
					"Invalid", 1, 3);
				switch (choice3) {
				case 1:
					System.out.println(studentBO.update(id) ? 
					"Update success" : "Dont exist id or semester of id");
					break;
				case 2:
					System.out
							.println(studentBO.remove(id) ? 
							"Remove success" : "Remove fail because dont have this id");
					break;
				}
				studentBO.display();
				break;
			case 4:
				System.out.println("4");
				String courseName = Validation.getString(
						"Enter your course name: ",
						"Must follow fomat: JAVA, .NET, C/C++", 
						Constant.CONDITION_COURSE_NAME);
				studentBO.report(courseName);
				break;
			case 5:
				System.out.println("5");
				break;
			}
		} while (choice != 5);

	}
}
