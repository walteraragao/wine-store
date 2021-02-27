package com.wine.utils;

public class WineUtils {

	
	public static boolean checkIfIsBlankOrNull(String string) {
		if(string == null || string.isEmpty())
			return true;
		
		return false;
	}
	
	public static Integer getOnlyNumber(String s) {
		return Integer.parseInt(s.replaceAll("[^0-9]", ""));
	}
}
