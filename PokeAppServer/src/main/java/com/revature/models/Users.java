package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Users {

	@Id
	@Column(name = "u_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "u_username" )
	private String userName;
	
	@Column(name = "u_password")
	private String userPassword;
	
	@Column(name = "u_firstname")
	private String userFirstname;
	
	@Column(name = "u_lastname")
	private String userLastname;
	
	@JsonSerialize
	@OneToMany(mappedBy = "favUserId", cascade = CascadeType.ALL)
	private List<Favorite> favlist;
	
	@OneToMany(mappedBy = "teamUserId", cascade = CascadeType.ALL )
	private List<Teams> teams;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int userId, String userName, String userPassword, String userFirstname, String userLastname,
			List<Favorite> favlist, List<Teams> teams) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFirstname = userFirstname;
		this.userLastname = userLastname;
		this.favlist = favlist;
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userFirstname=" + userFirstname + ", userLastname=" + userLastname + ", favlist=" + favlist
				+ ", teams=" + teams + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((favlist == null) ? 0 : favlist.hashCode());
		result = prime * result + ((teams == null) ? 0 : teams.hashCode());
		result = prime * result + ((userFirstname == null) ? 0 : userFirstname.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userLastname == null) ? 0 : userLastname.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (favlist == null) {
			if (other.favlist != null)
				return false;
		} else if (!favlist.equals(other.favlist))
			return false;
		if (teams == null) {
			if (other.teams != null)
				return false;
		} else if (!teams.equals(other.teams))
			return false;
		if (userFirstname == null) {
			if (other.userFirstname != null)
				return false;
		} else if (!userFirstname.equals(other.userFirstname))
			return false;
		if (userId != other.userId)
			return false;
		if (userLastname == null) {
			if (other.userLastname != null)
				return false;
		} else if (!userLastname.equals(other.userLastname))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstname() {
		return userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public List<Favorite> getFavlist() {
		return favlist;
	}

	public void setFavlist(List<Favorite> favlist) {
		this.favlist = favlist;
	}

	public List<Teams> getTeams() {
		return teams;
	}

	public void setTeams(List<Teams> teams) {
		this.teams = teams;
	}


	
}
