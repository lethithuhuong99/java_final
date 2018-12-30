package vnuk.huong170205.finalexam.model;


import java.util.Scanner;

import vnuk.huong170205.finalexam.controller.Controller;
import vnuk.huong170205.finalexam.controller.Observer;
import vnuk.huong170205.finalexam.define.Define;

public class Lecturer extends Person implements Observer {
	private String homeTown;
	private String department; 
	private String qualification; 
	private int allowance; 
	private int periodsInMonth;
	private float salaryRatio; 
	private int yearsOfWork;
	private float basicSalary;
	private boolean isCreated;
	
	public Lecturer() {}
	public String getHomeTown() {
		return homeTown;
	}
	
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getQualification() {
		return qualification;
	}
	
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	public int getAllowance() {
		return allowance;
	}
	
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	
	public int getPeriodsInMonth() {
		return periodsInMonth;
	}
	
	public void setPeriodsInMonth(int periodsInMonth) {
		this.periodsInMonth = periodsInMonth;
	}
	
	public float getSalaryRatio() {
		return salaryRatio;
	}
	
	public void setSalaryRatio(int salaryRatio) {
		this.salaryRatio = salaryRatio;
	}
	
	public int getYearsOfWork() {
		return yearsOfWork;
	}

	public void setYearsOfWork(int yearsOfWork) {
		this.yearsOfWork = yearsOfWork;
	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
		
	@Override
	public String toString() {
		return "Lecturer [homeTown=" + homeTown + ", department=" + department + ", qualification=" + qualification
				+ ", allowance=" + allowance + ", periodsInMonth=" + periodsInMonth + ", salaryRatio=" + salaryRatio
				+ ", yearsOfWork=" + yearsOfWork + ", basicSalary=" + basicSalary + ", id=" + id + ", name=" + name
				+ ", yearOfBirth=" + yearOfBirth + ", type=" + type + "]";
	}

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Name: " + (isCreated ? this.name : ""));
		this.name = sc.nextLine(); 
		
		System.out.print("Year of birth: " + (isCreated ? this.yearOfBirth : ""));
		this.yearOfBirth = Integer.parseInt(sc.nextLine()); 
		
		System.out.print("Home town: " + (isCreated ? this.homeTown : ""));
		this.homeTown = sc.nextLine(); 
		
		System.out.print("Department: " + (isCreated ? this.department : ""));
		this.department = sc.nextLine();
		
		System.out.print("Periods In Month: " + (isCreated ? this.periodsInMonth : ""));
		this.periodsInMonth = Integer.parseInt(sc.nextLine());
		
		System.out.print("Salary ratio: " + (isCreated ? this.salaryRatio : ""));
		this.salaryRatio = Float.parseFloat(sc.nextLine());
		
		System.out.print("Year of work: " + (isCreated ? this.yearsOfWork : ""));
		this.yearsOfWork = Integer.parseInt(sc.nextLine());
		
		this.basicSalary = Define.DEFAULT_BASIC_SALARY; 
		
		System.out.print("Choose qualification: " + (isCreated ? this.qualification : "") + " \n"
				+ "1: Bachelor.\n"
				+ "2: Master.\n"
				+ "3: Doctor.\n");
		
		int selection = Controller.inputChoice(1, 3);
		
		switch (selection) {
		case Define.TYPE_OF_BACHELOR : {
			this.qualification = Define.QUALIFICATION_OF_BACHELOR;
			this.allowance = Define.ALLOWANCE_OF_BACHELOR;
			break;
		}
		case Define.TYPE_OF_MASTER: {
			this.qualification = Define.QUALIFUCATION_OF_MASTER;
			this.allowance = Define.ALLOWANCE_OF_MASTER;
			break;
		}
		case Define.TYPE_OF_DOCTOR: {
			this.qualification = Define.QUALIFICATION_OF_DOCTOR;
			this.allowance = Define.ALLOWANCE_OF_DOCTOR;
			break;
		}
		}

		if (!isCreated)
			isCreated = true;
	}
	
	private Lecturer (LecturerBuilder builder) {
		this.isCreated = false;
		this.id = builder.id;
		this.name = builder.name; 
		this.yearOfBirth = builder.yearOfBirth;
		this.type = builder.type;		
		this.homeTown = builder.homeTown;
		this.department = builder.department; 
		this.qualification = builder.qualification; 
		this.allowance = builder.allowance; 
		this.periodsInMonth = builder.periodsInMonth;
		this.salaryRatio = builder.salaryRatio; 
		this.yearsOfWork = builder.yearsOfWork;
		this.basicSalary = builder.basicSalary; 
	}
	
	public static class LecturerBuilder {
		private int id;
		private String name; 
		private int yearOfBirth;
		private int type;		
		private String homeTown;
		private String department; 
		private String qualification; 
		private int allowance; 
		private int periodsInMonth;
		private float salaryRatio; 
		private int yearsOfWork;
		private float basicSalary;
		
		public LecturerBuilder(int type, int id ) {
			this.type = type;
			this.id = id;
		}
		public LecturerBuilder setName( String name) {
			this.name = name;
			return this;
		}
		
		public LecturerBuilder setYearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
			return this;
		}
		
		public LecturerBuilder setHomeTown(String homeTown) {
			this.homeTown = homeTown;
			return this;
		}

		public LecturerBuilder setDepartment(String department) {
			this.department = department;
			return this;
		}

		public LecturerBuilder setQualification(String qualification) {
			this.qualification = qualification;
			return this;
		}

		public LecturerBuilder setAllowance(String quatification) {
			switch(qualification) {
			case Define.QUALIFICATION_OF_BACHELOR: {
				this.allowance = Define.ALLOWANCE_OF_BACHELOR;
				break;
			}
			case Define.QUALIFICATION_OF_DOCTOR: {
				this.allowance = Define.ALLOWANCE_OF_DOCTOR;
				break;
			}
			case Define.QUALIFUCATION_OF_MASTER: {
				this.allowance = Define.ALLOWANCE_OF_MASTER;
				break;
			}
		}

			return this;
		}

		public LecturerBuilder setPeriodsInMonth(int periodsInMonth) {
			this.periodsInMonth = periodsInMonth;
			return this;
		}

		public LecturerBuilder setSalaryRatio(Float salaryRatio) {
			this.salaryRatio = salaryRatio;
			return this;
		}
	
		public LecturerBuilder setYearsOfWork(int yearsOfWork) {
			this.yearsOfWork = yearsOfWork;
			return this;
		}
		
		public LecturerBuilder setBasicSalary(float basicSalary) {
			this.basicSalary = basicSalary;
			return this;
		}
		
		public Lecturer build() {
			return new Lecturer(this);
		}
	}

	@Override
	public void update(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	@Override
	public float getSalary() {
		float salary = salaryRatio * basicSalary + allowance + periodsInMonth * 45;
		
		return salary;
	}
}
