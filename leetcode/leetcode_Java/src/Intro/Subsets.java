
package Intro;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }

        }
        return result;
    }
	
	public static void main(String[] args) {
	    Subsets solution = new Subsets();
	    int[] nums = {1, 2, 3};
	    List<List<Integer>> subsets = solution.subsets(nums);

	    System.out.println("Subsets:");
	    for (List<Integer> subset : subsets) {
	        System.out.println(subset);
	    }
	}

}
