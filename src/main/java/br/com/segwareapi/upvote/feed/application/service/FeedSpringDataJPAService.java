package br.com.segwareapi.upvote.feed.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.segwareapi.upvote.feed.application.repository.FeedRepository;
import br.com.segwareapi.upvote.feed.domain.Feed;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class FeedSpringDataJPAService implements FeedService {

	private FeedRepository feedRepository;

	@Override
	public List<Feed> findAll() {
		log.info("[Inicia] FeedSpringDataJPAService - findAll");
	    List<Feed> findAll = feedRepository.findAll();
		log.info("[Finaliza] FeedSpringDataJPAService - findAll");
		return findAll;
	}

}
