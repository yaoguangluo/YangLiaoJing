package org.PEQ.tinos.sensing.test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.ASQ.PSU.OCI.tinos.engine.analysis.Analyzer;
public class RNN_IDETest{
	public static void main(String[] argv) throws IOException, InstantiationException, IllegalAccessException {
		RNN_IDETest rNN_IDETest= new RNN_IDETest();
		rNN_IDETest.getIDEMatrix();	
	}

	public String[][] getIDEMatrix() throws IOException, InstantiationException, IllegalAccessException{
		SensingTest sensingTest = new SensingTest();
		String[][] sensingMatrix = sensingTest.getMatrix();
		Map<String, List<Double>> map = new HashMap<>();
		for(int i = 0; i < sensingMatrix.length; i++) {
			List<Double> list = new LinkedList<>(); 
			list.add(1.0);
			map.put(sensingMatrix[i][0], list);
		}
		String[][] ideMatrix = new String [sensingMatrix.length][4];
		List<String> sets = sensingTest.getSets();
		Map<String, String> pos = sensingTest.getPosCnToCn();
		Iterator<String> setsIterator = sets.iterator();
		double count = 1;
		//map position
		while(setsIterator.hasNext()) {
			String word = setsIterator.next();
			if(map.containsKey(word)) {
				List<Double> list  = map.get(word);
				list.add(count);
				map.put(word, list);
			}	
			count++;
		}
		//RNN LOOP position
		int ideMatrixCount = 0;
		Iterator<String> mapIterator = map.keySet().iterator();
		while(mapIterator.hasNext()) {
			String word = mapIterator.next();
			List<Double> list = map.get(word);
			double dovFactor = 1;
			double popFactor = 0;
			double eopFactor = 1;
			double dovCount = 1;
			for(int i = 0; i < list.size(); i++) {
				for(int j = i + 1; j < list.size(); j++) {
					dovCount ++;
					dovFactor += list.get(j);
				}
				dovFactor += Math.abs(list.get(i) - dovFactor);
				eopFactor += (eopFactor + list.get(i)) / 2;
			}
			//pos normalization
			if(pos.containsKey(word)) {
				popFactor += pos.get(word).contains("??????")? 16: 0;
				popFactor += pos.get(word).contains("??????")? 4: 0;
				popFactor += pos.get(word).contains("??????")? 2: 0;	
			}
			ideMatrix[ideMatrixCount][0] = word;
			ideMatrix[ideMatrixCount][1] = "" + popFactor;
			ideMatrix[ideMatrixCount][2] = "" + dovFactor/dovCount;
			ideMatrix[ideMatrixCount][3] = "" + eopFactor;
			ideMatrixCount++;
		}
		return ideMatrix;
	}

	public String[][] getIDEMatrixExcludeAnalyzer(Analyzer analyzer, String string) throws IOException {
		SensingTest sensingTest = new SensingTest();
		String[][] sensingMatrix = sensingTest.getMatrix(string, analyzer);
		Map<String, List<Double>> map = new HashMap<>();
		for(int i = 0; i < sensingMatrix.length; i++) {
			List<Double> list = new LinkedList<>(); 
			list.add(1.0);
			map.put(sensingMatrix[i][0], list);
		}
		String[][] ideMatrix = new String [sensingMatrix.length][4];
		List<String> sets = sensingTest.getSets();
		Map<String, String> pos = sensingTest.getPosCnToCn();
		Iterator<String> setsIterator = sets.iterator();
		double count = 1;
		//map position
		while(setsIterator.hasNext()) {
			String word = setsIterator.next();
			if(map.containsKey(word)) {
				List<Double> list  = map.get(word);
				list.add(count);
				map.put(word, list);
			}	
			count++;
		}
		//RNN LOOP position
		int ideMatrixCount = 0;
		Iterator<String> mapIterator = map.keySet().iterator();
		while(mapIterator.hasNext()) {
			String word = mapIterator.next();
			List<Double> list = map.get(word);
			double dovFactor = 1;
			double popFactor = 0;
			double eopFactor = 1;
			double dovCount = 1;
			for(int i = 0; i < list.size(); i++) {
				for(int j = i + 1; j < list.size(); j++) {
					dovCount ++;
					dovFactor += list.get(j);
				}
				dovFactor += Math.abs(list.get(i) - dovFactor);
				eopFactor += (eopFactor + list.get(i)) / 2;
			}
			//pos normalization
			if(pos.containsKey(word)) {
				popFactor += pos.get(word).contains("??????")? 16: 0;
				popFactor += pos.get(word).contains("??????")? 4: 0;
				popFactor += pos.get(word).contains("??????")? 2: 0;	
			}

			ideMatrix[ideMatrixCount][0] = word;
			ideMatrix[ideMatrixCount][1] = "" + popFactor;
			ideMatrix[ideMatrixCount][2] = "" + dovFactor/dovCount;
			ideMatrix[ideMatrixCount][3] = "" + eopFactor;
			ideMatrixCount++;
		}
		return ideMatrix;
	}

	public String[][] getIDEMatrixExcludeAnalyzer(SensingTest sensingTest, String[][] ann, Analyzer analyzer, String string) {
		String[][] sensingMatrix = ann;
		Map<String, List<Double>> map = new HashMap<>();
		for(int i = 0; i < sensingMatrix.length; i++) {
			List<Double> list = new LinkedList<>(); 
			list.add(1.0);
			map.put(sensingMatrix[i][0], list);
		}
		String[][] ideMatrix= new String [sensingMatrix.length][4];
		List<String> sets= sensingTest.getSets();
		Map<String, String> pos= sensingTest.getPosCnToCn();
		Iterator<String> setsIterator= sets.iterator();
		double count= 1;
		//map position
		while(setsIterator.hasNext()) {
			String word= setsIterator.next();
			if(map.containsKey(word)) {
				List<Double> list= map.get(word);
				list.add(count);
				map.put(word, list);
			}	
			count++;
		}
		//RNN LOOP position
		int ideMatrixCount= 0;
		Iterator<String> mapIterator= map.keySet().iterator();
		while(mapIterator.hasNext()) {
			String word= mapIterator.next();
			List<Double> list= map.get(word);
			double dovFactor= 1;
			double popFactor= 0;
			double eopFactor= 1;
			double dovCount= 1;
			for(int i= 0; i< list.size(); i++) {
				for(int j= i + 1; j< list.size(); j++) {
					dovCount++;
					dovFactor+= list.get(j);
				}
				dovFactor+= Math.abs(list.get(i)- dovFactor);
				eopFactor+= (eopFactor+ list.get(i))/ 2;
			}
			//pos normalization
			if(pos.containsKey(word)) {
				popFactor+= pos.get(word).contains("???")? 16: 0;
				popFactor+= pos.get(word).contains("???")? 5: 0;
				popFactor+= pos.get(word).contains("???")? 3: 0;
				popFactor+= pos.get(word).contains("???")? 3: 0;
				popFactor+= pos.get(word).contains("???")? 2: 0;
			}
			ideMatrix[ideMatrixCount][0]= word;
			ideMatrix[ideMatrixCount][1]= ""+ popFactor;
			ideMatrix[ideMatrixCount][2]= ""+ dovFactor/ dovCount;
			ideMatrix[ideMatrixCount][3]= ""+ eopFactor;
			ideMatrixCount++;
		}
		return ideMatrix;
	}
}