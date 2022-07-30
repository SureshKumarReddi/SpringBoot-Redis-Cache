package com.suresh.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String username;
	private String emailid;
	private String phoneno;
	
	public User() {
		
	}

	public User(long id, String username, String emailid, String phoneno) {
		super();
		this.id = id;
		this.username = username;
		this.emailid = emailid;
		this.phoneno = phoneno;
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

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", emailid=" + emailid + ", phoneno=" + phoneno + "]";
	}
	
	
	
}
