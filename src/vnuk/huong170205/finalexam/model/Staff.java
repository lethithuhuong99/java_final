package vnuk.huong170205.finalexam.model;

import java.util.Scanner;

import vnuk.huong170205.finalexam.controller.Controller;
import vnuk.huong170205.finalexam.controller.Observer;
import vnuk.huong170205.finalexam.define.Define;

public class Staff extends Person implements Observer{
	private String homeTown;
	private String department;
	private int workDays;
	private float salaryRatio;
	private int allowance; 
	private String position;
	private int yearsOfWork;
	private float basicSalary;
	private boolean isCreated;
	
	public Staff() {}

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
	
	public int getWorkDays() {
		return workDays;
	}
	
	public void setWorkDays(int workdays) {
		this.workDays = workdays;
	}
	
	public float getSalaryRatio() {
		return salaryRatio;
	}
	
	public void setSalaryRatio(int salaryRatio) {
		this.salaryRatio = salaryRatio;
	}
	
	public int getAllowance() {
		return allowance;
	}
	
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public int getYearsOfWork() {
		return yearsOfWork;
	}
	
	public void setYearsOfWorl(int yearsOfWork) {
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
		return "Staff [homeTown=" + homeTown + ", department=" + department + ", workDays=" + workDays
				+ ", salaryRatio=" + salaryRatio + ", allowance=" + allowance + ", position=" + position
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
		
		System.out.print("Work days: " + (isCreated ? this.workDays : ""));
		this.workDays = Integer.parseInt(sc.nextLine());
		
		System.out.print("Salary ratio: " + (isCreated ? this.salaryRatio : ""));
		this.salaryRatio =Float.parseFloat(sc.nextLine());
		
		System.out.print("Year of work: " + (isCreated ? this.yearsOfWork : ""));
		this.yearsOfWork = Integer.parseInt(sc.nextLine());
		
		this.basicSalary = Define.DEFAULT_BASIC_SALARY; 
		
		System.out.print("Choose position: " + (isCreated ? this.position : "")+"\n"
				+ "1: Chief.\n"
				+ "2: Debuty.\n"
				+ "3: Employee.\n");
		
		int selection = Controller.inputChoice(1, 3);
		
		switch (selection) {
			case Define.TYPE_OF_CHIEF : {
				this.position = Define.POSITION_OF_CHIEF;
				this.allowance = Define.ALLOWANCE_OF_CHIEF;
				break;
			}
			
			case Define.TYPE_OF_DEBUTY: {
				this.position = Define.POSITION_OF_DEBUTY;
				this.allowance = Define.ALLOWANCE_OF_DEBUTY;
				break;
			}
			
			case Define.TYPE_OF_EMPLOYEE: {
				this.position = Define.POSITION_OF_EMPLOYEE;
				this.allowance = Define.ALLOWANCE_OF_EMPLOYEE;
				break;
			}
		}
		
		if (!isCreated)
			isCreated = true;

	}
	
	private Staff (StaffBuilder builder) {
		this.isCreated = false;
		this.type = builder.type;
		this.name = builder.name; 
		this.yearOfBirth = builder.yearOfBirth;
		this.id = builder.id;
		this.homeTown =  builder.homeTown;
		this.department = builder.department;
		this.workDays = builder.workDays;
		this.salaryRatio = builder.salaryRatio;
		this.allowance = builder.allowance; 
		this.position = builder.position;
		this.yearsOfWork = builder.yearsOfWork;
		this.basicSalary = builder.basicSalary; 
	}
	
	public static class StaffBuilder {
		private int id;
		private String name; 
		private int yearOfBirth;
		private int type;
		private String homeTown;
		private String department;
		private int workDays;
		private float salaryRatio;
		private int allowance; 
		private String position;
		private int yearsOfWork;
		private float basicSalary;
		
		public StaffBuilder(int type, int id ) {
			this.type = type;
			this.id = id;
		}
		public StaffBuilder setName( String name) {
			this.name = name;
			return this;
		}
		
		public StaffBuilder setYearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
			return this;
		}
		
		public StaffBuilder setHomeTown(String homeTown) {
			this.homeTown = homeTown;
			return this;
		}

		public StaffBuilder setDepartment(String department) {
			this.department = department;
			return this;
		}

		public StaffBuilder setWorkDays(int workdays) {
			this.workDays = workdays;
			return this;
		}

		public StaffBuilder setSalaryRatio(float salaryRatio) {
			this.salaryRatio = salaryRatio;
			return this;
		}

		public StaffBuilder setAllowance(String position) {
			switch(position) {
				case Define.POSITION_OF_CHIEF: {
					this.allowance = Define.ALLOWANCE_OF_CHIEF;
					break;
				}
				case Define.POSITION_OF_DEBUTY: {
					this.allowance = Define.ALLOWANCE_OF_DEBUTY;
					break;
				}
				case Define.POSITION_OF_EMPLOYEE: {
					this.allowance = Define.ALLOWANCE_OF_EMPLOYEE;
					break;
				}
			}

			return this;
		}

		public StaffBuilder setPosition(String position) {
			this.position = position;
			return this;
		}

		public StaffBuilder setYearsOfWork(int yearsOfWork) {
			this.yearsOfWork = yearsOfWork;
			return this;
		}
		
		public StaffBuilder setBasicSalary(float basicSalary) {
			this.basicSalary = basicSalary;
			return this;
		}
		
		public Staff build() {
			return new Staff(this);
		}
	}

	@Override
	public void update(float basicSalary) {
		this.basicSalary = basicSalary;
		
	}

	@Override
	public float getSalary() {
		float salary = salaryRatio * basicSalary + allowance + workDays * 30;
		
		return salary;
	}
}
