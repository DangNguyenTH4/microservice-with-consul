package com.learntony.microservice.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class AccountEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private Long id;
	private String number;
	private BigDecimal balance;
	private String customerId;

	private Date created;
	private Date updated;

	public AccountEntity(String number, BigDecimal balance, String customerId) {
		this.number = number;
		this.balance = balance;
		this.customerId = customerId;
	}
	@PrePersist
	void onCreate(){
		this.setCreated(new Date());
		this.setUpdated(new Date());
	}
	@PreUpdate
	void onUpdate() {
		this.setUpdated(new Date());
	}
}
