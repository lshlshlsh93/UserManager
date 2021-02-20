package com.mydemo.project.util;

import java.util.Scanner;

public class CMUtility {
	
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * 
	 *
	 * @Description 用户菜单的选择。该方法读取键盘，如果用户输入’1'-'5'中的任意字符，则方法返回。返回值为用户键入的字符	
	 * @author LSH
	 * @date 2021-1-14 10:48:07
	 * @return
	 *
	 */
	public static char readMenuSelection() {
		
		char c;
		while(true) {
			String str = readKeyBoard(1,false);
			
			c= str.charAt(0);
			if( c != '1' && c != '2' && c != '3' && c != '4' && c !=  '5' ) {
				System.out.print("输入错误！请重新输入：");
			}else break;
		}
		return c;
		
	}

	/**
	 * 
	 *
	 * @Description 从键盘读取一个字符，并将其作为方法的返回值
	 * @author LSH
	 * @date 2021-1-14 10:54:41
	 * @return
	 *
	 */
	public static char readChar() {
		String str  = readKeyBoard(1,false);
		return str.charAt(0);
	
	}
	/**
	 * 
	 *
	 * @Description 从键盘读取一个字符，并将其作为方法的返回值
	 * 如果用户不输入字符直接回车，则以默认值 defaultValue作为方法的返回值
	 * @author LSH
	 * @date 2021-1-14 10:55:12
	 * @param defaultValue
	 * @return
	 *
	 */
	public static char readChar(char defaultValue) {
		String str  = readKeyBoard(1,true);
		return (str.length() == 0) ? defaultValue : str.charAt(0);
	}
	
	/*
	 * 键盘读取一个长度不超过2位的整数，并将其作为方法的返回值
	 */
	public static int readInt() {
		int n ;
		while(true) {
			String str  = readKeyBoard(2,false);
			try {
				n = Integer.parseInt(str);
				break;
			}catch(NumberFormatException e){
				System.out.print("数字输入错误！请重新输入：");
			}
		}
		return n;
	}
	
	/**
	 * 
	 *
	 * @Description  * 键盘读取一个长度不超过2位的整数，并将其作为方法的返回值
	 * 如果用户不输入字符直接回车，则以默认值 defaultValue作为方法的返回值
	 * @author LSH
	 * @date 2021-1-14 11:08:01
	 * @return
	 *
	 */
	public static int readInt(int defaultValue) {
		int n ;
		while(true) {
			String str  = readKeyBoard(2,true);
			if(str.equals("")) {
				return defaultValue;
			}
			try {
				n = Integer.parseInt(str);
				break;
			}catch(NumberFormatException e){
				System.out.print("数字输入错误！请重新输入：");
			}
		}
		return n;
	}
	
	/**
	 * 
	 *
	 * @Description 用户读取一个长度不超过limit的字符串，并将其作为方法的返回值
	 * @author LSH
	 * @date 2021-1-14 11:13:39
	 * @param limit
	 * @return
	 *
	 */
	public static String readString(int limit) {
		return readKeyBoard(limit, false);
	}
	
	/**
	 * 
	 *
	 * @Description 用户读取一个长度不超过limit的字符串，并将其作为方法的返回值
	 *  如果用户不输入字符直接回车，则以默认值 defaultValue作为方法的返回值
	 * @author LSH
	 * @date 2021-1-14 11:14:18
	 * @param limit
	 * @param defaultValue
	 * @return
	 *
	 */
	public static String readString(int limit,String defaultValue) {
		String str = readKeyBoard(limit,true);
		
		return str.equals("") ? defaultValue :  str ;
	}
	
	/**
	 * 
	 *
	 * @Description 用于确认选择的输入。该方法从键盘读取'Y'或'N' 并作为方法的返回值。
	 * @author LSH
	 * @date 2021-1-14 11:19:14
	 * @return
	 *
	 */
	public static char readConfirmSelection() {
	
		char c;
		for(;;) {
			String str = readKeyBoard(1, false).toUpperCase(); 
			c = str.charAt(0);
			
			if(c == 'Y' || c == 'N') {
				break;
			}else {
				System.out.print("输入错误！请重新输入：");
			}
		}	
		return c;
	}
	
	
	
	/**
	 * 
	 *
	 * @Description
	 * @author LSH
	 * @date 2021-1-14 11:01:08
	 * @param i
	 * @param b
	 * @return
	 *
	 */
	 private static String readKeyBoard(int limit, boolean blankReturn) {
			String line = "";
			
			while(scanner.hasNext()){
				line = scanner.nextLine();
				
				if(line.length() == 0) {
					if(blankReturn) return line;
					else continue;
				}
				
				if(line.length() < 1 || line.length() > limit) {
					System.out.print("输入长度（不大于"+ limit +"） 错误，请重新输入：");
					continue;
				}
				break;	
			}	
			return line ;
		}

}
