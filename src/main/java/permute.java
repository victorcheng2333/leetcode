import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class permute {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsArray = new ArrayList<>();
        for (int num : nums) numsArray.add(num);
        permuteRec(numsArray, 0, result);
        return result;
    }

    void permuteRec(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
        } else {
            for (int i = start; i < nums.size(); ++i) {
                Collections.swap(nums, i, start);
                permuteRec(nums, start + 1, result);
                Collections.swap(nums, i, start);
            }
        }
    }
}
