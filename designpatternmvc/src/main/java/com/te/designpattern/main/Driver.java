package com.te.designpattern.main;

import java.util.Scanner;


import com.te.designpattern.service.StudentService;
import com.te.designpattern.service.StudentServiceImp;
import com.te.designpattern.service.StudentServiceImpjdbc;

public class Driver {
public StudentService driver() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter type jdbc/hibernate ");
	String string = scanner.next();
	if (string.equalsIgnoreCase("jdbc")) {
		return StudentServiceImpjdbc.getServiceJdbc();
	}else if (string.equalsIgnoreCase("hibernate")) {
		return StudentServiceImp.getService();
	}else {
		System.out.println("Invalid Entry");
	}
	return null;
}
}
