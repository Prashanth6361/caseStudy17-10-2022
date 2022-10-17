package com.gl.caseStudy4.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Entity
public class Users extends User {
	@Id
	private String username;
	private String userpass;
	public Users() {
		super("Prashanth","prash7",new ArrayList<>());
		// TODO Auto-generated constructor stub
	}
	public Users(String username, String userpass, Collection<? extends GrantedAuthority> authorities,String username2, String userpass2) {
		super(username, userpass, authorities);
		username=username2;
		userpass=userpass2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	
	

}
