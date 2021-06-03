package br.com.segwareapi.upvote.feed.application.api;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.segwareapi.upvote.feed.application.api.data.request.FeedForm;
import br.com.segwareapi.upvote.feed.application.api.data.response.FeedDTO;

@RestController
@RequestMapping("/v1/feed")
public interface FeedAPI {

	@GetMapping
	public ResponseEntity<List<FeedDTO>> listaFeed();
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<FeedDTO> adicionaPost(@RequestBody @Valid FeedForm feedForm,
			UriComponentsBuilder uriBuilder);
	
	@PutMapping("/{id}/upvote")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<FeedDTO> liked(@PathVariable Integer id);

}
