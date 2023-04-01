package ui;

import java.util.Scanner;
import model.Controller;

public class Main{

	private Scanner reader;
	private Controller controller;

	public Main() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Main exe = new Main();
		
		int option = 0; 

        do{
            exe.menu();
            exe.doTheOption(option);

        }while(option != 0);

        exe.reader.close();

	}


	public void menu() {
		System.out.println("0. Exit"); 
        System.out.println("1. Create new project"); 
        System.out.println("2. Search project after a date");
		System.out.println("3. Search project before a date");
	}

	public int getOption() {

		System.out.print("Select an option: ");
		int option = reader.nextInt();
		reader.nextLine();

		return option;
	}

	public void doTheOption(int option){

		switch (option){

			case 1:
				registerProject();
				break;

			case 2:
				searchProjectsAfterDate();
				break;

			case 3:
				searchProjectsBeforeDate();
				break;

			case 0:
                System.out.println("Bye"); 
                break; 

            default:
                System.out.println("Invalid option");
                break;
		}
	}

	

	
	public void RegisterProject() {
		
		String name, clientName, initialDate, finalDate;
		double budget;

		System.out.print("Project name: ");
		name = reader.nextLine();

		System.out.print("Client name: ");
		clientName = reader.nextLine();

		System.out.print("Initial date (dd/M/yy): ");
		initialDate = reader.nextLine();

		System.out.print("Final date (dd/M/yy): ");
		finalDate = reader.nextLine();

		System.out.print("Budget: ");
		budget = Double.parseDouble(reader.nextLine());

		boolean registered = controller.RegisterProject(name, clientName, initialDate, projectType, finalDate, budget);

		if (registered) {
			System.out.println("The project was registered");
		} else {
			System.out.println("The project could not be registered");
		}
		
	}


	public void searchProjectsAfterDate() {
		String date;
		System.out.print("Enter date to search projects after (dd/M/yy): ");
		date = reader.nextLine();

		String result = controller.searchProjectsAfterDate(date);
		System.out.println(result);
	}
	

	public void searchProjectsBeforeDate() {
		String date;
		System.out.print("Enter date to search projects before (dd/M/yy): ");
		date = reader.nextLine();

		String result = controller.searchProjectsBeforeDate(date);
		System.out.println(result);
	}
}
