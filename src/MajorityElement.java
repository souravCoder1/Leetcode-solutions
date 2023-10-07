import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int arr[] = new int[]{3,2,3};
        int n = arr.length;
        //countFreq(arr);
        solution2(arr);
        solutionMap(arr);

    }

    private static void solutionMap(int[] arr) {
    }

    // 2,3,3
    private static void solution2(int arr[]) {
        Arrays.sort(arr);
        //Arrays.stream(arr).forEach(System.out::println);
        System.out.println(arr[arr.length/2]);
    }

    public static void countFreq(int[] arr) {
        boolean visited[] = new boolean[arr.length];
        Arrays.fill(visited, false);

        for (int i = 0; i < arr.length; i++) { // n
            int count = 1;
            if(visited[i] == true)
                continue; // skip

            for (int j = i + 1; j< arr.length; j++) { // n - 1
                if(arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " " + count);
        }
    }


}
    // Time Complexity : O(n2)
    //  Auxiliary Space : O(n)