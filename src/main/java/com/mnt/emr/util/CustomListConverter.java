package com.mnt.emr.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

public class CustomListConverter implements CustomConverter {

	@Override
	public Object convert(Object destination, Object source,
			Class<?> destClass, Class<?> sourceClass) {
		if (source == null) {
			return null;
		}
		List<String> dest = null;
		if (source instanceof String) {
			if (destination == null) {
				dest = new ArrayList<>();
				String[] array = ((String) source).split(",");
				for(String a: array) {
					dest.add(a.trim());
				}
			} else {
				dest = (List<String>) destination;
				String[] array = ((String) source).split(",");
				for(String a: array) {
					if(!dest.contains(a)){
						dest.add(a.trim());
					}
				}
			}
			return dest;
		} else if (source instanceof List<?>) {
			List<String> sourceObj = ((List<String>) source);
			String returnString = "";
			for(String s: sourceObj) {
				returnString += s.trim()+",";
			}
			returnString = returnString.substring(0, (returnString.length() - 2));
			return returnString;
		} else {
			throw new MappingException("Converter TestCustomConverter "
					+ "used incorrectly. Arguments passed in were:"
					+ destination + " and " + source);
		}
	}

}
