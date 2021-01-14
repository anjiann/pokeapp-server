package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "teamlist")
public class TeamList {


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
    private int id;

	@Column(name = "teamlist_team_id")
	@JoinColumn(referencedColumnName = "teamid")
	@JsonBackReference
    private int teamListTeamId;
  
	@Column(name = "poke_id")
    private int teamPokeId;

	public TeamList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamList(int id, int teamListTeamId, int teamPokeId) {
		super();
		this.id = id;
		this.teamListTeamId = teamListTeamId;
		this.teamPokeId = teamPokeId;
	}

	@Override
	public String toString() {
		return "TeamList [id=" + id + ", teamListTeamId=" + teamListTeamId + ", teamPokeId=" + teamPokeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + teamListTeamId;
		result = prime * result + teamPokeId;
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
		TeamList other = (TeamList) obj;
		if (id != other.id)
			return false;
		if (teamListTeamId != other.teamListTeamId)
			return false;
		if (teamPokeId != other.teamPokeId)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeamListTeamId() {
		return teamListTeamId;
	}

	public void setTeamListTeamId(int teamListTeamId) {
		this.teamListTeamId = teamListTeamId;
	}

	public int getTeamPokeId() {
		return teamPokeId;
	}

	public void setTeamPokeId(int teamPokeId) {
		this.teamPokeId = teamPokeId;
	}
	
	
	 
	
}
