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

// time: O(n)
// space: O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] post = new int[n];
        pref[0] = 1;
        for (int i=1; i<n; i++) {
            pref[i] = pref[i-1] * nums[i-1];
        }
        // [1, 1, 2, 6]
        post[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            post[i] = post[i+1] * nums[i+1];
        }
        // [24, 12, 4, 1]
        int[] out = new int[n];
        for (int i=1; i<n-1; i++) {
            out[i] = pref[i] * post[i];
        }
        out[0] = post[0];
        out[n-1] = pref[n-1];
        return out;
    }
}
