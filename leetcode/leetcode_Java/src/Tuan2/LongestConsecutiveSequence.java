package Tuan2;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
        	numSet.add(num);
        }
        
        int longestSeq = 0;
        for (int num : numSet) {
        	if (!numSet.contains(num-1)) {
        		int currentSeq = 1;
        		int nextNum = num + 1;
        		
        		while (numSet.contains(nextNum)) {
        			currentSeq ++;
        			nextNum ++;
        		}
        		
        		longestSeq = Math.max(currentSeq, longestSeq);
        	}
        }
        
		return longestSeq;
    }
}
