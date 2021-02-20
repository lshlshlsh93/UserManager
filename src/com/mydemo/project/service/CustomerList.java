package com.mydemo.project.service;

import com.mydemo.project.domain.Customer;

/**
 * 
 * @Description CustomerList为Customer对象的管理模块
 *              内部用数组管理一组Customer对象，并提供相应的添加、删除、修改和遍历方法 供CustomerView调用
 * @author LSH QQ:1945773750
 * @version
 * @date 2021-1-14 10:36:46
 *
 */
public class CustomerList {
	private static  Customer[] customers; // 用来保存客户对象的数组
	 
	private static  int total = 0;//记录已保存客户对象的数量
	/**
	 * 用来初始化customers的构造器
	 * @param totalCustomer：指定数组的长度
	 */
	public CustomerList(int totalCustomer) {

		customers = new Customer[totalCustomer];

	}
	/**
	 * 
	 *
	 * @Description 将指定的客户添加到数组中
	 * @author LSH
	 * @date 2021-1-14 11:52:19
	 * @param cust
	 * @return  true:添加成功  false : 添加失败
	 *
	 */
	public static  boolean addCustomer(Customer customer) {
		
		if( total >= customers.length) {
			return false;
		}
		//customers[total] = customer;
		//total++;
		customers[total++] = customer;
		return true;
	}
	/**
	 * 
	 *
	 * @Description 删除指定索引位置的客户
	 * @author LSH
	 * @date 2021-1-14 12:16:32
	 * @param index
	 * @return true：删除成功   false：删除失败 
	 *
	 */
	public  boolean deleteCustomer(int index) {
		
		if(index < 0 || index >= total) {
			return false;
		} 
		for(int i = index;i < total - 1;i++) {
			customers[i] = customers[i + 1];
		}
		
		 //customers[total - 1] = null;
		//total--;
		 
		customers[--total] = null;
		return true;
	}
	/**
	 * 
	 *
	 * @Description 修改指定索引位置的客户信息
	 * @author LSH
	 * @date 2021-1-14 12:12:49
	 * @param index
	 * @param customer
	 * @return true:修改成功 false：修改失败
	 *
	 */
	public boolean replaceCustomer(int index,Customer customer) {
		
		if(index < 0 || index >= total) {
			return false;
		}
		customers[index] = customer;
		return true;
	}
	public Customer[] getAllCustomer() {
		Customer []  custs = new Customer[total]; 
		for(int i = 0;i < total;i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	/**
	 * 
	 * 
	 * @Description 返回指定索引位置上的客户
	 * @author LSH
	 * @date 2021-1-14 12:32:59
	 * @param index
	 * @return 如果找到了元素则返回，否则返回null
	 *
	 */
	public  Customer getCustomer(int index) {
		
		if(index < 0 || index >= total) {
			return null;
		}
		return customers[index];
	}	
	/**
	 * 
	 *
	 * @Description 获取存储的客户数量 
	 * @author LSH
	 * @date 2021-1-14 12:34:33
	 * @return
	 *
	 */
	public int getTotal() {
		
		return total;
		 //  return customers.length; 错误写法
		
	}
	
	
}
