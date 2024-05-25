package com.SDJ_Many_to_Many.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="item_table")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemid;
	
	private String itemname;


	public Item(String itemname) {
		super();
		this.itemname = itemname;
	}
}
