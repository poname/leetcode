class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] postSum = new int[n];
        int s=0;
        for(int i=n-1; i>=0; i--) {
            s += nums[i];
            postSum[i] = s;
            
        }
        s = 0;
        for(int i=0; i<n; i++) {
            s += nums[i];
            if (s == postSum[i]) {
                return i;
            }
        }
        return -1;
    }
}

class Solution {
    public int pivotIndex(int[] nums) {
        int ltr=0;
        for (int n : nums) {
            ltr += n;
        }

        int rtl=0;
        for (int i=0; i<nums.length; i++) {
            rtl += nums[i];
            if (rtl == ltr) {
                return i;
            }
            ltr -= nums[i];
        }

        return -1;
    }
}
