package org.cap.pojo;

public class Department {

	private int no;
	private String name;
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public Department(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "\nDepartment [no=" + no + ", name=" + name + "]";
	}
	
}
