package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data    //no need to generate getter setter constructor hashcode etc
@Entity  //now this class become JPA Entity
@Table(name="Employees") //if we dont use this then by default table name will be class name
public class Employee {

	@Id     //primary key for the Employees Table
	@GeneratedValue(strategy=GenerationType.IDENTITY) //specifies the generation strategies for the values of primary key
	private int empCode;
	
	@Column(name="First_Name",nullable=false)
	private String firstName;
	
	@Column(name="Last_Name",nullable=false)
	private String lastName;
	
	@Column(name="Email")
	private String emailId;
	
	/*
	 * till now after tjis if we run main method then Table with name Employees will
	 * get created in db as we have set ddl=auto in properties file
	 */
}
