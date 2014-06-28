package com.custom.domain;

import routes.routes;;

public enum Permissions {
	Home(routes.Application.index.url,null,"Home"),
	
	Schedule("#",null,"Schedule"),
	Calendar(routes.Users.index.url,Schedule,"Calendar"),
	Appointment_Profiles(routes.Clients.index.url,Schedule,"Appointment Profiles"),
	Recurring_Events(routes.Projects.index.url,Schedule,"Recurring Events"),
	
	
	Patients("#",null,"Patients"),
	Patient_list(routes.Leaves.applyIndex.url,Patients,"Patient"),
	Send_EMail(routes.Leaves.applyIndex.url,Patients,"Send EMail"),
	
	Staff("/userLayout",null,"Staff"),
	Doctor("/doctorLayout",null,"Doctor"),
	Masterdata("/masterDataLayout",null,"Master Data"),
	Facitiy("/facilityLayout",null,"Facility");
	
	private String url;
	private int level;
	private Permissions parent;
	private String uiDisplay;
	
	private Permissions(String _url,Permissions parent,String uiDisplay){
		this.url=_url;
		this.parent = parent;
		this.uiDisplay = uiDisplay;
	}
	
	public String url(){
		return url;
	}
	
	public int level(){
		return level;
	}
	
	public Permissions parent(){
		return parent;
	}
	
	public String display(){
		return uiDisplay;
	}
}