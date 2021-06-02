package br.com.segwareapi.upvote.feed.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
public class Feed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String text;
	@OneToMany
	private List<Reaction> reaction;

}
