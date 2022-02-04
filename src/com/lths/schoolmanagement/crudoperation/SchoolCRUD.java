package com.lths.schoolmanagement.crudoperation;

import java.util.ArrayList;
import java.util.Iterator;

import com.lths.schoolmanagement.entity.School;

public class SchoolCRUD {
	
	public ArrayList<School>schoolList = new ArrayList<School>();
	public int createSchoolDetails(School s) {
		schoolList.add(s);
		return s.getSchoolID();
	}

	public ArrayList<School>getAllSchoolDetails(){
		
		return schoolList;
	}
	
	public School getSchoolDetail(int schoolId) {
		
		Iterator<School>itr = schoolList.iterator();
		while(itr.hasNext()) {
			
			School s = itr.next();
			if(s.getSchoolID()==schoolId) {
				
				return s;
			}
		}
		return null;
	}
	
	public int updateSchoolDetails(School s) {
		Iterator<School> itr = schoolList.iterator();
		int count = 0;
		while(itr.hasNext()) {
			School s1 = itr.next();
			if(s1.getSchoolID() == s.getSchoolID()) {
				schoolList.set(count,s);
				return s.getSchoolID();
			}
			count++;
		}
		
		return 0;
	}
	
	public int deleteSchoolDetails(int id) {
		
		Iterator<School> itr = schoolList.iterator();
		while(itr.hasNext()) {
			School s = itr.next();
			if(s.getSchoolID()==id) {
				schoolList.remove(s);
				return s.getSchoolID();
			}
		}
		return 0;
	}
}
