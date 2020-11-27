package com.boot.www.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "t_account")
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	private String userId;
	private Integer money;
}
