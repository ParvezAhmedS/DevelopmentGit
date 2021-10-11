package com.te.designpattern.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.designpatternmvc.dto.Student;

public class StudentDaoImp implements StudentDAO{
	@Override
	public void select() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		Student student = null;
		try {
			factory = Persistence.createEntityManagerFactory("dp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String findall = "from Student";
			Query query = manager.createQuery(findall);
			List<Student> list = query.getResultList();
			for (Student employee : list) {
				System.out.println(student);
				transaction.commit();
			}
		}catch (Exception e) {
			e.printStackTrace();
			if (transaction!=null) {
				transaction.rollback();
			}
		}finally {
			if (factory!=null) {
				factory.close();
			}
			if (manager!=null) {
				manager.close();
			}
		}
	}

	@Override
	public void delete(int id) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		Student student = null;
		Scanner scanner = null;
		try {
			factory = Persistence.createEntityManagerFactory("dp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
//			System.out.println("enter id which u want to delete");
//			int id =scanner.nextInt();
			transaction.begin();
			String delete = "delete from Student where id=:id";
			Query query= manager.createQuery(delete);
			query.setParameter("id", id);
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if (transaction!=null) {
				transaction.rollback();
			}
		}finally {
			if (factory!=null) {
				factory.close();
			}
			if (manager!=null) {
				manager.close();
			}
		}
	}

	@Override
	public void update(int id) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		Student student = null;
		Scanner scanner = null;
		try {
			factory = Persistence.createEntityManagerFactory("dp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			System.out.println("Enter the name ");
			String name =scanner.next();
			transaction.begin();
			String findbyid = "update Student set name=:name where id=:id";
			Query query = manager.createQuery(findbyid);
			query.setParameter("id", id);
			query.setParameter("name",name);
			int i = query.executeUpdate();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if (transaction!=null) {
				transaction.rollback();
			}
		}finally {
			if (factory!=null) {
				factory.close();
			}
			if (manager!=null) {
				manager.close();
			}
		}
	}

	@Override
	public void selectById(int id) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		Student student = null;
		Scanner scanner = null;
		try {
			factory = Persistence.createEntityManagerFactory("dp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Student employee = manager.getReference(Student.class, id);
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if (transaction!=null) {
				transaction.rollback();
			}
		}finally {
			if (factory!=null) {
				factory.close();
			}
			if (manager!=null) {
				manager.close();
			}
		}

	}

}
