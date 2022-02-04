package com.lths.schoolmanagement.crudoperation;

import java.util.ArrayList;
import java.util.Iterator;

import com.lths.schoolmanagement.entity.Teacher;

public class TeacherCRUD {
	
	ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	
	public int createTeachersDetails(Teacher t) {
		
		teacherList.add(t);
		return t.getId();
	}

	public ArrayList<Teacher>getAllTeacherDetails(){
		
		return teacherList;
	}
	
	public Teacher getTeacherDetails(int id) {
		Iterator<Teacher> itr = teacherList.iterator();
		while(itr.hasNext()) {
			Teacher t = itr.next();
			if(t.getId()==id) {
				return t;
			}
		}
		return null;
	}
	
	public int updateTeacherDetails(Teacher t) {
		Iterator<Teacher> itr = teacherList.iterator();
		int count = 0;
		while(itr.hasNext()) {
			Teacher t1 = itr.next();
			if(t1.getId()== t.getId()) {
				teacherList.set(count,t);
					return t.getId();
			}
		}
		
		return 0;
	}
	
	public int deleteTeacherDetails(int id) {
		Iterator<Teacher> itr = teacherList.iterator();
		while(itr.hasNext()) {
			Teacher t = itr.next();
			if(t.getId()==id) {
				teacherList.remove(t);
				return t.getId();
			}
		}
		return 0;
		
	}
	
}
