import java.util.Arrays;

public class LinearSearchVSBinarySearch {

    // Method to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Create a boolean array to track the presence of integers from 1 to n
        boolean[] present = new boolean[n + 1];

        // Mark the present numbers in the boolean array
        for (int num : nums) {
            if (num > 0 && num <= n) {
                present[num] = true; // Mark that number as present
            }
        }

        // Find the first number which is not marked in the array
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i; // Return the first missing positive integer
            }
        }

        return n + 1; // If all numbers from 1 to n are present, return n + 1
    }

    // Method to perform Binary Search for a target number
    public static int binarySearch(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array before Binary Search
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Return index if found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return -1; // Target not found
    }

    // Main method to test the functions
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1}; // Example list of integers
        int target = 4; // Target value to search

        // Finding first missing positive integer
        int missingNumber = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + missingNumber);

        // Finding the index of target using Binary Search
        int targetIndex = binarySearch(nums, target);
        System.out.println("Index of target " + target + " after sorting: " + targetIndex);
    }
}
