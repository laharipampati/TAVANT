package com.tav.test.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name="Account")
@Table(name="Account")
public class Account {

	@Id
	@NotNull(message = "AccountId cannot be NULL")
	private Integer accId;
	
	private String accHolderName;
	private String phone;
	private String accType;
	private String address;
	
	
}
