package com.company.dao.pojo.report;

import java.io.Serializable;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;

public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Login login;
	private Detail detail;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "UserInfo [login=" + login + ", detail=" + detail + "]";
	}

	public UserInfo(Login login, Detail detail) {
		super();
		this.login = login;
		this.detail = detail;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
