//Subsets Backtracking
package Intro;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
        
    }
    
    public static void main(String[] args) {
    	long t1,t2;
        t1 = System.currentTimeMillis();
        Subsets2 solution = new Subsets2();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);

        System.out.println("Subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
        

        t2 = System.currentTimeMillis();
        System.out.println("Executed Time: " + (t2 - t1));
    }
}
