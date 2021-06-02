package br.com.segwareapi.upvote.feed.application.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.segwareapi.upvote.feed.domain.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, UUID> {

}
