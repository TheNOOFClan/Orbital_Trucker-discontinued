package com.github.thenoofclan.orbitaltrucker;

public class Item
{
	public int id;
	public int amount;
	public String desc;
	public String name;

	public Item (int id, int amount, String desc, String name)
	{
		this.id = id;
		this.amount = amount;
		this.desc = desc;
		this.name = name;
	}

	public Item()
	{
		this.id = 0;
		this.amount = 0;
		this.desc = "";
		this.name = "";
	}

}
