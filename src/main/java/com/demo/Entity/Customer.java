package com.demo.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="customer_table")
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerid;
	
	private String customername;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="customer_item",
			joinColumns= {@JoinColumn(name="customerid")},
			inverseJoinColumns= {@JoinColumn(name="itemid")}
			)
	 private Set<Item> items=new HashSet<>();

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Customer(String customername) {
		super();
		this.customername = customername;
	}
	

}
