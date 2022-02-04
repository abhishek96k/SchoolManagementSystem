package com.lths.schoolmanagement.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.lths.schoolmanagement.crudoperation.SchoolCRUD;
import com.lths.schoolmanagement.crudoperation.SupportiveStaffCRUD;
import com.lths.schoolmanagement.crudoperation.TeacherCRUD;
import com.lths.schoolmanagement.crudoperation.studentCRUD;
import com.lths.schoolmanagement.customexception.StandardValueException;
import com.lths.schoolmanagement.customexception.YearOfOpeningValueException;
import com.lths.schoolmanagement.entity.*;

public class Main {
	
	SchoolCRUD schoolCRUD = new SchoolCRUD();
	TeacherCRUD teacherCRUD = new TeacherCRUD();
	studentCRUD studentCRUD = new studentCRUD();
	SupportiveStaffCRUD supportiveStaffCRUD = new SupportiveStaffCRUD(); 
	
	public static void main(String[] args) {
		Main m = new Main();
		System.out.println("Welcome to SchoolManagement Services. We are providing following functionalities: ");
		Scanner sc = new Scanner(System.in);
		int parentChoice = 0;
		do {
			System.out.println("\n 1.Enter 1 to perform Student related operation\n 2.Enter 2 to perform Supportive Staff related operation\n 3.Enter 3 to perform Teacher related operation\n 4.Enter 4 to perform School related operation\n 5.Enter 5 to exist the program ");
			parentChoice = sc.nextInt();
			if(parentChoice >= 1 || parentChoice <= 5) {
				int childChoice = 0;
				switch(parentChoice) {
				
				case 1:
					System.out.println(" 1.Enter 1 to create Student\n 2.Enter 2 to get List of Student present at a time\n 3.Enter 3 to get Student based on roll no\n 4.Enter 4 to update Student Details\n 5.Enter 5 to Delete Student Details\n 6.Enter 6 to go back main menu");
					childChoice = sc.nextInt();
					try {
						m.studentTask(childChoice,sc);
					} catch (StandardValueException e1) {
						System.out.println("error generated: " +e1.getMessage());
					}
					break;
				
				case 2:
					System.out.println(" 1.Enter 1 to create Supportive Staff\\n 2.Enter 2 to get List of Supportive Staff present at a time\\n 3.Enter 3 to get Supportive Staff based on id\\n 4.Enter 4 to update Supportive Staff Details\\n 5.Enter 5 to Delete Supportive Staff Details\\n 6.Enter 6 to go back main menu");
					childChoice = sc.nextInt();
					m.supportiveStaffTask(childChoice,sc);
					
					break;
					
				case 3:
					System.out.println(" 1.Enter 1 to create Teacher\n 2.Enter 2 to get List of Teacher present at a time\n 3.Enter 3 to get Teacher based on id\n 4.Enter 4 to update Teacher Details\n 5.Enter 5 to Delete Teacher Details\n 6.Enter 6 to go back main menu");
					childChoice = sc.nextInt();
					m.teacherTask(childChoice,sc);
					break;
					
				case 4:
					System.out.println(" 1.Enter 1 to create School\n 2.Enter 2 to get List of School present at a time\n 3.Enter 3 to get School based on schoolID\n 4.Enter 4 to update School Details\n 5.Enter 5 to Delete School Details\n 6.Enter 6 to go back main menu");
					childChoice = sc.nextInt();
					try {
						m.schoolTask(childChoice,sc);
					} catch (YearOfOpeningValueException e) {
						System.out.println("error generated: " +e.getMessage());
					}
					break;
				
				case 5:
					System.out.println("Thank you for using our services. Please visit again");
					break;
				}
			} else {
				System.out.println("Please enter valid choice.");
			}
		} while(parentChoice != 5);
		
	}

	private void schoolTask(int childChoice, Scanner sc) throws YearOfOpeningValueException {
		switch(childChoice) {
		case 1:
			System.out.println("Please enter following details to create School.");
			School school = getSchoolDetailsFromUser(sc);
			System.out.println("School created successfully with ID " + schoolCRUD.createSchoolDetails(school));
			break;
		
		case 2:
			ArrayList<School> schoolList = schoolCRUD.getAllSchoolDetails();
			schoolList.stream().forEach((schoolFromList) -> System.out.println(schoolFromList));
			break;
			
		case 3:
			schoolTask(2,sc);
			System.out.println("Please enter school ID for which you want details:");
			int sid = sc.nextInt();
			School s1 = schoolCRUD.getSchoolDetail(sid);
			if(s1 != null) {
				System.out.println(s1);
			} else {
				System.out.println("No details found...");
			}
			break;
			
		case 4:
			schoolTask(2,sc);
			System.out.println("Please enter school ID which you want to update:");
			int sid1 = sc.nextInt();
			School updatedObject = getSchoolDetailsFromUser(sc);
			updatedObject.setSchoolID(sid1);
			int value = schoolCRUD.updateSchoolDetails(updatedObject);
			if(value > 0) {
				System.out.println(value + " updated successfully.");
			} else {
				System.out.println("No details found...");
			}
			break;
			
		case 5:
			schoolTask(2,sc);
			System.out.println("Please enter school id which you want to delete.");
			int s = sc.nextInt();
			int deletedId = schoolCRUD.deleteSchoolDetails(s);
			if(deletedId > 0) {
				System.out.println(deletedId + " deleted successfully.");
			} else {
				System.out.println("No details found...");
			}
			break;
			
		case 6:
			System.out.println("You are navigating back to main menu...");
			break;
		} 
	}

	private School getSchoolDetailsFromUser(Scanner sc) throws YearOfOpeningValueException {
		System.out.println("Please enter schoolID");
		int schoolID = sc.nextInt();
		System.out.println("Please enter schoolName");
		String name = sc.next();
		System.out.println("Please enter year of opening");
		String yearOfOpening = sc.next();
		boolean isValid = Pattern.matches("\\d+",yearOfOpening);
		if(!isValid) {
			throw new YearOfOpeningValueException("invalid value entered for year of opening value must be in form of digits.");
		}
		System.out.println("Please enter medium");
		String medium = sc.next();
		School school = new School(name,yearOfOpening, medium, schoolID);
		return school;
	}

	private void supportiveStaffTask(int childChoice, Scanner sc) {
		switch(childChoice) {
		case 1:
			System.out.println("Please enter required supportive staff details...");
			SupportiveStaff ss = getSupportiveStaffDetailsFromUser(sc);
			System.out.println("Staff object created with " + supportiveStaffCRUD.createSupportiveStaffDetails(ss));
			break;
			
		case 2:
			ArrayList<SupportiveStaff> ssList = supportiveStaffCRUD.getAllSupportiveStaffDetails();
			ssList.stream().forEach((ssFromList) -> System.out.println(ssFromList));
			break;
			
		case 3:
			supportiveStaffTask(2,sc);
			System.out.println("Please enter id for each yo want details.");
			int ssid = sc.nextInt();
			SupportiveStaff ss1 = supportiveStaffCRUD.getSupportiveStaffDetails(ssid);
			if(ss1 != null) {
				System.out.println(ss1);
			} else {
				System.out.println("Details not found...");
			}
			break;
			
		case 4:
			supportiveStaffTask(2, sc);
			System.out.println("Enter id for which you want to update the details.");
			int sid = sc.nextInt();
			SupportiveStaff updatedObject =getSupportiveStaffDetailsFromUser(sc);
			updatedObject.setId(sid);
			int updatedId = supportiveStaffCRUD.updateSupportiveStaffDetails(updatedObject);
			if(updatedId > 0) {
				System.out.println(updatedId + " Updated successfully...");
			} else {
				System.out.println("No details found...");
			}
			break;
			
		case 5:
			supportiveStaffTask(2, sc);
			System.out.println("Enter id which you want to delete...");
			int deleteID = sc.nextInt();
			int deletedId = supportiveStaffCRUD.deleteSupportiveStaffDetails(deleteID);
			if(deletedId > 0) {
				System.out.println(deletedId + " deleted successfully...");
			} else {
				System.out.println("No details found...");
			}
			break;
		
		case 6:
			System.out.println("You are navigating back to main menu...");
			break;
		}
	}

	private SupportiveStaff getSupportiveStaffDetailsFromUser(Scanner sc) {
		System.out.println("Please enter following details to create supportive staff object.");
		System.out.println("Please enter name: ");
		String name = sc.next();
		System.out.println("Please enter age: ");
		int age = sc.nextInt();
		System.out.println("Please enter address: ");
		String address = sc.next();
		System.out.println("Please enter id: ");
		int id2 = sc.nextInt();
		System.out.println("Please enter domain: ");
		String domain = sc.next();
		SupportiveStaff ss = new SupportiveStaff(name, age, address, id2, domain);
		
		return ss;
	}

	private void teacherTask(int childChoice, Scanner sc) {
		switch(childChoice) {
		case 1:
			Teacher teacher = getTeacherDetailsFromUser(sc);
			System.out.println("Teacher object is created with " + teacherCRUD.createTeachersDetails(teacher) + " id.");
			break;
			
		case 2:
			ArrayList<Teacher>teacherList = teacherCRUD.getAllTeacherDetails();
			teacherList.stream().forEach((teacherFromList) -> System.out.println(teacherFromList));
			break;
			
		case 3:
			teacherTask(2,sc);
			System.out.println("Please enter id for which you want details...");
			int teacherID = sc.nextInt();
			Teacher teach = teacherCRUD.getTeacherDetails(teacherID);
			if(teach != null) {
				System.out.println(teach);
			} else {
				System.out.println("No Detail found...");
			}
			break;
			
		case 4:
			teacherTask(2,sc);
			System.out.println("for which id you want to update teacher details...");
			int teacherid = sc.nextInt();
			Teacher t1 = getTeacherDetailsFromUser(sc);
			t1.setId(teacherid);
			int updateID = teacherCRUD.updateTeacherDetails(t1);
			if(updateID > 0) {
				System.out.println(updateID + " Updated successfully...");
			} else {
				System.out.println("No details found...");
			}
			break;
			
		case 5:
			teacherTask(2,sc);
			System.out.println("Enter teacher id which you want to delete...");
			int id = sc.nextInt();
			int deletedID =teacherCRUD.deleteTeacherDetails(id);
			if(deletedID > 0) {
				System.out.println(deletedID + " Deleted successfully...");
			} else {
				System.out.println("No details found...");
			}
			break;
			
		case 6:
			System.out.println("You are navigating back to main menu...");
			break;
		}
	}

	private Teacher getTeacherDetailsFromUser(Scanner sc) {
		System.out.println("Please enter following details to create teacher.");
		System.out.println("Please enter name: ");
		String name = sc.next();
		System.out.println("Please enter age: ");
		int age = sc.nextInt();
		System.out.println("Please enter address: ");
		String address = sc.next();
		System.out.println("Please enter teacher ID: ");
		int id = sc.nextInt();
		System.out.println("Please enter qualification (enter in comma seperated mode): ");
		String qualification = sc.next();
		System.out.println("Please enter subject (enter in comma seperated mode)");
		String subject = sc.next();
		Teacher teacher = new Teacher(name, age, address,id,qualification,subject);
		return teacher;
	}

	private void studentTask(int childChoice, Scanner sc) throws StandardValueException {
		switch(childChoice) {
		
		case 1:
			Student s = getStudentDetailsFromUser(sc);
			System.out.println("Student is created and added to Student list with "+studentCRUD.createStudent(s) +" rollNo.");
			break;
			
		case 2:
			ArrayList<Student>studentList = studentCRUD.getAllStudentDetails();
			studentList.stream().forEach((studentFromList) -> System.out.println(studentFromList));
			break;
			
		case 3:
			System.out.println("Please enter roll no to get Student Detail.");
			int rno = sc.nextInt();
			Student searchStudent = studentCRUD.getStudentDetailByRollNo(rno);
			if(searchStudent != null) {
				System.out.println(searchStudent);
			} else {
				System.out.println("no details found...");
			}
			break;
			
		case 4:
			studentTask(2,sc);
			System.out.println("Enter roll No for which you want to update the details ");
			int rno1 = sc.nextInt();
			Student updatedData = getStudentDetailsFromUser(sc);
			updatedData.setRollNo(rno1);
			int updatedStudentRollNo = studentCRUD.updateStudentDetail(updatedData);
			if(updatedStudentRollNo > 0) {
				System.out.println("Updated Student's rollNo: "+ updatedStudentRollNo);	
			} else {
				System.out.println("No details found with given roll no to update. ");
			}
			break;
			
		case 5:
			studentTask(2,sc);
			System.out.println("Enter roll No for which you want to dalete the details ");
			int rno2 = sc.nextInt();
			int deletedStudentRollNo = studentCRUD.deleteStudentDetails(rno2);
			if(deletedStudentRollNo > 0) {
				System.out.println("Student data deleted with this roll no " + deletedStudentRollNo);
			} else {
				System.out.println("No Student details found with given roll No " + rno2);
			}
			break;
			
		case 6:
			System.out.println("You are navigating back to main menu. ");
			break;
		}
	}

	private Student getStudentDetailsFromUser(Scanner sc) throws StandardValueException {
		
		System.out.println("Please enter following student details...");
		System.out.println("Please enter name: ");
		String name = sc.next();
		System.out.println("Please enter age: ");
		int age = sc.nextInt();
		System.out.println("Please enter address: ");
		String address = sc.next();
		System.out.println("Please enter your roll No: ");
		int rollNo = sc.nextInt();
		System.out.println("Please enter your standard: ");
		int standard = sc.nextInt();
		if(standard < 0 || standard > 12) {
			throw new StandardValueException(" invalid value entered for standard. it must be between 1 to 12 "); 
		}
		System.out.println("Please enter your area of interest: ");
		String areaOfInterest = sc.next();
		Student s = new Student(name, age, address, rollNo, standard, areaOfInterest);
		return s;
	
	}
}




















