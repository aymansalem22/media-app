package com.oberla.mediaapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oberla.mediaapp.entity.ErrorCodes;

import lombok.AllArgsConstructor;
import lombok.Data;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler
	public ResponseEntity<?> songNotFound(SongNotFoundException ex){
		return ResponseEntity.badRequest()
				.body(new ResponseStatusError(ErrorCodes.SONG_NOT_FOUND.code(),ex.getMessage()));
	
	}
	
	@ExceptionHandler
	public ResponseEntity<?> playlistNotFound(PlaylistNotFoundException ex){
		return ResponseEntity.badRequest()
				.body(new ResponseStatusError(ErrorCodes.PLAYLIST_NOT_FOUND.code(), ex.getMessage()));

	}

}

@Data
@AllArgsConstructor
class ResponseStatusError{
	
	@JsonProperty("status_code")
	private int status;
	
	@JsonProperty
	private String message;

	public ResponseStatusError(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	
	
}


