import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3};
        int n = arr.length;
        //solution2(arr)
        //System.out.println(countFreq(arr));
        System.out.println(solutionMap(arr));

        mooreVoting(arr);

    }

    /**
     * This is a two-step process:
     *
     * The first step gives the element that may be the majority element in the array.
     * If there is a majority element in an array, then this step will definitely return majority element,
     * otherwise, it will return candidate for majority element.
     *
     * Check if the element obtained from the above step is the majority element.
     * This step is necessary as there might be no majority element.
     * @param arr
     */
    private static void mooreVoting(int[] arr) {
        int count = 0, candidate = -1;
 
        // Finding majority candidate
        for (int index = 0; index < nums.length; index++) {
          if (count == 0) {
            candidate = nums[index];
            count = 1;
          }
          else {
            if (nums[index] == candidate)
              count++;
            else
              count--;
          }
        }
 
        // Checking if majority candidate occurs more than
        // n/2 times
        count = 0;
        for (int index = 0; index < nums.length; index++) {
          if (nums[index] == candidate)
            count++;
        }
        if (count > (nums.length / 2))
          return candidate;
        return -1;   
    }

    private static int solutionMap(int[] nums) {
        Map<Integer, Integer> hMap = new HashMap<>();
        /*for (int i = 0; i< arr.length; i++) {
                if (hMap.containsKey(arr[i])) {
                    int count = hMap.get(arr[i]) + 1;
                    hMap.put(arr[i], count);
                } else {
                    hMap.put(arr[i], 1);
                }
        }*/
        for (int num : nums) { //O(N)
            hMap.put(num, hMap.getOrDefault(num, 0) + 1);
        }

        System.out.println(hMap);
        
        /*for (int i = 0; i < arr.length; i++) { // 3,2 ,3
            if (hMap.get(arr[i]) > arr.length/2 ) {
                return arr[i];
            }
        }*/
        for (int num : hMap.keySet()) { // 3,2,3 // O(N)
            if (hMap.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }
    // Time and Space: O(N)

    /**
     * The idea is to sort the array. Sorting makes similar elements in the array adjacent,
     * so traverse the array and update the count until the present element is similar to the previous one.
     * If the frequency is more than half the size of the array, print the majority element.
     *
     * @param arr
     */
    // 2,3,3
    private static void solution2(int arr[]) {
        Arrays.sort(arr);
        //Arrays.stream(arr).forEach(System.out::println);
        System.out.println(arr[arr.length / 2]);
    }

    /**
     * The basic solution is to have two loops and keep track of the maximum count for all different elements.
     * If the maximum count becomes greater than n/2 then break the loops and return the element having the maximum count.
     * If the maximum count doesn’t become more than n/2 then the majority element doesn’t exist.
     *
     * @param arr
     * @return
     */
    public static int countFreq(int[] arr) {
        boolean visited[] = new boolean[arr.length];
        Arrays.fill(visited, false);

        for (int i = 0; i < arr.length; i++) { // n
            int count = 1;
            if (visited[i] == true)
                continue; // skip

            for (int j = i + 1; j < arr.length; j++) { // n - 1
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " " + count);
            if (count > arr.length / 2) {
                return arr[i];
            }
        }
        return -1;
    }


}
// Time Complexity : O(n^2)
//  Auxiliary Space : O(n)
