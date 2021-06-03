package br.com.segwareapi.upvote.feed.application.repository;

import java.util.List;

import br.com.segwareapi.upvote.feed.domain.Feed;

public interface FeedRepository {

	Feed save(Feed feed);

	List<Feed> findAll();

	Feed findById(Integer id);
}
