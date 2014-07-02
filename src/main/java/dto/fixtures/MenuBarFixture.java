package dto.fixtures;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;

import routes.routes;

import com.mnt.emr.module.common.model.AuthUser;
import com.mnt.emr.module.common.model.Menu;
import com.mnt.emr.module.common.model.Permission;
import com.mnt.emr.module.common.model.Privileges;

import dto.MenuBar;
import dto.MenuBar.MenuItem;

public class MenuBarFixture {
	private static Map<String,MenuItem> map=null ;
	static {
		List<Menu> menus = Menu.findAll();
		map = new LinkedHashMap<String,MenuItem>();
		Permission p;
		for (Menu _m : menus) {
			if(_m.getPid() == null){
				p = _m.getPermission();
				if(!map.containsKey(p.getName())){
					map.put(p.getName(), new MenuItem(p.getName(), p.getDisplayName(),p.getUrl()));
				}
			}else{
				p = Menu.find.byId(_m.getPid()).getPermission();
				if(map.containsKey(p.getName())){
					map.get(p.getName()).addSubMenu(p.getName(),p.getDisplayName(),p.getUrl());
				}
			}
		}
		
		map.put("Logout",new MenuItem("Logout","Logout", null, routes.Application.logout.url, null,null));
	}
	
	public static MenuBar build(){
		List<MenuItem> resultMenu = new ArrayList<MenuItem>();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Privileges> privilegeMap = null;
		if(principal instanceof String) {
			AuthUser user = AuthUser.findByUsername(principal);
			user.getAuthorities();
			privilegeMap = user.getPrivilegeMap();
			
		} else {
			privilegeMap = ((AuthUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getPrivilegeMap();
		}
		 //Collection<Privileges> privileges = ((AuthUser)principal).getPrivilegeMap().values();
		for(MenuItem mi : map.values()){
			if(!mi.isSubMenu()){
				List<MenuItem> resultSubMenus = new ArrayList<MenuItem>();
				for(MenuItem sm : mi.subMenu){
					Privileges privileges = privilegeMap.get(sm.menu);
					if(privileges!=null && !privileges.getDenied()){
						resultSubMenus.add(sm);
					}
				}
				
				if(resultSubMenus.size() != 0){
					MenuItem item = new MenuItem(mi.menu, mi.name, null, mi.url, resultSubMenus, null);
					resultMenu.add(item);
				}
			}
			else{
				Privileges privileges = privilegeMap.get(mi.menu);
				if(privileges!=null && !privileges.getDenied()){
					resultMenu.add(mi);
				}
				
			}
		}
		return new MenuBar(resultMenu);
	}
	

}
