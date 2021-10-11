package com.te.designpattern.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDaoJdbc implements StudentDAO{

	@Override
	public void select() {
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String dburl = "jdbc:mysql://localhost:3306/designpattern?user=root&password=root";
		try {
			connection = DriverManager.getConnection(dburl);
			String query = "select * from student";
			preparedStatement = connection.prepareStatement(query);
			resultSet =preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("ID :" + resultSet.getInt(1) + "   NAME :" + resultSet.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void selectById(int id) {
		Scanner scanner = new Scanner(System.in);
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String dburl = "jdbc:mysql://localhost:3306/designpattern?user=root&password=root";
		try {
			connection = DriverManager.getConnection(dburl);
			String query = "select * from student where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet =preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("ID :" + resultSet.getInt(1) + "   NAME :" + resultSet.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(int id) {
		
		Scanner scanner = new Scanner(System.in);
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String dburl = "jdbc:mysql://localhost:3306/designpattern?user=root&password=root";
		try {
			connection = DriverManager.getConnection(dburl);
			String query = "delete from student where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(int id) {

		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String dburl = "jdbc:mysql://localhost:3306/designpattern?user=root&password=root";
		try {
			connection = DriverManager.getConnection(dburl);
			String query = "update student set name=? where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
