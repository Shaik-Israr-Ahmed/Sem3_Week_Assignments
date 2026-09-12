import java.util.Scanner;

public class FindMinimumRotatedArray {

```
static int findMin(int[] nums) {

    int left = 0;
    int right = nums.length - 1;

    while (left < right) {

        int middle = left + (right - left) / 2;

        if (nums[middle] > nums[right]) {

            left = middle + 1;

        } else {

            right = middle;
        }
    }

    return nums[left];
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

    int answer = findMin(nums);

    System.out.println("Minimum element: " + answer);

    sc.close();
}
```

}
