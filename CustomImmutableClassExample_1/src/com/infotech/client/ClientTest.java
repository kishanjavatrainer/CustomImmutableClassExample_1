package com.infotech.client;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.infotech.model.Employee;

public class ClientTest {
	
	public static void main(String[] args) {
		
		Employee e1 =  new Employee(1001, "KK", new BigDecimal("90000.00"),getDob("04/02/1986"));
		Employee e2 =  new Employee(1002, "Sean", new BigDecimal("40000.00"),getDob("25/02/1985"));
		Employee e3 =  new Employee(1003, "Martin", new BigDecimal("60000.00"),getDob("14/03/1985"));
		Employee e4 =  new Employee(1004, "Bob", new BigDecimal("95000.00"),getDob("15/12/1986"));
		
		ConcurrentMap<Employee,String> empMap = new ConcurrentHashMap<>();
		empMap.put(e1, "IT");
		empMap.put(e2, "Finanace");
		empMap.put(e3, "IT");
		empMap.put(e4, "Finanace");
		
		Set<Entry<Employee, String>> entrySet = empMap.entrySet();
		
		for (Entry<Employee, String> entry : entrySet) {
			Employee employee = entry.getKey();
			String dept = entry.getValue();
			System.out.println(employee);
			System.out.println(dept);
		}
		System.out.println("--------------------------------------");
		e1.getDob().setTime(8988878787L);
		System.out.println(e1);
		System.out.println(empMap.get(e1));
	}
	
	private static Date getDob(String dob){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return dateFormat.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}