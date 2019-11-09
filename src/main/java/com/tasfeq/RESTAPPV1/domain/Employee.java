package com.tasfeq.RESTAPPV1.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String phone;
	
	private Date createdAt;
	
	public Employee() {}

	public Employee(Long id, @NotNull String name, @NotNull String phone, @NotNull Date createdAt) {
		this(name,phone,createdAt);
		this.id = id;
	}
	
	public Employee(@NotNull String name, @NotNull String phone, @NotNull Date createdAt) {
		this.name = name;
		this.phone = phone;
		this.createdAt = createdAt;
	} 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", createdAt=" + createdAt + "]";
	}
	
}
