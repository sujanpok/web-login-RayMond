package com.example.demo.dataInput;

import lombok.Data;

@Data
public class Input {
	private String username;
	private String pwd;

	public String getUser() {
		return username;
	}

	public void setUser(String user) {
		this.username = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}