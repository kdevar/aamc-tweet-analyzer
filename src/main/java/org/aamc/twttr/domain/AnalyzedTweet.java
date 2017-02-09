package org.aamc.twttr.domain;

import lombok.Data;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.social.twitter.api.Tweet;

@Data
@Document(indexName="tweetswithdates")
public class AnalyzedTweet  {
	
	private Tweet tweet;
	private Sentiment sentiment;
	
	public String toString(){
		return tweet.getText() + " sentiment = " + sentiment;
	}

}
