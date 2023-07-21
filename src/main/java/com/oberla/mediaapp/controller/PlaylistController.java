package com.oberla.mediaapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/playlist")
public class PlaylistController {
	
	@RequestMapping("/{id}")
	public String getAllPlayLists(@PathVariable("id") long playlistId) {
		return "";
	}
	
	

}
