package com.practice.equalshashcode;

import java.util.Objects;

public class Student {

	private int roleNumber;
	private String name;
	private String address;

	public Student(int roleNumber, String name, String address) {
		super();
		this.roleNumber = roleNumber;
		this.name = name;
		this.address = address;
	}

	public int getRoleNumber() {
		return roleNumber;
	}

	public void setRoleNumber(int roleNumber) {
		this.roleNumber = roleNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, name, roleNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return roleNumber == other.roleNumber;
	}
}