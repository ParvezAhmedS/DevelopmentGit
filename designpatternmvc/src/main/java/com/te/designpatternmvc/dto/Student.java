package com.te.designpatternmvc.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Student {
@SequenceGenerator(name = "id" , initialValue = 1 , allocationSize = 1)
@Id
private int id;
private String name ;

}
