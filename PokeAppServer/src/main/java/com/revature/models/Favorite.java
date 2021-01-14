package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;

import org.hibernate.mapping.Collection;

import com.fasterxml.jackson.annotation.JsonBackReference;




@Entity
public class Favorite {
	
	@Id
	@Column(name = "fav_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favId;
	
	
	@Column(name = "fav_user_id")
	@JoinColumn(referencedColumnName = "userId")
	@JsonBackReference
	private int favUserId;
	
	
	
	@Column(name = "fav_list")
	private int favPokeId;

	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorite(int favId, int favUserId, int favPokeId) {
		super();
		this.favId = favId;
		this.favUserId = favUserId;
		this.favPokeId = favPokeId;
	}

	@Override
	public String toString() {
		return "Favorite [favId=" + favId + ", favUserId=" + favUserId + ", favPokeId=" + favPokeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + favId;
		result = prime * result + favPokeId;
		result = prime * result + favUserId;
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
		Favorite other = (Favorite) obj;
		if (favId != other.favId)
			return false;
		if (favPokeId != other.favPokeId)
			return false;
		if (favUserId != other.favUserId)
			return false;
		return true;
	}

	public int getFavId() {
		return favId;
	}

	public void setFavId(int favId) {
		this.favId = favId;
	}

	public int getFavUserId() {
		return favUserId;
	}

	public void setFavUserId(int favUserId) {
		this.favUserId = favUserId;
	}

	public int getfavPokeId() {
		return favPokeId;
	}

	public void setfavPokeId(int favPokeId) {
		this.favPokeId = favPokeId;
	}

	
	
	

}
