package br.com.segwareapi.upvote.feed.application.api.data.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.segwareapi.upvote.feed.domain.Feed;
import lombok.Getter;

@Getter
public class FeedDTO {

	private String text;
	private LocalDateTime createdAt;
	private Integer reactions;

	public FeedDTO(Feed feed) {
		this.text = feed.getText();
		this.createdAt = feed.getCreatedAt();
		this.reactions =  feed.getReactions();
	}

	public static List<FeedDTO> listFeed(List<Feed> feed) {
		return feed.stream().map(FeedDTO::new).collect(Collectors.toList());

	}

}
