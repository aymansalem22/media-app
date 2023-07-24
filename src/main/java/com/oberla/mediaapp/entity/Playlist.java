package com.oberla.mediaapp.entity;


import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name= "playlist")
public class Playlist {
	
	
	public Playlist() {
		
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private BigInteger id;
	
	private String name;
	
	@Column(name= "created_on")
	@JsonProperty("created_on")
	private Date createdOn;
	
	@ElementCollection(targetClass = java.util.HashSet.class)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private Collection<Song> songs;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Collection<Song> getSongs() {
		return songs;
	}

	public void setSongs(Collection<Song> songs) {
		this.songs = songs;
	}
	
	

	
}
