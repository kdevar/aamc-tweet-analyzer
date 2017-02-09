package org.aamc.twttr.service;

import java.util.List;

import org.aamc.twttr.domain.Sentiment;
import org.springframework.stereotype.Component;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

@Component("tweetAnalyzer")
public class TweetAnalyzer {
	public Sentiment getSentiment(String text){
		Double totalSentiment = 0.0;
		Double averageSentiment = 0.0;
		StanfordCoreNLP pipeline = new StanfordCoreNLP("sentiment.properties");
		Annotation annotation = pipeline.process(text);
		List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
		for (CoreMap sentence : sentences) {
            Tree tree = sentence.get(SentimentCoreAnnotations.AnnotatedTree.class);
            int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
            totalSentiment += sentiment;
        }
		averageSentiment = totalSentiment/sentences.size();
        return Sentiment.getSentimentByIndex((int) Math.round(averageSentiment));
	}
	
}
