package br.com.segwareapi.upvote.feed.application.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.segwareapi.upvote.feed.application.api.data.FeedDTO;

@RestController
@RequestMapping("/v1/feed")
public interface FeedAPI {

	@GetMapping
	public ResponseEntity<List<FeedDTO>> listaFeed();

}
