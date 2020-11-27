package com.boot.www.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "t_storage")
public class Storage{

	@Id
	@GeneratedValue
	private Long id;
	private String commodityCode;
	private Integer count;
}
