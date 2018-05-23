package com.welle.design.pattern.prototype;

import java.util.ArrayList;

// clone pattern

public class Employee implements Cloneable {

	private ArrayList<String> empList;

	public Employee() {
		this.empList = new ArrayList<String>();
	}

	public Employee(ArrayList<String> list) {
		this.empList = list;
	}

	public void addEmployee(String e) {
		empList.add(e);
	}

	public void removeEmployee(String e) {
		empList.remove(empList.indexOf(e));
	}

	public void printEmployees() {
		for (String e : empList) {
			System.out.println(e);
		}
	}

	@Override
	public Employee clone() {
		ArrayList<String> temp = new ArrayList<String>();
		for (String e : empList) {
			temp.add(e);
		}
		return new Employee(temp);
	}

}
