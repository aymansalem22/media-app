package com.oberla.mediaapp.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oberla.mediaapp.entity.Playlist;
import com.oberla.mediaapp.entity.Song;
import com.oberla.mediaapp.exception.PlaylistNotFoundException;
import com.oberla.mediaapp.exception.SongNotFoundException;
import com.oberla.mediaapp.repository.PlaylistRepository;
import com.oberla.mediaapp.repository.SongRepository;

import jakarta.persistence.EntityManager;

@Service("playlistService")
public class PlaylistService {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private PlaylistRepository playlistRepo;
	
	@Autowired
	private SongRepository songRepo;
	
	public Iterable<Playlist> getAllPlaylists(){
		return playlistRepo.findAll();
	}
	
	public Playlist getPlaylistsById(BigInteger playlistId) {
		return getPlaylist(playlistId);
	}
	
	public Optional<Playlist> createPlaylist(String name){
		Playlist playlist = new Playlist();
		playlist.setName(name);
		playlist.setCreatedOn(new Date());
		return Optional.of(playlistRepo.save(playlist));
	}
	
	public void deletePlaylist(BigInteger playlistId) {
		Playlist playlist=getPlaylist(playlistId);
		playlist.setId(playlistId);
		playlistRepo.delete(playlist);
	}
	
	public Iterable<Song> getSongsV2(BigInteger playlistId){
		if(playlistId == null) {
			return songRepo.findAll();
		}
		playlistRepo.del(playlistId);
		Playlist playlist=getPlaylist(playlistId);
		return playlistRepo.getSongs(playlist.getId());
	}
	
	
	public void getSongs(BigInteger playlistId) {
		List<Song> resultList = entityManager.createNamedQuery("songsByPlaylistId",Song.class)
				.setParameter(1, playlistId)
				.getResultList();
		System.out.println(resultList);
				
	}
	
	
	public void deleteSongs(BigInteger playlistId) {
		Playlist playlist=getPlaylist(playlistId);
		songRepo.deleteByPlaylistId(playlist.getId());
	}
	
	public Song addSong(BigInteger playlistId, Song song) {
		Playlist playlist=getPlaylist(playlistId);
		song.setPlaylistId(playlist.getId());
		song.setCreatedOn(new Date());
		return songRepo.save(song);
	}
	
	public boolean moveSong(BigInteger songId,BigInteger toPlaylistId) {
		Song song = getSong(songId);
		Playlist playlist = getPlaylist(toPlaylistId);
		return 1 == songRepo.updatePlaylist(song.getId(),playlist.getId());
	}
	
	public void deleteSong(BigInteger playlistId, BigInteger songId) {
		Song song=getSong(songId);
		songRepo.delete(playlistId,song.getId());
	}
	
	


	private Song getSong(final BigInteger songId) {
		return songRepo.findById(songId).orElseThrow(() -> new SongNotFoundException(songId));
	}
	
	private Playlist getPlaylist(final BigInteger playlistId) {
		return playlistRepo.findById(playlistId)
				.orElseThrow(() -> new PlaylistNotFoundException(playlistId));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
