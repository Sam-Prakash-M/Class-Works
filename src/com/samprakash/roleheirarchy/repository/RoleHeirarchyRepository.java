package com.samprakash.roleheirarchy.repository;

import org.json.simple.JSONObject;

public class RoleHeirarchyRepository {
         
	public static final RoleHeirarchyRepository SINGLE_OBJECT = new RoleHeirarchyRepository();
	  
	private JSONObject jsonRetreiver;
	
	public JSONObject getJsonRetreiver() {
		return jsonRetreiver;
	}
	public void setJsonRetreiver(JSONObject jsonRetreiver) {
		this.jsonRetreiver = jsonRetreiver;
	}
	private RoleHeirarchyRepository () {
		
	}
	public static RoleHeirarchyRepository getInstance() {
		return SINGLE_OBJECT;
	}
}
