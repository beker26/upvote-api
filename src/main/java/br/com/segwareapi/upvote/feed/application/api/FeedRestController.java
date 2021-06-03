package br.com.segwareapi.upvote.feed.application.api;

import java.net.URI;
import java.util.List;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.segwareapi.upvote.feed.application.api.data.request.FeedForm;
import br.com.segwareapi.upvote.feed.application.api.data.response.FeedDTO;
import br.com.segwareapi.upvote.feed.application.service.FeedService;
import br.com.segwareapi.upvote.feed.domain.Feed;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@RestController
public class FeedRestController implements FeedAPI {
	
	private FeedService feedService;

	@Override
	public ResponseEntity<List<FeedDTO>> listaFeed() {
		log.info("[Inicia] FeedRestController - listaFeed");
		List<Feed> feed = this.feedService.findAll();
		List<FeedDTO> listFeed = FeedDTO.listFeed(feed);
		log.info("[Finaliza] FeedRestController - listaFeed");
		return ResponseEntity.ok().body(listFeed);
	}

	@Override
	public ResponseEntity<FeedDTO> adicionaPost(@Valid FeedForm feedForm, UriComponentsBuilder uriBuilder) {
		log.info("[Inicia] FeedRestController - adicionaPost");
		log.info("Form: {}", feedForm);
		Feed feed = feedService.adicionaPost(feedForm.toFeed());
		URI uri = uriBuilder.path("/feed/{id}").buildAndExpand(feed.getId()).toUri();
		log.info("[Finaliza] FeedRestController - adicionaPost");
		return ResponseEntity.created(uri).body(new FeedDTO(feed));
		
	}

	@Override
	public ResponseEntity<FeedDTO> liked(@PathVariable Integer id) {
		log.info("[Inicia] FeedRestController - liked");
		Feed likedPost = feedService.liked(id);
		log.info("[Finaliza] FeedRestController - liked");
		return ResponseEntity.ok().body(new FeedDTO(likedPost));
	}

}
