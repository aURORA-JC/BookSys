/** 
* @File Utils.java
* @Author Aurora_JC
* @Time 2020年12月14日 上午10:25:42 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	public static boolean isBookNum(String s) {
		String pattern = "ISBN\\s\\d\\d\\d-\\d-\\d\\d\\d-\\d\\d\\d\\d\\d-\\d";
		
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(s);
		
		return m.matches();
	}
	
	public static String recodePassword(String s) {
		byte[] digest = null;
		
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			digest = md5.digest(s.getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new BigInteger(1, digest).toString(16);
	}
}
