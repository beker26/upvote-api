package br.com.segwareapi.upvote.feed.application.api.data;

import java.util.List;
import java.util.stream.Collectors;

import br.com.segwareapi.upvote.feed.domain.Feed;
import lombok.Getter;

@Getter
public class FeedDTO {

	private String text;
	private List<ReactionDTO> reaction;

	public FeedDTO(Feed feed) {
	this.text = feed.getText();
	this.reaction = ReactionDTO.convert(feed.getReaction());
	}

	public static List<FeedDTO> listFeed(List<Feed> feed) {
		return feed.stream().map(FeedDTO::new).collect(Collectors.toList());
		
	}

}
