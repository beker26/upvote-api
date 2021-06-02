package br.com.segwareapi.upvote.feed.application.api.data;

import java.util.List;
import java.util.stream.Collectors;

import br.com.segwareapi.upvote.feed.domain.Reaction;
import lombok.Getter;

@Getter
public class ReactionDTO {

	private String react;

	public ReactionDTO(Reaction reaction) {
		this.react = reaction.getReact();
	}

	public static List<ReactionDTO> convert(List<Reaction> reaction) {
		return reaction.stream().map(ReactionDTO::new).collect(Collectors.toList());
    }

}
