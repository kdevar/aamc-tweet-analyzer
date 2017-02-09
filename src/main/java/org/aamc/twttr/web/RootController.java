package org.aamc.twttr.web;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.twitter.api.StreamingOperations;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

/**
 * This controller sits at the root of your application and returns a non-op 200 OK when it receives
 * a GET request.  This supports heart-beat checks on the application and should NOT be removed
 * or modified.
 * 
 * @author ahisley
 *
 */
@Controller
@RequestMapping("")
@Log4j
public class RootController {
	
	

	@RequestMapping(value="",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Object heartBeat()
	{
		
		
		
		
	
		return "OK";
	}
}
