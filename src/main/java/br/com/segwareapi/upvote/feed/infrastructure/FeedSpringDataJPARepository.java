package br.com.segwareapi.upvote.feed.infrastructure;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.segwareapi.upvote.feed.domain.Feed;

@Repository
public interface FeedSpringDataJPARepository extends JpaRepository<Feed, UUID> {

	Optional<Feed> findById(Integer id);

}
