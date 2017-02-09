package org.aamc.twttr.converter;

import org.aamc.twttr.domain.AnalyzedTweet;
import org.aamc.twttr.service.TweetAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;



@Component("tweetToAnalyzedTweetConverter")
public class TweetConverter {
	
	@Autowired
	private TweetAnalyzer analyzer;
	
	public AnalyzedTweet convert(Tweet tweet){
		AnalyzedTweet analyzedTweet = new AnalyzedTweet();
		analyzedTweet.setTweet(tweet);
		analyzedTweet.setSentiment(analyzer.getSentiment(tweet.getText()));
		return analyzedTweet;
	}

}
