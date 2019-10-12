package parctices;

import java.util.ArrayList;
import java.util.List;

public class DFS {
	/*
	 * All Subsets I
	 * 
	 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
	 */
	
	public List<String> subSets(String set){
		List<String> result = new ArrayList<>();
	    if(set == null){
	      return result;
	    }
	    
	    int index = 0;
	    StringBuilder solPrefix = new StringBuilder();
	    char[] array = set.toCharArray();
	    findSubset(solPrefix,array, index, result);
	    return result;
	}
	
	private void findSubset(StringBuilder solPrefix,char[] array, int index, List<String> result){
	    if(index == array.length){
	      result.add(solPrefix.toString());
	      return;
	    }
	    
	    solPrefix.append(array[index]);
	    findSubset(solPrefix, array, index + 1, result);
	    solPrefix.deleteCharAt(solPrefix.length() - 1);
	    findSubset(solPrefix, array, index + 1, result);
	  }
}
