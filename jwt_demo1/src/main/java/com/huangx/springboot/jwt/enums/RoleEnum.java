package com.huangx.springboot.jwt.enums;

/**
 * Roles： ADMIN & MEMBER
 * <p>
 * Created by Administrator on 2018/5/18.
 **/
public enum RoleEnum {
	ADMIN, MEMBER;

	public String authority() {
		return "ROLE_" + this.name();
	}

	@Override
	public String toString() {
		return this.name();
	}
}
