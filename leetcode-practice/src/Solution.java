class Solution {

	public static int getCommon(int[] nums1, int[] nums2) {

		// nums1 pointer
		int i = 0;
		// nums2 pointer
		int j = 0;
		int MIN_VAL = Integer.MAX_VALUE;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] != nums2[j] && nums1[i] < nums2[j]) {
				++i;
				continue;
			} else if (nums1[i] != nums2[j] && nums1[i] > nums2[j]) {
				++j;
				continue;
			}
			// nums1[i] & nums2[j] are equal
			// so check if val is new min common int
			else if (nums1[i] < MIN_VAL) {
				MIN_VAL = nums1[i];
			}
			++i;
			++j;
		}
		return MIN_VAL == Integer.MAX_VALUE ? -1 : MIN_VAL;
	}
}