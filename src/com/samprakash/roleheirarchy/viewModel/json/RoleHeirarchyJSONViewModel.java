package com.samprakash.roleheirarchy.viewModel.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.samprakash.roleheirarchy.repository.RoleHeirarchyRepository;
import com.samprakash.roleheirarchy.view.json.RoleHeirarchyJSONView;

public class RoleHeirarchyJSONViewModel {
   
	private RoleHeirarchyJSONView roleHeirarchyJSONView;
	public RoleHeirarchyJSONViewModel(RoleHeirarchyJSONView roleHeirarchyJSONView) {
		this.roleHeirarchyJSONView = roleHeirarchyJSONView;
	}
	public void initiateJSONObject() {
		
		JSONObject jsonObject = RoleHeirarchyRepository.getInstance().getJsonRetreiver();
		 JSONParser jsonParser = new JSONParser();
		String path;
		  
	        try {
				path = new File(".").getCanonicalPath() +"/src/"
						+ "com/samprakash/roleheirarchy/Role Heirarchy File/Role Description.json";
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
	        try {
				jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
								
				e.printStackTrace();
			}
	        
	        RoleHeirarchyRepository.getInstance().setJsonRetreiver(jsonObject);
	       System.out.println(jsonObject);
	       
	       
	}

}
