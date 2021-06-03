package br.com.segwareapi.upvote.feed.infrastructure;

import java.util.List;


import org.springframework.stereotype.Component;

import br.com.segwareapi.upvote.feed.application.repository.FeedRepository;
import br.com.segwareapi.upvote.feed.domain.Feed;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
@Component
public class FeedJpaRepository implements FeedRepository {
	private FeedSpringDataJPARepository feedSpringDataJPARepository;

	@Override
	public Feed save(Feed feed) {

		log.info("[Inicia] FeedJpaRepository - save");
		Feed feedSalvo = feedSpringDataJPARepository.save(feed);
		log.info("[Finaliza] FeedJpaRepository - save");
		return feedSalvo;
	}

	@Override
	public List<Feed> findAll() {
		log.info("[Inicia] FeedJpaRepository - findAll");
		List<Feed> listFeed = feedSpringDataJPARepository.findAll();
		log.info("[Finaliza] FeedJpaRepository - findAll");
		return listFeed;
	}

	@Override
	public Feed findById(Integer id) {
		log.info("[Inicia] FeedJpaRepository - findById");
		Feed feedId = feedSpringDataJPARepository.findById(id).orElseThrow(() -> new RuntimeException("O Post não existe"));;
		return feedId;
	}

}
