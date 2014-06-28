package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dummy {

	public void function() {
		// <media , <subscriber,<Attr,Value>>>
		Map<String,Map<String,Map<String,String>>> globalMap = new HashMap<>();
		 
		// For each media Do 
		{
			Map<String,Map<String,String>> perMediaMap = new HashMap<>();
			// for each subscription do 
			{
				perMediaMap.put("<subscription>", new HashMap<String,String>());
				
			}
			globalMap.put("Avanstar", perMediaMap);
		}
		
		for(String media : globalMap.keySet()) {
			Map<String,Map<String,String>> perMediaMap = globalMap.get(media);
			// Go to media Tab
			for(String sub : perMediaMap.keySet()) {
				
			}
			
		}
	}
}
