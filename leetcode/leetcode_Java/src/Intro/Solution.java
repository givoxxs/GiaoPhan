package Intro;

import java.util.HashSet;

class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> n1 = new HashSet<>();
        for (int i: nums1) {
        	n1.add(i);
        }
        
        HashSet<Integer> ans = new HashSet<>();
        for (int i: nums1) {
        	if (n1.contains(i)) {
        		ans.add(i);
        	}
        }
        
        int num = ans.size();
        
        int a[] = new int[num];
        int count  = 0;
        for (int i: ans) {
        	a[count] = i;
        	count++;
        }
        
        return a;
    }
}
