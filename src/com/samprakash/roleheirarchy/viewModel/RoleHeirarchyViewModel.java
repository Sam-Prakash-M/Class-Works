package com.samprakash.roleheirarchy.viewModel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.samprakash.roleheirarchy.dto.Role;
import com.samprakash.roleheirarchy.repository.RoleHeirarchyRepository;
import com.samprakash.roleheirarchy.view.base.RoleHeirarchyView;

public class RoleHeirarchyViewModel {
	
   private RoleHeirarchyView roleHeirarchyView;
 
	public RoleHeirarchyViewModel(RoleHeirarchyView roleHeirarchyView) {
		this.roleHeirarchyView = roleHeirarchyView;
	}
    
	public void fileWriting(JSONObject mainJsonObject) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("src/com/samprakash/roleheirarchy/Role Heirarchy File/Role Description.json"); 
			fileWriter.write(mainJsonObject.toJSONString());
			fileWriter.flush();
			fileWriter.close();
			 System.out.println("Sam is : "+mainJsonObject);
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		
	}
	public void addedRootName(String rootName) {
		
		 JSONObject mainJsonObject = RoleHeirarchyRepository.getInstance().getJsonRetreiver();
		
		JSONArray jsonArray = new JSONArray();
		JSONObject rootObject = new JSONObject();
		rootObject.put("Name",null);
		rootObject.put("Reporting to ",null);
		jsonArray.add(rootObject);
	      mainJsonObject.put(rootName,jsonArray);
	      fileWriting(mainJsonObject);
	     Role.roleHeirarchy.offer(rootName);
	     Role.line.add(rootName);
	}

	public void addSubRole() {
		roleHeirarchyView.showSubRoleMenu();
		
	}

	public void addedSubRole(String subRoleName, String reportingManager) {
		
       JSONObject mainJsonObject = RoleHeirarchyRepository.getInstance().getJsonRetreiver();
		
		JSONArray jsonArray = new JSONArray();
		JSONObject rootObject = new JSONObject();
		rootObject.put("Name",null);
		rootObject.put("Reporting to ",reportingManager);
		jsonArray.add(rootObject);
	      mainJsonObject.put(subRoleName,jsonArray);
	      fileWriting(mainJsonObject);
		
	}

	public void disPlayRole() {
		
		 JSONObject mainJsonObject = RoleHeirarchyRepository.getInstance().getJsonRetreiver();
		 Map traverse = new HashMap(mainJsonObject);
		 Set <Map.Entry> set = traverse.entrySet();
			  
		 while( !Role.roleHeirarchy.isEmpty()) {
			 String member =  Role.roleHeirarchy.pollFirst();
			 for(Map.Entry entry : set ) {
			         JSONArray role = (JSONArray) entry.getKey();
			         for(int i = 0 ; i < role.size() ; i++) {
			        	 System.out.println("Curr is : "+((JSONObject) role.get(i)).get("Reporting to "));
			        	 if(((JSONObject) role.get(i)).get("Reporting to ").equals(member)) {
			        		 Role.line.add(member);
			        		 Role.roleHeirarchy.offerLast(member);
			        	 }
			         }
			         
			  }
		 }
		 System.out.println("hi");
		 System.out.println(Role.line);
			 
			 
		
		 
	}

}
