package com.mnt.emr;

import java.util.HashMap;
import java.util.Map;

import com.custom.domain.AllowedScheduledEvent;
import com.custom.domain.Ethnicity;
import com.custom.domain.PayerType;
import com.custom.domain.PlaceofService;
import com.custom.domain.Salutation;
import com.custom.domain.TaskPriority;
import com.custom.domain.TaskStatus;
import com.custom.domain.UserGender;
import com.custom.domain.UserType;

public class SelectDataSourceFactory {
	
	public static Map<Object, String> dummyMap() {
		Map<Object, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		return map;
	}
	
	public static Map<Object, String> dummyMap1() {
		Map<Object, String> map = new HashMap<>();
		map.put(1, "A1");
		map.put(2, "B1");
		map.put(3, "C1");
		map.put(4, "D1");
		return map;
	}

	public static Map<String, String> genderList() {
		Map<String, String> map = new HashMap<>();
		UserGender[] gender = UserGender.values();
		for(UserGender u : gender) {
			map.put(u.name(), u.displayValue);
		}
		return map;
	}

public static Map<String, String> getAllowedEvents() {
		Map<String, String> map = new HashMap<>();
		AllowedScheduledEvent[] events = AllowedScheduledEvent.values();
		for(AllowedScheduledEvent e: events) {
			map.put(e.name(), e.displayValue);
		}
		return map;
	}

	public static Map<String, String> userTypeList() {
		Map<String, String> map = new HashMap<>();
		UserType[] users = UserType.values();
		for(UserType u: users) {
			map.put(u.name(), u.displayValue);
		}
		return map;
	}
	
	public static Map<String, String> getEthnicities() {
		Map<String, String> map = new HashMap<>();
		Ethnicity[] ethnicities = Ethnicity.values();
		for(Ethnicity e: ethnicities) {
			map.put(e.name(), e.displayValue);
		}
		return map;
	}
	
	public static Map<String, String> doctorColors() {
		Map<String, String> map = new HashMap<>();
		map.put("Green", "Green");
		map.put("Red" , "Red");
		map.put("Blue" , "Blue");
		map.put("Orange" , "Orange");
		return map;
	}
		public static Map<String, String> payerTypes() {
		Map<String, String> map = new HashMap<>();
		PayerType[] types = PayerType.values();
		for(PayerType p: types) {
			map.put(p.name(), p.displayValue);
		}
		return map;
	}
	
	public static Map<String, String> countries() {
		Map<String, String> map = new HashMap<>();
		map.put("India", "India");
		map.put("United Kingdom", "United Kingdom");
		map.put("United States", "United States");
		return map;
	}
	
	public static Map<String, String> methods() {
		Map<String, String> map = new HashMap<>();
		map.put("Email", "Email");
		map.put("Print", "Print");
		map.put("Fax", "Fax");
		return map;
	}
		public static Map<String, String> placeOfServices() {
		Map<String, String> map = new HashMap<>();
		PlaceofService[] services = PlaceofService.values();
		for(PlaceofService s: services) {
			map.put(s.name(), s.displayValue);
		}
		return map;
	}
		public static Map<String, String> priorities() {
		Map<String, String> map = new HashMap<>();
		TaskPriority[] priority = TaskPriority.values();
		for(TaskPriority p: priority) {
			map.put(p.name(), p.displayValue);
		}
		return map;
	}
	
	public static Map<String, String> status() {
		Map<String, String> map = new HashMap<>();
		TaskStatus[] stat = TaskStatus.values();
		for(TaskStatus st: stat) {
			map.put(st.name(), st.displayValue);
		}
		return map;
	}
	
	public static Map<String, String> departments() {
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		return map;
	}
	
	public static Map<String, String> taskList() {
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		return map;
	}
	
	public static Map<String, String> getSalutaions() {
		Map<String, String> map = new HashMap<>();
		Salutation[] salutations = Salutation.values();
		for(Salutation s: salutations) {
			map.put(s.name(), s.displayValue);
		}
		return map;
	}
}
