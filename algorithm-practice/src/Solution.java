class Solution {
    public static double findMaxAverage(int[] nums, int k) {
    	int left = 0;
        int right = k;
        int n = nums.length;
        double solution = 0;
        while (right < n) {
            double average = 0;
            for(int i = left; i < right; i++) {
                average = average + nums[i];
            }
            solution = Math.max(solution, average / k);
            ++left;
            ++right;
        }
        return solution;
    }
    
    public static void main(String[] args) {
    	int [] nums = {1,12,-5,-6,50,3};
		System.out.println(findMaxAverage(nums, 4));
	}
}