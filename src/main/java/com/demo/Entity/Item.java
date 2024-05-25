
package com.demo.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="item_table")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemid;
	
	private String itemname;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "items")
	private Set<Customer> customers=new HashSet<Customer>();


	public Item(String itemname) {
		super();
		this.itemname = itemname;
	}
}
