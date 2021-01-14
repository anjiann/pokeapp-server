package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Teams {
	

	@Id
	@Column(name = "team_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teamid;
 
	@Column(name = "team_name")
	private String teamName;
 
	@Column(name = "team_user_id")
	@JoinColumn(referencedColumnName = "userId")
	@JsonBackReference
    private int teamUserId;
	
	
	@OneToMany(mappedBy = "teamListTeamId", cascade = CascadeType.ALL )
	private List<TeamList> teamList;


	public Teams() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Teams(int teamid, String teamName, int teamUserId, List<TeamList> teamList) {
		super();
		this.teamid = teamid;
		this.teamName = teamName;
		this.teamUserId = teamUserId;
		this.teamList = teamList;
	}


	@Override
	public String toString() {
		return "Teams [teamid=" + teamid + ", teamName=" + teamName + ", teamUserId=" + teamUserId + ", teamList="
				+ teamList + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teamList == null) ? 0 : teamList.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		result = prime * result + teamUserId;
		result = prime * result + teamid;
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
		Teams other = (Teams) obj;
		if (teamList == null) {
			if (other.teamList != null)
				return false;
		} else if (!teamList.equals(other.teamList))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		if (teamUserId != other.teamUserId)
			return false;
		if (teamid != other.teamid)
			return false;
		return true;
	}


	public int getTeamid() {
		return teamid;
	}


	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public int getTeamUserId() {
		return teamUserId;
	}


	public void setTeamUserId(int teamUserId) {
		this.teamUserId = teamUserId;
	}


	public List<TeamList> getTeamList() {
		return teamList;
	}


	public void setTeamList(List<TeamList> teamList) {
		this.teamList = teamList;
	}

	


}
