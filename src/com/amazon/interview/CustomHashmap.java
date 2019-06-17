package com.amazon.interview;

public class CustomHashmap {

	Node[]ary = new Node[16];
	
	
	public void put(Object key, Object value) {
		
	}
	
	public Object get(Object Key)   {
		
		return null;
	}
	
}



class Employee {
	
	private String firstName;
	private String secondName;
	private int empid;
	
	Employee(String firstName, String secondName){
		this.firstName = firstName;
		this.secondName = secondName;
	}
	
	public int hashCode() {
		
		int result = 17;
		
		result = result*13+ firstName.hashCode();
		result = result *13 + secondName.hashCode();
		result = result *13 + empid;
		return result;
	}
	
	public int hash(int no) {
		return no*6^no*12^no*12;
	}
	
	
	public int  remainder(int no) {
		int remainder = no&1000>>1;
		return remainder;
	}
	
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null)
			return false;
		if(!(obj instanceof Employee))
			return false;
		Employee emp = (Employee)obj;
		
		if(!this.firstName.equals(emp.firstName) || !this.secondName.equals(emp.secondName)
				|| this.empid!=emp.empid) {
			return false;
		}
		return true;
	}
}
