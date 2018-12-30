package vnuk.huong170205.finalexam.define;

import java.util.ArrayList;

import vnuk.huong170205.finalexam.model.Person;

public class Define {
	public static final int TYPE_OF_LECTURER = 1;
	public static final int TYPE_OF_STAFF = 2;
	public static final int TYPE_OF_CASUALWORKER = 3;
	
	public static int latestId = 0;
	
	public static final int TYPE_OF_BACHELOR = 1;
	public static final int TYPE_OF_MASTER = 2;
	public static final int TYPE_OF_DOCTOR = 3;
	public static final int TYPE_OF_CHIEF = 1;
	public static final int TYPE_OF_DEBUTY = 2;
	public static final int TYPE_OF_EMPLOYEE = 3;
	
	public static final int ALLOWANCE_OF_BACHELOR = 300;
	public static final int ALLOWANCE_OF_MASTER = 900;
	public static final int ALLOWANCE_OF_DOCTOR = 2000;
	public static final int ALLOWANCE_OF_CHIEF = 1000;
	public static final int ALLOWANCE_OF_DEBUTY = 600;
	public static final int ALLOWANCE_OF_EMPLOYEE = 400;
	
	public static final String POSITION_OF_CHIEF = "Chief";
	public static final String POSITION_OF_DEBUTY = "Debuty";
	public static final String POSITION_OF_EMPLOYEE = "Employee";
	public static final String QUALIFICATION_OF_BACHELOR = "Bachelor";
	public static final String QUALIFUCATION_OF_MASTER = "Master";
	public static final String QUALIFICATION_OF_DOCTOR = "Doctor";
	public static final String TYPE_OF_LECTURER_VALUE = "Lecturer";
	public static final String TYPE_OF_STAFF_VALUE = "Staff";
	public static final String TYPE_OF_CASUALWORKER_VALUE = "Casual Worker";
	
	
	public static final float DEFAULT_BASIC_SALARY = 730;
	public static float newBasicSalary = DEFAULT_BASIC_SALARY ;
	
	public static ArrayList <Person> persons = new ArrayList <>();
}