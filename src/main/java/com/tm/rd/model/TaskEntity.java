package com.tm.rd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class TaskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

}