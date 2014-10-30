package datastruct.dynamic.programming;

public class LongIncreasingSequence {

	static Integer max_ref = 1;

	/* Driver program to test above function */
	public static void main(String[] args) {
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
		int n = arr.length;
		lis(arr, n);
		System.out.println("Length of LIS is  >>" + max_ref);
	}

	// The wrapper function for _lis()
	public static void lis(int arr[], int n) {
		// The max variable holds the result


		// The function _lis() stores its result in max
		_lis(arr, n);

		// returns max
	}


	public static Integer _lis(int arr[], int n) {
		System.out.println("Invoking lis with input >> " + n);
		/* Base case */
		if (n == 1) return 1;

		int res, max_ending_here = 1; // length of LIS ending with arr[n-1]

		/** Recursively get all LIS ending with arr[0], arr[1] ... ar[n-2]. If
		 arr[i-1] is smaller than arr[n-1], and max ending with arr[n-1] needs
		 to be updated, then update it */
		for (int i = 1; i < n; i++) {
			res = _lis(arr, i);
			if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}

		// Compare max_ending_here with the overall max. And update the
		// overall max if needed
		if (max_ref < max_ending_here) max_ref = max_ending_here;

		// Return length of LIS ending with arr[n-1]
		return max_ending_here;
	}


}
