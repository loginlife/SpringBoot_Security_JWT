package com.huangx.springboot.jwt.model;

/**
 * Used for getting request for login and register
 * Because the request only has username and password info
 * <p>
 * Created by Administrator on 2018/5/18.
 **/
public class ReqPerson {
	/**
	 * Request username
	 */
	private String username;

	/**
	 * Request password
	 */
	private String password;

	public ReqPerson() {
	}

	public ReqPerson(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
