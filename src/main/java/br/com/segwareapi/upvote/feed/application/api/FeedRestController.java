package br.com.segwareapi.upvote.feed.application.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.segwareapi.upvote.feed.application.api.data.FeedDTO;
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

}
