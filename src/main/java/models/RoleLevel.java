package models;

import java.sql.Timestamp;
import java.util.List;

public class RoleLevel{

	public static final long serialVersionUID = 6992202576999577853L;

	public Long id;
	
	public String permissions;
	
	public String getPermissions(){
		return permissions;
	}
	
	public void setPermissions(String permissions){
		this.permissions = permissions;
	}
	
	
}
