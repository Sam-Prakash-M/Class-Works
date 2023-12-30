package com.samprakash.roleheirarchy.view.base;

import java.io.File;
import java.util.Scanner;

import com.samprakash.roleheirarchy.view.json.RoleHeirarchyJSONView;
import com.samprakash.roleheirarchy.viewModel.RoleHeirarchyViewModel;

public class RoleHeirarchyView {
	private RoleHeirarchyViewModel roleHeirarchyViewModel;
    private RoleHeirarchyJSONView roleHeirarchyJSONView;
    private Scanner scanner = new Scanner(System.in);
	public RoleHeirarchyView() {
		roleHeirarchyViewModel = new RoleHeirarchyViewModel(this);
	}

	public void showOptions() {
		File file = new File("src/com/samprakash/roleheirarchy/Role Heirarchy File/Role Description.json");

		byte choice;
		
		  do {
			    
			  if(file.length() <= 2) {
					initialRole();
				}
					System.out.println("+----------------------------------+");
					System.out.println("|       Menu List                  |");
					System.out.println("+----------------------------------+");
					System.out.println("| 1. Add SubRole                   |");
					System.out.println("| 2. Display Role                  |");
					System.out.println("| 3. Delete Role                   |");
					System.out.println("| 4. Add User                      |");
					System.out.println("| 5. Display Role                  |");
					System.out.println("| 6. Display User and Sub-User     |");
					System.out.println("| 7. Delete User                   |");
					System.out.println("| 8. Number of users from top      |");
					System.out.println("| 9. Height of role hierarchy      |");
					System.out.println("|10. Common boss of users          |");
					System.out.println("| 0. Exit...                       |");
					System.out.println("+----------------------------------+");
					System.out.print("--> Operation to be performed : ");
						
					
				
			  if(scanner.hasNextByte()) {
				  choice = scanner.nextByte();
			  }
			  else {
				  roleHeirarchyJSONView.showError("Enter a Valid Input");
				  scanner.nextLine();
				  continue;
			  }
			  switch(choice) {
			  case 1 : {
				  roleHeirarchyViewModel.addSubRole();
				  break;
			  }
			  case 2 : {
				  roleHeirarchyViewModel.disPlayRole();
				  break;
			  }
			  case 3 : {	
				  return;
			  }
			  default : {
				  roleHeirarchyJSONView.showError("Enter a Number Between 1 - 2");
			  }
			  }
			
			
			
		}
		while(true);
			
			
		
	}

	public void showSubRoleMenu() {
		scanner.nextLine();
		do {
			
			System.out.println("Enter a SubRole Name : ");
			String subRoleName = scanner.nextLine();
			System.out.println("Enter a Reporting Name : ");
			
			String reportingManager = scanner.nextLine();
			if(subRoleName.matches("[a-zA-Z]{3,15}") && reportingManager.matches("[a-zA-Z]{3,15}")) {
				roleHeirarchyViewModel.addedSubRole(subRoleName,reportingManager);
			}
			
		}
		while(true);
		
	}

	public void initialRole() {
		
		do {
		  System.out.println("Enter a RootName : ");
			String rootName = scanner.nextLine();
			 if(rootName.matches("[a-zA-Z]{3,15}")) {
				 System.out.println("matches");
				  roleHeirarchyViewModel.addedRootName(rootName);
				  break;
			 }
			 else {
				 continue;
			 }
		}
		while(true);
	}


}
