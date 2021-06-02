package br.com.segwareapi.upvote.feed.application.service;

import java.util.List;

import br.com.segwareapi.upvote.feed.domain.Feed;

public interface FeedService {

	public List<Feed> findAll();

}
