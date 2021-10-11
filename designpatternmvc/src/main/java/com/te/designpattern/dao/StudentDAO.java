package com.te.designpattern.dao;

public interface StudentDAO {
void select();
void selectById(int id);
void delete(int id);
void update(int id);
}
