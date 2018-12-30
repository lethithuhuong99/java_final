package vnuk.huong170205.finalexam.view;

public class Menu {
	
	public static void mainMenu() {
	
			System.out.println("Menu: \n"
								+ "1: Add new employee \n"
								+ "2: Edit employee's imformation \n"
								+ "3: Delete employee \n"
								+ "4: Display employee \n"
								+ "5: Delete all data \n"
								+ "6: Display salary all of employee in system \n"
								+ "7: Update basic salary \n"
								+ "8: Input list employee id need to subscribe basic salary \n"
								+ "9: Exit \n");
	}
	
	public static void menu1() {
		
			System.out.println( "1.1 Add new staff in the bottom \n"
								+ "1.2 Add new staff on the top \n"
								+ "1.3 Add new staff after specific position \n"
								+ "1.4 Add new staff in the bottom from staff.txt \n"
								+ "1.5 Add new casual worker from labor.txt \n"
								+ "1.6 Return \n");		
	}
	
	public static void menu4() {

			System.out.println("4.1 Display current list \n"
							+ "4.2 Display list order by Ascending of salary \n"
							+ "4.3 Display list with name order by Alphabet \n"
							+ "4.4 Find employee by name \n"
							+ "4.5 Find employee by year of birth \n"
							+ "4.6 Return \n");
	}

}

