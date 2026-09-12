import java.util.Scanner;
import java.util.Arrays;

public class ThreeSum {

```
static int[][] threeSum(int[] nums) {

    Arrays.sort(nums);

    int n = nums.length;
    int[][] temp = new int[n * n][3];
    int count = 0;

    for (int i = 0; i < n - 2; i++) {

        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }

        if (nums[i] > 0) {
            break;
        }

        int left = i + 1;
        int right = n - 1;

        while (left < right) {

            int sum = nums[i] + nums[left] + nums[right];

            if (sum == 0) {

                temp[count][0] = nums[i];
                temp[count][1] = nums[left];
                temp[count][2] = nums[right];

                count++;

                left++;
                right--;

                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }

                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }

            } else if (sum < 0) {

                left++;

            } else {

                right--;
            }
        }
    }

    int[][] result = new int[count][3];

    for (int i = 0; i < count; i++) {
        result[i][0] = temp[i][0];
        result[i][1] = temp[i][1];
        result[i][2] = temp[i][2];
    }

    return result;
}

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter array size: ");
    int n = sc.nextInt();

    int[] nums = new int[n];

    System.out.println("Enter array elements:");

    for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
    }

    int[][] result = threeSum(nums);

    System.out.print("Output: [");

    for (int i = 0; i < result.length; i++) {

        System.out.print("[");

        for (int j = 0; j < 3; j++) {

            System.out.print(result[i][j]);

            if (j < 2) {
                System.out.print(", ");
            }
        }

        System.out.print("]");

        if (i < result.length - 1) {
            System.out.print(", ");
        }
    }

    System.out.println("]");

    sc.close();
}
```

}

