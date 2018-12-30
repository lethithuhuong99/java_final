package vnuk.huong170205.finalexam.model;

import java.util.Scanner;

public class CasualWorker extends Person {
	private int workDays;
	private int priceOfWorkDay;
	private boolean isCreated;

	public int getWorkDays() {
		return workDays;
	}
	
	public void setWorkDays(int workDays) {
		this.workDays = workDays;
	}
	
	public int getPriceOfWorkDay() {
		return priceOfWorkDay;
	}
	
	public void setPriceOfWorkDay(int priceOfWorkDay) {
		this.priceOfWorkDay = priceOfWorkDay;
	}
	
	
	@Override
	public String toString() {
		return "CasualWorker [workDays=" + workDays + ", priceOfWorkDay=" + priceOfWorkDay + ", id=" + id + ", name="
				+ name + ", yearOfBirth=" + yearOfBirth + ", type=" + type + "]";
	}
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Name: " + (isCreated ? this.name : ""));
		this.name = sc.nextLine(); 
		
		System.out.print("Year of birth: " + (isCreated ? this.yearOfBirth : ""));
		this.yearOfBirth = Integer.parseInt(sc.nextLine());
		
		System.out.print("Work days: " + (isCreated ? this.workDays : ""));
		this.workDays = Integer.parseInt(sc.nextLine());
		
		System.out.print("Price of work day: " + (isCreated ? this.priceOfWorkDay : ""));
		this.priceOfWorkDay = Integer.parseInt(sc.nextLine());
		
		if (!isCreated)
			isCreated = true;
	}
	
	private CasualWorker (CasualWorkerBuilder builder) {
		this.isCreated = false;
		this.id = builder.id;
		this.name = builder.name; 
		this.yearOfBirth = builder.yearOfBirth;
		this.type = builder.type;	
		this.workDays = builder.workDays;
		this.priceOfWorkDay = builder.priceOfWorkDay;
	}
	
	public static class CasualWorkerBuilder {
		private int id;
		private String name; 
		private int yearOfBirth;
		private int type;
		private int workDays;
		private int priceOfWorkDay;
		
		public CasualWorkerBuilder(int type, int id) {
			this.type = type;
			this.id = id;
		}
		
		public CasualWorkerBuilder setName( String name) {
			this.name = name;
			return this;
		}
		
		public CasualWorkerBuilder setYearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
			return this;
		}
		
		public CasualWorkerBuilder setWorkDays(int workDays) {
			this.workDays = workDays;
			return this;
		}
		
		public CasualWorkerBuilder setPriceOfWorkDay(int priceOfWorkDay) {
			this.priceOfWorkDay = priceOfWorkDay;
			return this;
		}
		
		public CasualWorker build() {
			return new CasualWorker(this);
		}	
	}

	@Override
	public float getSalary() {
		float salary = workDays * priceOfWorkDay; 
				
		return salary;
	}
}
