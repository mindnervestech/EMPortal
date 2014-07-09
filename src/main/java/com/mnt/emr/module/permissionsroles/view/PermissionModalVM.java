package com.mnt.emr.module.permissionsroles.view;

import java.util.List;

import com.mnt.emr.module.common.model.Permission;
import com.mnt.emr.module.common.model.Privileges;

public class PermissionModalVM {
	public Long id;
	public String permissionName;
	public boolean allowed = false;
	
	public PermissionModalVM() {}
	
	public PermissionModalVM(Permission _p, List<Privileges> rights) {
		this.id=_p.getId();
		this.permissionName = _p.getDisplayName();
	
		for(Privileges r: rights) {
			if(_p.getId() == r.getPermision().getId()) {
				this.allowed = !r.getDenied();
				break;
			}
		}
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public boolean isAllowed() {
		return allowed;
	}
	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}
}
