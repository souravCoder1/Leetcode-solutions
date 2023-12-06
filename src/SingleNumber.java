import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        int nums[] = new int []{11,2,11,2,4};
        singleElement3(nums);
    }

    static void singleElement1(int nums[]) {
        boolean visited[] = new boolean[nums.length];
        -Arrays.fill(visited, false);

        for (int i = 0; i < nums.length; i++) {
            int count = 1; // count of number of occurences
            if (visited[i] == true)
                continue;

            for (int j = i + 1; j < nums.length; j++) { // n - 1
                if (nums[i] == nums[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(nums[i]+"  ->  "+count);
            if (count%2 != 0) {
                System.out.println("Result:: "+nums[i]);
                //System.exit(0);
                return;
            }
        }
    }

    static void singleElement2(int nums[]) {
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            //if key in present in the array, then increment count
            if (hMap.containsKey(nums[i])) {
                int count = hMap.get(nums[i]) + 1;
                hMap.put(nums[i], count);
            } else {
                hMap.put(nums[i], 1);
            }
        }
    }

    //assignment: solve this problem using the xor method (best solution)
    //if you XOR similar element it is zero. otherwise it is 1.
    static void singleElement3(int nums[]) {
        //int missing = nums.length;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            //missing ^= i ^ nums[i];
             result ^= nums[i];
        }
        System.out.println("Result:: "+result);
        //return missing;
    }

}
