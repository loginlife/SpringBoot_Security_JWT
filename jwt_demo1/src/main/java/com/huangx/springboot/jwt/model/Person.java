package com.huangx.springboot.jwt.model;

import com.huangx.springboot.jwt.enums.RoleEnum;
import com.huangx.springboot.jwt.utils.IdUtils;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.List;

/**
 * Created by Administrator on 2018/5/18.
 */
public class Person {

	/**
	 * Person ID (indexed)
	 */
	@QuerySqlField(index = true)
	private long id;

	/**
	 * Person name(indexed)
	 */
	@QuerySqlField(index = true)
	private String username;

	/**
	 * Person phone(not-indexed)
	 */
	@QuerySqlField
	private String password;

	/**
	 * Person roles(not-indexed)
	 */
	@QuerySqlField
	private List<RoleEnum> roles;

	public Person() {
	}

	public Person(long id, String name, String password, List<RoleEnum> roles) {
		this.id = id;
		this.username = name;
		this.password = password;
		this.roles = roles;
	}

	public Person(String name, String password, List<RoleEnum> roles) {
		this.id = IdUtils.getId();
		this.username = name;
		this.password = password;
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<RoleEnum> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEnum> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Person [id=" + id +
				", username=" + username +
				", password=" + password +
				", roles=" + roles.toString() + "]";
	}
}
