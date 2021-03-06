package org.AEU.tinos.behavior.ICA;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.AEU.OCI.emotion.estimation.EmotionSample;
import org.AEU.emotion.engine.EmotionInit;
import org.AEU.emotion.engine.EnvironmentInit;
import org.ASQ.PSU.OCI.tinos.engine.analysis.Analyzer;
import org.ASQ.PSU.tinos.view.stable.StableData;
import org.OCI.emotion.ortho.fhmm.EmotionMap;

public class InitBehaviorICAKernel{
	private double[] kernel;
	public double[] getKernel() {
		return kernel;
	}

	public void setKernel(double[] kernel) {
		this.kernel = kernel;
	}

	public List<String> getForRestReturn() {
		return forRestReturn;
	}

	public void setForRestReturn(List<String> forRestReturn) {
		this.forRestReturn = forRestReturn;
	}

	private List<String> forRestReturn;
	public double getTrustRate(String text) throws IOException {
		EmotionInit emotionInitEnvironment = new EmotionInit();
		emotionInitEnvironment.init(text);
		double positiveCountEnvironment = emotionInitEnvironment.getPositiveCount();
		double totalCountEnvironment = emotionInitEnvironment.getTotalCount();
		positiveCountEnvironment += StableData.INT_ONE;
		return positiveCountEnvironment/totalCountEnvironment;
	}

	public double getTrustRate(String text, Analyzer analyzer, EmotionMap emotionMap) throws IOException {
		EmotionInit emotionInitEnvironment = new EmotionInit();
		emotionInitEnvironment.initExcludeAnalyzer(text, analyzer, emotionMap);
		//reduce
		double positiveCountEnvironment = emotionInitEnvironment.getPositiveCount();
		double totalCountEnvironment = emotionInitEnvironment.getTotalCount();
		positiveCountEnvironment += StableData.INT_ONE;
		return positiveCountEnvironment/totalCountEnvironment;
	}
	
	public double[] getBehaviorICAKernel(String text) throws IOException {
		forRestReturn = new LinkedList<>();
		kernel = new double[StableData.INT_SEVEN];	
		EmotionInit emotionInit = new EmotionInit();
		emotionInit.init(text);
		double positiveCount = emotionInit.getPositiveCount();
		double negativeCount = emotionInit.getNegativeCount();
		double totalCount = emotionInit.getTotalCount();
		forRestReturn.add("???????????????" + positiveCount);
		forRestReturn.add("???????????????" + negativeCount);
		if(positiveCount == StableData.INT_ZERO) {
			positiveCount = StableData.INT_ONE;
		}
		if(negativeCount == StableData.INT_ZERO) {
			negativeCount = StableData.INT_ONE;
		}
		double adjRatio = Math.abs(positiveCount/negativeCount-negativeCount/positiveCount);
		forRestReturn.add("???????????????" + adjRatio);
		double phychologicRatio = (positiveCount + negativeCount)/totalCount;
		forRestReturn.add("???????????????" + phychologicRatio);
		double infectionRatio = adjRatio*phychologicRatio;
		forRestReturn.add("???????????????" + infectionRatio);
		kernel[StableData.INT_ZERO] = adjRatio;
		kernel[StableData.INT_ONE] = phychologicRatio;
		kernel[StableData.INT_TWO] = infectionRatio;
		EnvironmentInit environmentInit = new EnvironmentInit();
		environmentInit.initFromEmotion(emotionInit.getWordFrequencyMap());
		Map<String, EmotionSample> environmentSampleMap = environmentInit.getEmotionSampleMap();
		forRestReturn.add("???????????????");
		String environmentText = "";
		Iterator<String> Iterator = environmentSampleMap.keySet().iterator();
		while(Iterator.hasNext()) {
			String word = Iterator.next();
			EmotionSample emotionSample = environmentSampleMap.get(word);
			if(null != emotionSample.getDistinction()) {
				environmentText += emotionSample.getDistinction() + StableData.SPACE_STRING;
			}
		}
		forRestReturn.add(environmentText);
		kernel[StableData.INT_THREE] = getTrustRate(environmentText);
		forRestReturn.add(StableData.EMPTY_STRING + kernel[StableData.INT_THREE]);
		forRestReturn.add("???????????????");
		String motivationText = StableData.EMPTY_STRING;
		Iterator = environmentSampleMap.keySet().iterator();
		while(Iterator.hasNext()) {
			String word = Iterator.next();
			EmotionSample emotionSample = environmentSampleMap.get(word);
			if(null != emotionSample.getMotivation()) {
				motivationText += emotionSample.getMotivation() + StableData.SPACE_STRING;
			}
		}
		forRestReturn.add(motivationText);
		kernel[StableData.INT_FOUR] = getTrustRate(motivationText);
		forRestReturn.add(StableData.EMPTY_STRING+kernel[StableData.INT_FOUR]);
		forRestReturn.add("???????????????");
		String trendingText = StableData.EMPTY_STRING;
		Iterator = environmentSampleMap.keySet().iterator();
		while(Iterator.hasNext()) {
			String word = Iterator.next();
			EmotionSample emotionSample = environmentSampleMap.get(word);
			if(null != emotionSample.getTrending()) {
				trendingText += emotionSample.getTrending() + StableData.SPACE_STRING;
			}
		}
		forRestReturn.add(trendingText);
		kernel[StableData.INT_FIVE] = getTrustRate(trendingText);
		forRestReturn.add(StableData.EMPTY_STRING + kernel[StableData.INT_FIVE]);
		forRestReturn.add("???????????????");
		String predictionText = StableData.EMPTY_STRING;
		Iterator = environmentSampleMap.keySet().iterator();
		while(Iterator.hasNext()) {
			String word = Iterator.next();
			EmotionSample emotionSample = environmentSampleMap.get(word);
			if(null != emotionSample.getPrediction()) {
				predictionText += emotionSample.getPrediction() + StableData.SPACE_STRING;
			}
		}
		forRestReturn.add(predictionText);
		kernel[StableData.INT_SIX] = getTrustRate(predictionText);
		forRestReturn.add(StableData.EMPTY_STRING + kernel[StableData.INT_SIX]);
		return kernel;
	}

	public double[] getBehaviorICAKernel(String text, Analyzer analyzer, EmotionMap emotionMap) throws IOException {
		forRestReturn = new LinkedList<>();
		kernel = new double[StableData.INT_SEVEN];	
		EmotionInit emotionInit = new EmotionInit();
		emotionInit.initExcludeAnalyzer(text, analyzer, emotionMap);
		double positiveCount = emotionInit.getPositiveCount();
		double negativeCount = emotionInit.getNegativeCount();
		double totalCount = emotionInit.getTotalCount();
		forRestReturn.add("???????????????" + positiveCount);
		forRestReturn.add("???????????????" + negativeCount);
		if(positiveCount == StableData.INT_ZERO) {
			positiveCount = StableData.INT_ONE;
		}
		if(negativeCount == StableData.INT_ZERO) {
			negativeCount = StableData.INT_ONE;
		}
		double adjRatio = Math.abs(positiveCount/negativeCount-negativeCount/positiveCount);
		forRestReturn.add("???????????????" + adjRatio);
		double phychologicRatio = (positiveCount + negativeCount)/totalCount;
		forRestReturn.add("???????????????" + phychologicRatio);
		double infectionRatio = adjRatio*phychologicRatio;
		forRestReturn.add("???????????????" + infectionRatio);
		kernel[StableData.INT_ZERO] = adjRatio;
		kernel[StableData.INT_ONE] = phychologicRatio;
		kernel[StableData.INT_TWO] = infectionRatio;
		EnvironmentInit environmentInit = new EnvironmentInit();
		environmentInit.initFromEmotionExcludeEmotion(emotionInit.getWordFrequencyMap(), emotionMap);
		Map<String, EmotionSample> environmentSampleMap = environmentInit.getEmotionSampleMap();
		forRestReturn.add("???????????????");
		String environmentText = StableData.EMPTY_STRING;
		Iterator<String> Iterator = environmentSampleMap.keySet().iterator();
		while(Iterator.hasNext()) {
			String word = Iterator.next();
			EmotionSample emotionSample = environmentSampleMap.get(word);
			if(null != emotionSample.getDistinction()) {
				environmentText += emotionSample.getDistinction() + StableData.SPACE_STRING;
			}
		}
		forRestReturn.add(environmentText);
		kernel[StableData.INT_THREE] = getTrustRate(environmentText, analyzer, emotionMap);
		forRestReturn.add(StableData.EMPTY_STRING+kernel[StableData.INT_THREE]);
		forRestReturn.add("???????????????");
		String motivationText = StableData.EMPTY_STRING;
		Iterator = environmentSampleMap.keySet().iterator();
		while(Iterator.hasNext()) {
			String word = Iterator.next();
			EmotionSample emotionSample = environmentSampleMap.get(word);
			if(null != emotionSample.getMotivation()) {
				motivationText += emotionSample.getMotivation() + StableData.SPACE_STRING;
			}
		}
		forRestReturn.add(motivationText);
		kernel[StableData.INT_FOUR] = getTrustRate(motivationText, analyzer, emotionMap);
		forRestReturn.add(StableData.EMPTY_STRING+kernel[StableData.INT_FOUR]);
		forRestReturn.add("???????????????");
		String trendingText = StableData.EMPTY_STRING;
		Iterator = environmentSampleMap.keySet().iterator();
		while(Iterator.hasNext()) {
			String word = Iterator.next();
			EmotionSample emotionSample = environmentSampleMap.get(word);
			if(null != emotionSample.getTrending()) {
				trendingText += emotionSample.getTrending() + StableData.SPACE_STRING;
			}
		}
		forRestReturn.add(trendingText);
		kernel[StableData.INT_FIVE] = getTrustRate(trendingText, analyzer, emotionMap);
		forRestReturn.add(StableData.EMPTY_STRING+kernel[StableData.INT_FIVE]);
		forRestReturn.add("???????????????");
		String predictionText = StableData.EMPTY_STRING;
		Iterator = environmentSampleMap.keySet().iterator();
		while(Iterator.hasNext()) {
			String word = Iterator.next();
			EmotionSample emotionSample = environmentSampleMap.get(word);
			if(null != emotionSample.getPrediction()) {
				predictionText += emotionSample.getPrediction() + StableData.SPACE_STRING;
			}
		}
		forRestReturn.add(predictionText);
		kernel[StableData.INT_SIX] = getTrustRate(predictionText, analyzer, emotionMap);
		forRestReturn.add(StableData.EMPTY_STRING+kernel[StableData.INT_SIX]);
		return kernel;
	}
}