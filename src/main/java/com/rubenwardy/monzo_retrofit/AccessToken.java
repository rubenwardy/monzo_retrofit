package com.rubenwardy.monzo_retrofit;

public class AccessToken {
	public String access_token;
	public String client_id;
	public int expires_in;
	public String refresh_token;
	public String token_type;
	public String user_id;

	public boolean isValid() {
		return access_token != null && access_token.length() >= 10;
	}
}
