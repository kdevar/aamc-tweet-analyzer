package org.aamc.twttr.service;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j;



import org.aamc.twttr.domain.AnalyzedTweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;

@Service("localTweetService")
@Log4j
public class LocalTweetServiceImpl implements LocalTweetService {
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	

	@Override
	public void saveTweets(List<AnalyzedTweet> tweets) {
		
		log.info(tweets);
		List<IndexQuery> indexQueries = new ArrayList<IndexQuery>();
		
		for(AnalyzedTweet tweet : tweets){
			IndexQuery indexQuery = new IndexQuery();
			indexQuery.setIndexName("tweetswithdates");
			indexQuery.setObject(tweet);
			indexQueries.add(indexQuery);
		}
		
		elasticsearchTemplate.bulkIndex(indexQueries);
		
	}

}
