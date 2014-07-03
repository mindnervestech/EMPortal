package com.mnt.emr.module.permissionsroles.view;

public class PermissionVM {
	private Long id;
	private String roleName;
	private String permissions;
	
	public PermissionVM(Long id, String roleName, String permissions) {
		this.setId(id);
		this.setRoleName(roleName);
		this.setPermissions(permissions);
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
