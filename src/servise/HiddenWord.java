package servise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HiddenWord {
	// TODO 自動生成されたメソッド・スタブ
	final String[] names = { "ばか", "バカ", "死ね", "しね", "殺す", "ブス"};
	
	public static boolean isHiddenWord(String input) {
		
		String str = "ばか";
		String pattern = "^.*" + str + ".*$";
		
		// 禁止ワードをパターン化
		Pattern p = Pattern.compile(pattern);
		
		// 判定対象(ユーザの入力)
		Matcher m = p.matcher(input);
		
		// 判定
		return m.find();
	}
		
	public static boolean isHiddenWord2(String input) {
		String str2 = "バカ";
		String pattern2 = "^.*" + str2 + ".*$"; 
		
		Pattern p2 = Pattern.compile(pattern2);
		
		Matcher m2 = p2.matcher(input);
		return m2.find();
	}
	
	public static boolean isHiddenWord3(String input) {
		String str3 = "死ね";
		String pattern3 = "^.*" + str3 + ".*$"; 
		
		Pattern p3 = Pattern.compile(pattern3);
		
		Matcher m3 = p3.matcher(input);
		return m3.find();
	}
	
	public static boolean isHiddenWord4(String input) {
		String str4 = "しね";
		String pattern4 = "^.*" + str4 + ".*$"; 
		
		Pattern p4 = Pattern.compile(pattern4);
		
		Matcher m4 = p4.matcher(input);
		return m4.find();
	}
	
	public static boolean isHiddenWord5(String input) {
		String str5 = "殺す";
		String pattern5 = "^.*" + str5 + ".*$"; 
		
		Pattern p5 = Pattern.compile(pattern5);
		
		Matcher m5 = p5.matcher(input);
		return m5.find();
	}
	
	public static boolean isHiddenWord6(String input) {
		String str6 = "ブス";
		String pattern6 = "^.*" + str6 + ".*$"; 
		
		Pattern p6 = Pattern.compile(pattern6);
		
		Matcher m6 = p6.matcher(input);
		return m6.find();
	}
}
	
	/*
	if (MessageDto.getContent(names).contains("^(?!.*ばか).+$")) {

	}

	for (String name : names) {

		System.out.println("^(?!.*name).+$");
	}
	*/