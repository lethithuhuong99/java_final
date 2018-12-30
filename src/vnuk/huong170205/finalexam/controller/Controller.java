package vnuk.huong170205.finalexam.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vnuk.huong170205.finalexam.define.Define;
import vnuk.huong170205.finalexam.model.CasualWorker;
import vnuk.huong170205.finalexam.model.Lecturer;
import vnuk.huong170205.finalexam.model.Person;
import vnuk.huong170205.finalexam.model.Staff;
import vnuk.huong170205.finalexam.view.Menu;

public class Controller {
	
	public static void mainMenu() {
		while (true) {
			
			Menu.mainMenu();
			
			int value = inputChoice(1, 9);
			
			switch (value) {
				case 1: {
					Controller.menu1();
					break;
				}
				
				case 2: {
					Controller.menu2();
					break;
				}
				
				case 3: {
					Controller.menu3();
					break;
				}
				
				case 4: {
					Controller.menu4();
					break;
				}
				
				case 5: {
					Controller.menu5();
					break;
				}
				
				case 6: {
					Controller.menu6();
					break;
				}
				
				case 7: {
					Controller.menu7();
					break;
				}
				
				case 8: {
					Controller.menu8();
					break;
				}
				
				case 9: {
					Controller.menu9();
					break;
				}
			}
		}
	}
	
	
	public static void menu1() {
		
		while (true) {
			
			Menu.menu1();
			
			int value = inputChoice(1,6);
			
			switch (value) {
				case 1: {
					switch(chooseTypeOfEmployee()) {
						case Define.TYPE_OF_LECTURER : {
							Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
							lecturer.input();
							Define.persons.add(lecturer);
							break;
						}
						
						case Define.TYPE_OF_STAFF: {
							Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
							staff.input();
							Define.persons.add(staff);
							break;
						}
						
						default : {
							CasualWorker casualWorker = (CasualWorker)PersonFactory.getPerson(Define.TYPE_OF_CASUALWORKER);
							casualWorker.input();
							Define.persons.add(casualWorker);
							break;
						}
					}
					break;
				}
				
				case 2: {
					switch(chooseTypeOfEmployee()) {
						case Define.TYPE_OF_LECTURER : {
							Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
							lecturer.input();
							Define.persons.add(0,lecturer);
							break;
						}
						
						case Define.TYPE_OF_STAFF: {
							Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
							staff.input();
							Define.persons.add(0,staff);
							break;
						}
						
						default : {
							CasualWorker casualWorker = (CasualWorker)PersonFactory.getPerson(Define.TYPE_OF_CASUALWORKER);
							casualWorker.input();
							Define.persons.add(0,casualWorker);
							break;
						}
					}
					break;
				}
				
				case 3: {
					int k = inputChoice(0,(Define.persons.size() - 1) );
					switch(chooseTypeOfEmployee()) {
						case Define.TYPE_OF_LECTURER : {
							Lecturer lecturer = (Lecturer)PersonFactory.getPerson(Define.TYPE_OF_LECTURER);
							lecturer.input();
							Define.persons.add(k+1, lecturer);
							break;
						}
						
						case Define.TYPE_OF_STAFF: {
							Staff staff = (Staff)PersonFactory.getPerson(Define.TYPE_OF_STAFF);
							staff.input();
							Define.persons.add(k+1, staff);
							break;
						}
						
						default : {
							CasualWorker casualWorker = (CasualWorker)PersonFactory.getPerson(Define.TYPE_OF_CASUALWORKER);
							casualWorker.input();
							Define.persons.add(k+1, casualWorker);
							break;
						}
					}
					break;
				}
				
				case 4: {
					Scanner sc = null;
					try {
						sc = new Scanner(new File("staff.txt"));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					int numberOfStaffs = Integer.parseInt(sc.nextLine());
					int type;
					String name;
					int yearOfBirth;
					String homeTown;
					String department; 
					String qualification; 
					String position;
					int allowance = 1; 
					int periodsInMonth;
					int workDays;
					float salaryRatio; 
					int yearsOfWork;
					float basicSalary;
					
					for (int index = 0; index < numberOfStaffs; index++) {
						Define.latestId++;
						type = Integer.parseInt(sc.nextLine());
						name = sc.nextLine();
						yearOfBirth = Integer.parseInt(sc.nextLine());
						homeTown = sc.nextLine();
						department = sc.nextLine();
						salaryRatio = Float.parseFloat(sc.nextLine());
						yearsOfWork = Integer.parseInt(sc.nextLine());
						basicSalary = Float.parseFloat(sc.nextLine());
						
						switch (type) {
						case Define.TYPE_OF_LECTURER: {
							qualification = sc.nextLine();
							periodsInMonth = Integer.parseInt(sc.nextLine());
				
							Lecturer newLecturer = new Lecturer.LecturerBuilder( Define.TYPE_OF_LECTURER,Define.latestId)
									.setYearOfBirth(yearOfBirth)
									.setName(name)
									.setHomeTown(homeTown)
									.setDepartment(department)
									.setYearsOfWork(yearsOfWork)
									.setSalaryRatio(salaryRatio)
									.setQualification(qualification)
									.setPeriodsInMonth(periodsInMonth)
									.setBasicSalary(basicSalary)
									.setAllowance(qualification)
									.build();
							
							Define.persons.add(newLecturer);
							break;
						}
						case Define.TYPE_OF_STAFF: {
							position = sc.nextLine();
							workDays = Integer.parseInt(sc.nextLine());
														
							Staff newStaff = new Staff.StaffBuilder(Define.TYPE_OF_STAFF,Define.latestId)
									.setYearOfBirth(yearOfBirth)
									.setName(name)
									.setHomeTown(homeTown)
									.setDepartment(department)
									.setYearsOfWork(yearsOfWork)
									.setSalaryRatio(salaryRatio)
									.setPosition(position)
									.setWorkDays(workDays)
									.setBasicSalary(basicSalary)
									.setAllowance(position)
									.build();
							
							Define.persons.add(newStaff);
							break;
						}
						}
						
					}
					
					break;
				}
				
				case 5: {
					Scanner sc = null;
					try {
						sc = new Scanner(new File("labor.txt"));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					int numberOfLabors = Integer.parseInt(sc.nextLine());
					String name;
					int yearOfBirth;
					int workDays;
					int priceOfWorkDay;
					
					for (int index = 0; index < numberOfLabors; index++) {
						Define.latestId++;
	
						name = sc.nextLine();
						yearOfBirth = Integer.parseInt(sc.nextLine());
						workDays = Integer.parseInt(sc.nextLine());
						priceOfWorkDay = Integer.parseInt(sc.nextLine());
						
						CasualWorker newCasualWorker = new CasualWorker.CasualWorkerBuilder(Define.TYPE_OF_CASUALWORKER,Define.latestId)
								.setName(name)
								.setWorkDays(workDays)
								.setYearOfBirth(yearOfBirth)
								.setPriceOfWorkDay(priceOfWorkDay)
								.build();
						
						Define.persons.add(newCasualWorker);
					}
					
					break;
				}
				
				case 6: {
					return;
				}
			}
		}
	}
	  
	public static void menu2() {
		
		System.out.println("Enter employee number: (0 - " + (Define.persons.size() - 1) +")");
		Scanner sc =new Scanner(System.in);
		int value = sc.nextInt(); 
		
		if ((value >= 0) && (value < Define.persons.size())) {
			Define.persons.get(value).input();
		}
		else {
			System.out.println("Can not found!");
		}	
		
		return;
	}
	
	public static void menu3() {
		System.out.println("Enter employee number: (0 - " + (Define.persons.size() - 1) +")");
		Scanner sc =new Scanner(System.in);
		int value = sc.nextInt(); 
		
		if ((value >= 0) && (value < Define.persons.size())) {
			Define.persons.remove(value);
		}
		else {
			System.out.println("Can not found!");
		}
		
	}
	
	public static void menu4() {
		
		while (true) {
			
			Menu.menu4();
					
			int value = inputChoice(1,6);
			
			switch (value) {
				case 1: {
					showListPerson(Define.persons);
					break;
				}
				
				case 2: {
					ArrayList <Person> persons = new ArrayList <>();
					persons = (ArrayList<Person>) Define.persons.clone();
										
					for (int i = 0; i < Define.persons.size(); i++) {
						for (int j = i+1; j < Define.persons.size(); j++) {
							if ( persons.get(i).getSalary() > persons.get(j).getSalary())
							{
								Person person = persons.get(j);
								persons.set(j, persons.get(i));
								persons.set(i, person);
							}
						}						
					}
					showListPerson(persons);
					break;
				}
				
				case 3: {
					ArrayList <Person> persons = new ArrayList <>();
					persons = (ArrayList<Person>) Define.persons.clone();
			        Collections.sort(persons, new Comparator<Person>() {
			        	@Override
			            public int compare(Person person1, Person person2) {
			                return (int) (person1.getName().compareTo(person2.getName()));
			            }
			        });
			        showListPerson(persons);
					break;
				}
				
				case 4: {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter Name:");
					String name = sc.nextLine();
					
					ArrayList <Person> persons = new ArrayList <>();
					Person person;
					boolean isFound = false;
					
					for (int index = 0; index < Define.persons.size(); index++) {
						person = Define.persons.get(index);

							if (person.getName().toLowerCase().contains(name.toLowerCase())) {
								persons.add(person);
								isFound = true;
							}
					}
					
					if (isFound == false) {
						System.out.println("Can not found!");
					} else {
						showListPerson(persons);
					}
					break;
					
				}
				
				case 5: {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter Year of birth:");
					int yearOfBirth = sc.nextInt();
					
					ArrayList <Person> persons = new ArrayList <>();
					Person person;
					boolean isFound = false;
					
					for (int index = 0; index < Define.persons.size(); index++) {
						person = Define.persons.get(index);

							if (person.getYearOfBirth() == yearOfBirth) {
								persons.add(person);
								isFound = true;
							}
					}
					
					if (isFound == false) {
						System.out.println("Can not found!");
					} 
					else {
						showListPerson(persons);
					}
					break;
				}
				
				case 6: {
					return;
				}
			}
		}
	}
	
	public static void menu5() {
		Define.persons.clear();
		
		if (Define.persons.isEmpty()) System.out.println("Deleted all data");
	}
	
	public static void menu6() {
		System.out.println("Display name and salary of employee");
		System.out.format("%-4s %-20s %-15s %n", "No.", "Name", "Salary");
		
		Person person;
		
		for (int index =0; index < Define.persons.size(); index ++) {
			person = Define.persons.get(index);
			System.out.format("%-4s %-20s %-15s %n",
					index,
					person.getName(),
					person.getSalary());
		}
	}
	
	public static void menu7() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Add new basic salary: ");
		Define.newBasicSalary = Float.parseFloat(sc.nextLine());
		
	}
	
	public static void menu8() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter list emloyee id");
		String text = sc.nextLine();
		String indexs[] = text.split(" ");
		
		Subject subject = new Subject();
		int indexTemp;
		for (int index = 0; index < indexs.length; index++) {
			indexTemp = Integer.parseInt(indexs[index]);
			
			if ((indexTemp >= 0) && (indexTemp < Define.persons.size()))
				if ((Define.persons.get(indexTemp).getType() == Define.TYPE_OF_LECTURER) || (Define.persons.get(indexTemp).getType() == Define.TYPE_OF_STAFF ))
					subject.attach((Observer)Define.persons.get(indexTemp));
				else
					System.out.println("Can not edit new basic salary for id: " + indexTemp);
			else 
				System.out.println("Can not found id: " + indexTemp);
		}
		subject.notifyChange(Define.newBasicSalary);
	}
	
	public static void menu9() {
		System.out.println("Goodbye!!");
		System.exit(0);
	}
	
	public static int inputChoice(int min, int max) {
		Scanner sc = new Scanner(System.in);
		int value = min -1;
		boolean check = false;
		
		System.out.println("Input choice (" + min + " - " + max + ")");
		
		while (check == false) {
			System.out.print("Input: ");
			value = sc.nextInt();
			
			if (value < min || value > max)
				System.out.println("Wrong input");
			else 
				check = true;
		}
		return value;
	}
	
	public static int chooseTypeOfEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose Type Of Employee \n"
							+ "1. Lecturer. \n"
							+ "2. Staff. \n"
							+ "3. Casual Worker \n");
		
		int value = inputChoice(1,3);
		
		switch (value) {
			case 1: return Define.TYPE_OF_LECTURER;
			
			case 2 : return Define.TYPE_OF_STAFF;
			
			default: return Define.TYPE_OF_CASUALWORKER;
		}
	}
	
	public static void showListPerson(ArrayList<Person> persons) {
		
		System.out.println("List employee: \n");
		System.out.format("%-4s %-20s %-15s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %n", "No.", "Name", "Year of birth", "Hometown", "Type", "C1", "C2", "C3", "C4", "C5");
		
		for (int index = 0; index < persons.size(); index++) {
			System.out.format("%-4d %-20s %-15d "
					, index
					, persons.get(index).getName()
					, persons.get(index).getYearOfBirth());
			
			switch (persons.get(index).getType()) {
				case Define.TYPE_OF_LECTURER: {
					System.out.format("%-15s %-15s %-10s %-10s %-10d %-10d %-10f %n"
							, ((Lecturer)persons.get(index)).getHomeTown()
							, "Lecturer"
							, ((Lecturer)persons.get(index)).getDepartment()
							, ((Lecturer)persons.get(index)).getQualification()
							, ((Lecturer)persons.get(index)).getAllowance()
							, ((Lecturer)persons.get(index)).getPeriodsInMonth()
							, ((Lecturer)persons.get(index)).getSalaryRatio());
					
					break;
				}
				
				case Define.TYPE_OF_STAFF: {
					System.out.format("%-15s %-15s %-10s %-10s %-10d %-10d %-10f %n"
							, ((Staff)persons.get(index)).getHomeTown()
							, "Staff"
							, ((Staff)persons.get(index)).getDepartment()
							, ((Staff)persons.get(index)).getPosition()
							, ((Staff)persons.get(index)).getAllowance()
							, ((Staff)persons.get(index)).getWorkDays()
							, ((Staff)persons.get(index)).getSalaryRatio());
					
					break;
				}
				
				default: {
					System.out.format("%-15s %-15s %-10s %-10s %-10s %-10d %-10d %n"
							, "NULL"
							, "Casual Worker"
							, "NULL"
							, "NULL"
							, "NULL"
							, ((CasualWorker)persons.get(index)).getWorkDays()
							, ((CasualWorker)persons.get(index)).getPriceOfWorkDay());
					
					break;
				}
			}
		}
		System.out.println("\n\n NOTE: C1 - C2 - C3 - C4 - C5 \n"
				+ "LECTURER: Department - Qualification - Allowance - Periods in month - Salary ratio \n"
				+ "STAFF: Department - Position - Allowance - Work days - Salary ratio \n"
				+ "CASUAL WORKER: Null - Null - Null - Work days - Price of work day");
	}
}
