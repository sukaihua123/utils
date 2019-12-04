package utils;

import java.util.regex.Pattern;

public class StringUtils {
	// 是否为空
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() <= 0;
	}

	// 是否是手机号码
	public static boolean isPhone(String phone) {
		String pattern = "1(3|5|6|7|8)\\d{9}";
		boolean b = Pattern.matches(pattern, phone);
		return b;
	}

	// 是否是字母
	public static boolean isZi(String str) {
		String pattern = "[a-zA-Z]+";
		boolean b = Pattern.matches(pattern, str);
		return b;
	}

	// 是否是邮箱
	public static boolean isEmail(String str) {
		String pattern = "\\w+@\\w+(.com|.cn|.cn.com)";
		boolean b = Pattern.matches(pattern, str);
		return b;
	}

	// 获取n为随机英文字符串
	public static String ranString(int n) {
		String str = "";
		String pattern="[a-zA-Z]{1}";
		//int m=(int) (Math.random()*n+1);
		for (int i = 0; i < n; i++) {
            
		}
		return null;

	}
	
	public static void main(String[] args) {
		/*
		 * String str=""; boolean b = isEmpty(str); System.out.println(b);
		 */

		/*
		 * String phone="11"; boolean b = isPhone(phone); System.out.println(b);
		 */

		/*
		 * String str="ss"; boolean b = isZi(str); System.out.println(b);
		 */

		String str = "ss";
		boolean b = isZi(str);
		System.out.println(b);
	}

}
