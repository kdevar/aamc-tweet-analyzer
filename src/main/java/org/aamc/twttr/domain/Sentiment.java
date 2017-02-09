package org.aamc.twttr.domain;

public enum Sentiment {
	VERYNEGATIVE(0), NEGATIVE(1), NEUTRAL(2), POSITIVE(3), VERYPOSITIVE(4), NONE(-1);
	
	private int index;
	
	private Sentiment(int index){
		this.index = index;
	}
	
	
	public static Sentiment getSentimentByIndex(int index){
		switch(index){
		case 0:
			return VERYNEGATIVE;
		case 1:
			return NEGATIVE;
		case 2:
			return NEUTRAL;
		case 3:
			return POSITIVE;
		case 4:
			return VERYPOSITIVE;
		default:
			return NONE;
		}
	}
	
}
