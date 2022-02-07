package com.hcl.pojos;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

public class Department {
	
	
	private ArrayList<Employee> emps;
	
	private int no;
	private String title;
	public Department() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public Department(ArrayList<Employee> emps, int no, String title) {
		super();
		this.emps = emps;
		this.no = no;
		this.title = title;
	}
	public  ArrayList<Employee> getEmps() {
		return emps;
	}
	public void setEmps( ArrayList<Employee> emps) {
		this.emps = emps;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Department [ no=" + no + ", title=" + title + "]\n"+"Employees=" + emps;
	}
	
}
