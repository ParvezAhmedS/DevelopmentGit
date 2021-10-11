package com.te.designpattern.service;

import com.te.designpattern.dao.StudentDAO;
import com.te.designpattern.dao.StudentDaoImp;
import com.te.designpattern.dao.StudentDaoJdbc;
import com.te.designpattern.service.StudentService;

public class StudentServiceImpjdbc implements StudentService {
	StudentDAO dao =new StudentDaoJdbc();
	int a;
	public static StudentService getServiceJdbc() {
		return  new StudentServiceImpjdbc();
	}
	private StudentServiceImpjdbc() {
		super();
	}

	@Override
	public void select() {
		dao.select();
	}

	@Override
	public void selectById(int id) {
		if (id<=0) {
			System.out.println("enter proper id");
		}else {
			dao.selectById(id);
		}
	}

	@Override
	public void delete(int id) {
		if (id<=0) {
			System.out.println("enter proper id");
		}else {
			dao.delete(id);
		}
	}

	@Override
	public void update(int id) {
		if (id<=0) {
			System.out.println("enter proper id");
		}else {
			dao.update(id);
		}
	}

}
