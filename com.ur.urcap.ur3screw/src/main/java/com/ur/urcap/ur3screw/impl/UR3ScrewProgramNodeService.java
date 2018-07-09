package com.ur.urcap.ur3screw.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.contribution.ProgramNodeService;
import com.ur.urcap.api.domain.URCapAPI;
import com.ur.urcap.api.domain.data.DataModel;
import java.io.InputStream;

public class UR3ScrewProgramNodeService implements ProgramNodeService {
	public UR3ScrewProgramNodeService() {
		
	}
	
	@Override
	public String getId() {
		return "UR3ScrewNode"+hashCode();
	}
	
	@Override
	public String getTitle() {
		return "UR3 Screw";
	}
	
	@Override
	public InputStream getHTML() {
		InputStream is = this.getClass().getResourceAsStream("/com/ur/urcap/ur3screw/impl/programnode.html");
		return is;
	}
	
	@Override
	public boolean isDeprecated() {
		return false;
	}
	
	@Override
	public boolean isChildrenAllowed() {
		return false;
	}
	
	@Override
	public ProgramNodeContribution createNode(URCapAPI api, DataModel model) {
		return new UR3ScrewProgramNodeContribution(api, model);
	}
}