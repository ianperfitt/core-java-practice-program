class Solution {

	public static String reverseWords(String s) {
	     char[] stringArray = s.toCharArray();
	     int left = 0;
	     int right = 0;
	     char temp = 'a';

	     for(int i = 0; i < stringArray.length; i++) {
	        if(i + 1 == stringArray.length || stringArray[i + 1] == ' ') {
	            // set right pointer without losing track of loop index
	            right = i;
	            while(left < right) {
	                // swap all characters in word
	                temp = stringArray[left];
	                stringArray[left] = stringArray[right];
	                stringArray[right] = temp;
	                ++left;
	                --right;
	            }
	            // position new left one past each space
	            left = i + 2;
	            }
	        }
	        return new String(stringArray);   
	    }
}