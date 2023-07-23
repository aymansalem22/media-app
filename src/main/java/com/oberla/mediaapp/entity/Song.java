package com.oberla.mediaapp.entity;

import java.math.BigInteger;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "song")
@NamedNativeQuery(name = "songsByPlaylistId", query = "select id, name, playlist, cover_url, created_on from song s where s.playlist_id = ?",resultClass = Song.class)
public class Song {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private BigInteger id;
	
	@Column(name = "playlist_id")
	@JsonProperty("playlist_id")
	private BigInteger playlistId;
	
	private String name;
	
	@Column(name = "cover_url")
	@JsonProperty("cover_url")
	private String coverUrl;
	
	@Column(name = "created_on")
	@JsonProperty("created_on")
	private Date createdOn;

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
