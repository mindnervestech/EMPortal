package com.mnt.emr.module.permissionsroles.view;

import java.util.List;

public class PermissionListVM {
	public List<PermissionModalVM> permissions;
	public PermissionListVM() {}
	public List<PermissionModalVM> getPermissionModalVMs() {
		return permissions;
	}

	public void setPermissionModalVMs(List<PermissionModalVM> permissions) {
		this.permissions = permissions;
	}
}
