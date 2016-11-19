package com.rubenwardy.monzo_retrofit;

import java.util.Date;
import java.util.Map;

public class Merchant {
	public String id;
	public String group_id;
	public Date created;
	public String name;
	public String logo;
	public String emoji;
	public String category;
	public boolean online;
	public boolean abm;
	public Date updated;
	public Map<String, String> metadata;

	public String getVenueType() {
		if (metadata.containsKey("foursquare_category")) {
			return metadata.get("foursquare_category");
		} else {
			return "other";
		}
	}
}
