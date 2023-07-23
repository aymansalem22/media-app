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

@Data
@Entity
@Table(name= "playlist")
public class Playlist {
	
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

	
}
