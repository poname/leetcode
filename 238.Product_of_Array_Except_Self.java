class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeros = 0;
        int lastZeroIndex = -1;
        int[] out = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
                lastZeroIndex = i;
            }
        }
        if (zeros > 1) {
            return out;
        } else if (zeros == 1) {
            int prod = 1;
            for (int n : nums) {
                if (n != 0) {
                    prod *= n;
                }
            }
            out[lastZeroIndex] = prod;
            return out;
        } else {
            int[] pref = new int[nums.length];
            int[] suff = new int[nums.length];
            int pre = 1;
            int suf = 1;
            for (int i=0; i<nums.length; i++) {
                pre *= nums[i];
                pref[i] = pre;
                suf *= nums[nums.length-1-i];
                suff[nums.length-1-i] = suf;
            }
            for (int i=0; i<nums.length; i++) {
                out[i] = (i>0 ? pref[i-1] : 1) * (i<nums.length-1 ? suff[i+1] : 1);
            }
            return out;
        }
    }
}
