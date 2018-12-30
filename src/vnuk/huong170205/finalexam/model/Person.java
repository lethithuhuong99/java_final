package vnuk.huong170205.finalexam.model;

import java.util.Comparator;

public abstract class Person {
	protected int id;
	protected String name; 
	protected int yearOfBirth;
	protected int type;
	
	public Person() {}
	public Person(int id) {
		this.id = id;
	}
	public Person (int type,int id) {
		this.type = type;
		this.id = id;		
	}
	
	public abstract void input();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public abstract String toString();
	
	public abstract float getSalary();
	
}
