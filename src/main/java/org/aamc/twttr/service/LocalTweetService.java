package org.aamc.twttr.service;

import java.util.List;

import org.aamc.twttr.domain.AnalyzedTweet;




public interface LocalTweetService {
	
	public void saveTweets(List<AnalyzedTweet> tweets);

}
