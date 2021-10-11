package com.te.designpattern.main;

import com.te.designpattern.service.StudentService;

public class AssignmentMain {
public static void main(String[] args) {
	Driver driver = new Driver();
	StudentService store = driver.driver();
	store.delete(12);
}
}
