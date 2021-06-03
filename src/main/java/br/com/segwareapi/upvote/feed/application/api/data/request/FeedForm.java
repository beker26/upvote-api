package br.com.segwareapi.upvote.feed.application.api.data.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.segwareapi.upvote.feed.domain.Feed;
import lombok.Getter;

@Getter
public class FeedForm {
	
	@Size(min = 3, message = "Quantidade de caracteres não bate no limite minimo de 3 caracteres!")
	@Size(max = 260, message = "Quantidade de caracteres excede o limite de 1000 caracteres!")
	@NotNull(message = "o coomentario não pode ser null")
	@NotEmpty(message = "Campo obrigatório")
	private String text;
	
	private LocalDateTime createdAt = LocalDateTime.now();
	
	public Feed toFeed() {
	
		return Feed.builder()
				.text(this.text)
				.createdAt(this.createdAt)
				.build();
	}
	

}
