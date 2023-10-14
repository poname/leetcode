class NumArray {

    int[] prefSum;

    public NumArray(int[] nums) {
        prefSum = new int[nums.length];
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            prefSum[i] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return prefSum[right] - (left==0 ? 0 :  prefSum[left-1]);
    }
}
