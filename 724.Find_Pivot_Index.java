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
