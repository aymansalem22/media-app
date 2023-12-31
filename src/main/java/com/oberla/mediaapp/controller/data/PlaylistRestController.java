package com.oberla.mediaapp.controller.data;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oberla.mediaapp.entity.Playlist;
import com.oberla.mediaapp.entity.Song;
import com.oberla.mediaapp.service.PlaylistService;

@RestController
@RequestMapping("/playlist")
public class PlaylistRestController {
	

	public PlaylistService service;

	@Qualifier("playlistService")
	@Autowired
	public void setService(PlaylistService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String root() {
		return "application is runnning!";
	}

	@GetMapping("/all")
	public Iterable<Playlist> getAllPlaylists() {
		return service.getAllPlaylists();
	}

	@GetMapping("/{id}")
	public Playlist getPlaylistById(final @PathVariable("id") BigInteger playlistId) {
		return service.getPlaylistsById(playlistId);
	}

	@PostMapping("/{name}")
	public Optional<Playlist> createPlaylist(final @PathVariable String name) {
		return service.createPlaylist(name);
	}

	@DeleteMapping("/{id}")
	public void deletePlaylist(final @PathVariable("id") BigInteger playlistId) {
		service.deletePlaylist(playlistId);
	}

	@GetMapping("/{id}/songs")
	public Iterable<Song> getSongsInPlaylist(@PathVariable("id") BigInteger playlistId) {
		return service.getSongsV2(playlistId);
	}

	@DeleteMapping("/{id}/songs")
	public void deleteAllSongsInPlaylist(final @PathVariable("id") BigInteger playlistId) {
		service.deleteSongs(playlistId);
	}

	@PostMapping("/{id}/add")
	public Song addSongToPlaylist(final @PathVariable("id") BigInteger playlistId,
			final @RequestBody Song song) {
		return service.addSong(playlistId, song);
	}

	@GetMapping("/songs")
	public Iterable<Song> getAllSongs() {
		return service.getSongsV2(null);
	}

	@PutMapping("/songs/{id}/move")
	public boolean moveSongToDifferentPlaylist(@PathVariable("id") BigInteger songId,
			@RequestParam("to_playlist") BigInteger toPlaylistId) {
		return service.moveSong(songId, toPlaylistId);
	}

	@DeleteMapping("/{id}/songs/{song_id}")
	public void deleteFromPlaylist(final @PathVariable("id") BigInteger playlistId,
			final @PathVariable("song_id") BigInteger songId) {
		service.deleteSong(playlistId, songId);
	}

}
