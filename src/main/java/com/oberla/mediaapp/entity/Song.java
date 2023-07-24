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


@Entity
@Table(name = "song")
@NamedNativeQuery(name = "songsByPlaylistId", query = "select id, name, playlist, cover_url, created_on from song s where s.playlist_id = ?",resultClass = Song.class)
public class Song {
	
	
	public Song() {
	
	}

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

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(BigInteger playlistId) {
		this.playlistId = playlistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
