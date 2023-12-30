package com.samprakash.roleheirarchy.view.json;

import java.util.Scanner;

import com.samprakash.roleheirarchy.view.base.RoleHeirarchyView;
import com.samprakash.roleheirarchy.viewModel.json.RoleHeirarchyJSONViewModel;

public class RoleHeirarchyJSONView {
       private Scanner scanner = new Scanner(System.in);
	private RoleHeirarchyJSONViewModel roleHeirarchyJSONViewModel;
	public RoleHeirarchyJSONView () {
		roleHeirarchyJSONViewModel = new RoleHeirarchyJSONViewModel(this);
	}
	public void init() {
		RoleHeirarchyView roleHeirarchyView = new RoleHeirarchyView();
		roleHeirarchyJSONViewModel.initiateJSONObject();
			roleHeirarchyView.showOptions();
		
		
	}
	private String getStringInputFromUser() {
		  
		return scanner.next();
	}
	public byte getByteInputFromUser() {
		  
		while(true) {
			System.out.println("Enter a number : ");
			   if(scanner.hasNextByte()) {
				   byte choice = scanner.nextByte();
				   return choice;
			   }
			   showError("Enter a Valid Input : ");
			   scanner.next();  
		}
		
	}
	public void showError(String err) {
		
		System.err.println(err);
		
	}

}
