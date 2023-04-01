package model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import model.Project;

public class Controller{

	private Project[] projects;

	public Controller(){

		projects = new Project[10];
	
	}
	
	
	public boolean RegisterProject(String projectName, String clientName, String projectType, Calendar initialDate,
			Calendar finalDate, double budget){
		int firstValidPosition = getFirstValidPosition();
		if (firstValidPosition == -1) {
			System.out.println("Error: No available space to register the project.");
			return false;
		} 

		Project newProject = new Project(projectName, clientName, projectType, initialDate, finalDate, budget);
		projects[firstValidPosition] = newProject;
		System.out.println("The project was registered successfully.");
		return true;
		
	}


	public int getFirstValidPosition(){
        for (int i = 0; i < projects.lenght; i++) {
			if (projects[i] == null) {
				return i;
			}
		}
		return -1;
    	}



	public String searchProjectsAfterDate(Calendar searchDate) {

		String msg = "";
		String msg = "Projects starting after " + searchDate.getTime();
		for (int i = 0; i < projects.lenght; i++) {
			if (projects[i] != null && projects[i].getInitialDate().after(searchDate)) {
				msg += projects[i].getProjectInfo() + "\n";
			}
		}

		return msg;
	}
	

	public String searchProjectsBeforeDate(Calendar searchDate) {
		
		String msg = "";
		String msg = "Projects ending before " + searchDate.getTime();
		for (int i = 0; i < projects.lenght; i++) {
			if (projects[i] != null && projects[i].getFinalDate().before(searchDate)) {
				msg += projects[i].getProjectInfo() + "\n";
			}
		}

		return msg;

	}
}
