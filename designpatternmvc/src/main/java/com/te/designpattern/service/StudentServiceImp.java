package com.te.designpattern.service;

import com.te.designpattern.dao.StudentDAO;
import com.te.designpattern.dao.StudentDaoImp;
import com.te.designpattern.service.StudentService;

public class StudentServiceImp implements StudentService {
	StudentDAO dao = new StudentDaoImp();
	public static StudentService getService() {
		return new StudentServiceImp();
	}
	private StudentServiceImp() {
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
