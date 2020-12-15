/** 
* @File Utils.java
* @Author Aurora_JC
* @Time 2020��12��14�� ����10:25:42 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.booksys.storage.LinkedList;
import com.booksys.storage.Node;

public class Utils {
	public static boolean isBookNo(String s) {
		String patternc1 = "ISBN\\s\\d\\d\\d-\\d-\\d\\d\\d-\\d\\d\\d\\d\\d-\\d";
		String patternc2 = "ISBN\\s\\d\\d\\d-\\d-\\d\\d-\\d\\d\\d\\d\\d\\d-\\d";
		
		Pattern rc1 = Pattern.compile(patternc1);
		Matcher mc1 = rc1.matcher(s);
		Pattern rc2 = Pattern.compile(patternc2);
		Matcher mc2 = rc2.matcher(s);
		
		return mc1.matches() || mc2.matches();
	}
	
	public static String recodePasswd(String s) {
		byte[] digest = null;
		
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			digest = md5.digest(s.getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new BigInteger(1, digest).toString(16);
	}
	
	public static String getCurrentTime(String f) {
		SimpleDateFormat df = null;
		if (f.equals("time")) {
			df = new SimpleDateFormat("HH:mm:ss");
		} else if (f.equals("day")) {
			df = new SimpleDateFormat("yyyy-MM-dd");
		} else {
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		return df.format(new Date());
	}
	
	public static int authentication(long _id, String _passwd, LinkedList l) {
		Node now = l.searchNode(_id);
		if (now != null) {
			if (recodePasswd(_passwd).equals(now.getReaderData().getReaderPasswd())) {
				if (now.getReaderData().getReaderLevel() == 1) {
					System.out.println(" - " + Utils.getCurrentTime("time") + " | 认证服务：读者登录");
					return 1;
				} else {
					System.out.println(" - " + Utils.getCurrentTime("time") + " | 认证服务：管理员登录");
					return 0;
				}
			}
		}
		System.out.println(" - " + Utils.getCurrentTime("time") + " | 认证服务：用户名或密码错误");
		return -1;
	}
}
