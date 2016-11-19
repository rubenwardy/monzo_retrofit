package com.rubenwardy.monzo_retrofit;

import java.util.Date;

public class Account {
	public String id;
	public String description;
	public Date created;

	public String toString() {
		return id + " / " + description + " / " + created;
	}
}
