package com.lths.schoolmanagement.crudoperation;

import java.util.ArrayList;
import java.util.Iterator;

import com.lths.schoolmanagement.entity.SupportiveStaff;

public class SupportiveStaffCRUD {
	
	ArrayList<SupportiveStaff> staffList = new ArrayList<SupportiveStaff>();
	
	public int createSupportiveStaffDetails(SupportiveStaff staffObject) {
		staffList.add(staffObject);
		
		return staffObject.getId();
	}

	public ArrayList<SupportiveStaff>getAllSupportiveStaffDetails(){
		return staffList;
	}
	
	public SupportiveStaff getSupportiveStaffDetails(int id) {
		Iterator<SupportiveStaff> itr = staffList.iterator();
		while(itr.hasNext()) {
			SupportiveStaff s = itr.next();
			if(s.getId()==id) {
				return s;
			}
		}
		return null;
	}
	public int updateSupportiveStaffDetails(SupportiveStaff s) {
		Iterator<SupportiveStaff> itr = staffList.iterator();
		int count = 0;
		while(itr.hasNext()) {
			SupportiveStaff s1 = itr.next();
			if(s1.getId()==s.getId()) {
				staffList.set(count,s);
				return s.getId();
			}
			count++;
		}		
		return 0;
	}
	
	public int deleteSupportiveStaffDetails(int id) {
		Iterator<SupportiveStaff> itr = staffList.iterator();
		while(itr.hasNext()) {
			SupportiveStaff s = itr.next();
			if(s.getId()==id) {
				staffList.remove(s);
				return s.getId();
			}
		}
		
		return 0;
	}
	
}
