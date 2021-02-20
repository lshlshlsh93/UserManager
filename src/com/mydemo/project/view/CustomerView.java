package com.mydemo.project.view;
/**
 * 
 * @Description 负责菜单的显示和处理用户操作
 * @author LSH QQ:1945773750
 * @version
 * @date 2021-1-14 10:39:46
 *
 */

import com.mydemo.project.domain.Customer;
import com.mydemo.project.service.CustomerList;
import com.mydemo.project.util.CMUtility;

public class CustomerView {
	
	private CustomerList customerList = new  CustomerList(10);
	
	public CustomerView() {
		Customer customer = new Customer("李明", '男', 18 , "17638991234", "lm@qq.com");
		CustomerList.addCustomer(customer);
	}
	public static void main(String[] args) {
		CustomerView  view = new CustomerView();
		view.enterMainMenu();
	}
	
	/**
	 * 
	 *  显示系统的方法
	 * @Description
	 * @author LSH
	 * @date 2021-1-14 12:42:07
	 *
	 */
	public void enterMainMenu() {
		
		boolean isFlag = true;
		while(isFlag) {
			System.out.println("\n-------------------客户信息管理软件 -------------------------------");
			System.out.println("\n					     1.添加客户 ");
			System.out.println("\n					     2.修改客户 ");
			System.out.println("\n					     3.删除客户 ");
			System.out.println("\n					     4.客户列表 ");
			System.out.println("\n					     5. 退         出\n");
			System.out.print("\n					     请选择（1-5)：") ;
			char readMenuSelection = CMUtility.readMenuSelection();		
			switch( readMenuSelection ) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomer();
				break;
			case '5':
				//System.out.println("退出");
				System.out.print("确认是否退出(Y/N): ");
				char isExit = CMUtility.readConfirmSelection();
				
				if( isExit == 'Y') {
					isFlag = false;
				}
				
			}
			//
		}
		
		
	}
	/**
	 * 
	 * 添加客户的操作
	 * @Description
	 * @author LSH
	 * @date 2021-1-14 12:40:05
	 *
	 */
	private void addNewCustomer() {
		//System.out.println("添加客户的操作");
		
		
		System.out.println("----------------客户列表---------------------");
		 System.out.print("姓名：");
		 String name = CMUtility.readString(10);
		 System.out.print("性别："); 
		 char gender = CMUtility.readChar();
		 System.out.print("年龄：");
		 int age = CMUtility.readInt();
		 System.out.print("电话：");
		 String phone = CMUtility.readString(13);
		 System.out.print("邮箱：");
		 String e_mail = CMUtility.readString(30);
		 //将上述数据封装到一个对象中
		 Customer customer = new Customer(name, gender, age, phone, e_mail);
		 boolean isSuccess = CustomerList.addCustomer(customer);
		 if(isSuccess) {
			 System.out.println("----------------添加成功---------------------");
		 }else {
			 System.out.println("----------------客户已满，添加失败！---------------------");
		 }
		 
	}
	/**
	 * 
	 * 修改客户的操作
	 * @Description
	 * @author LSH
	 * @date 2021-1-14 12:40:35
	 *
	 */
	private void modifyCustomer() {
		// System.out.println("修改客户的操作");
		 
		System.out.println("-------------------修改客户 -------------------------------");
		Customer cust;
		int number;
		while(true) {
			System.out.print("请选择待修改客户编号（-1退出）：");
			number = CMUtility.readInt();
			if (number == -1) {
				return; //结束方法
			}
			cust = customerList.getCustomer(number - 1);
			if(cust == null) {
				System.out.println("无法找到指定客户！");
			}else { //找到
				break;
			}
		}
		
		System.out.print("姓名 (" + cust.getName() + "):" );
		String name = CMUtility.readString(10, cust.getName());
		
		System.out.print("性别 (" + cust.getGender() + "):" );
		char gender = CMUtility.readChar(cust.getGender());
		
		System.out.print("年龄 (" + cust.getAge() + "):" );
		int age = CMUtility.readInt(cust.getAge());
		
		System.out.print("电话 (" + cust.getPhone() + "):" );
		String phone = CMUtility.readString(10, cust.getPhone());
		
		System.out.print("电子邮箱 (" + cust.getE_mail() + "):" );
		String e_mail = CMUtility.readString(30, cust.getE_mail());
		
		
		//将上述数据封装到一个对象中
		 Customer customer = new Customer(name, gender, age, phone, e_mail);
		 boolean isReplaced = customerList.replaceCustomer(number - 1, customer); //...bug  
		 if(isReplaced) {
			 System.out.println("----------------修改成功---------------------");
		 }else {
			 System.out.println("----------------修改失败！---------------------");
		 }
		 
	}

	/**
	 * 删除客户的操作
	 *
	 * @Description
	 * @author LSH
	 * @date 2021-1-14 12:40:47
	 *
	 */
	private void deleteCustomer() {
		 //System.out.println("删除客户的操作");
		System.out.println("-------------------删除客户 -------------------------------");
		Customer cust;
		int number;
		while(true) {
			System.out.print("请选择待删除客户编号（-1退出）：");
			number = CMUtility.readInt();
			if (number == -1) {
				return; //结束方法
			}
			cust = customerList.getCustomer(number - 1);
			if(cust == null) {
				System.out.println("无法找到指定客户！");
			}else { //找到
				break;
			}
		}
		System.out.print("是否确认删除(Y/N)：");
		char isDelete= CMUtility.readConfirmSelection();
		if( isDelete == 'Y') {
			boolean deleteSuccess = customerList.deleteCustomer(number - 1); //bug
			if(deleteSuccess) {
				System.out.println("-------------------删除成功 -------------------------------");
			}else {
				System.out.println("-------------------删除失败 -------------------------------");
			}	
		}
		//else {
		//	return;
		//}
		 
	}
	/**
	 * 
	 * 显示客户列表的操作
	 * @Description
	 * @author LSH
	 * @date 2021-1-14 12:41:46
	 *
	 */
	private void listAllCustomer() {
		 //System.out.println("显示客户列表的操作");
		System.out.println("----------------客户列表---------------------");
		int total = customerList.getTotal();
		if( total == 0) {
			System.out.println("没有客户记录");
		}else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱\t");
			Customer[] custs = customerList.getAllCustomer();
			for(int i = 0;i < custs.length;i++) {
				Customer cust = custs[i];
				System.out.println( (i + 1) + "\t" + cust.getName()+"\t" +cust.getGender() +
						"\t" + cust.getAge() + "\t" +cust.getPhone() +"\t" +cust.getE_mail());
				
			}
		}
		System.out.println("----------------客户列表完成---------------------");
			
	}
	
}
