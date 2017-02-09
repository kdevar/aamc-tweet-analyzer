package org.aamc.twttr.test;

import lombok.extern.log4j.Log4j;

import org.aamc.twttr.service.TweetAnalyzer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j
public class DummyTest extends BaseTest{
	
	@Autowired
	private TweetAnalyzer analyzer;
	
	@Test
	public void dummy()
	{
		log.info(analyzer.getSentiment("https://t.co/IFa6CTYjas"));
	}

}
