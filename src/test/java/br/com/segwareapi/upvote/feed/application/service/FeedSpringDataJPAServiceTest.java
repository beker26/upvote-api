package br.com.segwareapi.upvote.feed.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.segwareapi.upvote.feed.application.repository.FeedRepository;
import br.com.segwareapi.upvote.feed.domain.Feed;

class FeedSpringDataJPAServiceTest {

	private FeedSpringDataJPAService feedSpringDataJPAService;
	@Mock 
	private FeedRepository feedRepository;
	
	private Feed feed;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.feedSpringDataJPAService =  new FeedSpringDataJPAService(feedRepository);
		
	}

	@Test
	void deveSalvarERetornarUmPost() {
		this.feed = Feed.builder()
				.text("Estou com duvidas no Front End!")
				.createdAt(LocalDateTime.now())
				.build();
		Mockito.when(feedRepository.save(feed)).thenReturn(feed);
		Feed feedRetornado = feedSpringDataJPAService.adicionaPost(feed);
		assertEquals(feedRetornado, feed);
		Mockito.verify(this.feedRepository).save(feed);
	}


}
