class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((x,y) -> Integer.compare(y,x));
        Map<Integer, Integer> counter = new HashMap<>();
        int[] res = new int[nums.length-k+1];
        for (int i=0; i<nums.length; i++) {
            counter.putIfAbsent(nums[i], 0);
            counter.computeIfPresent(nums[i], (key,v) -> v+1);
            maxHeap.add(nums[i]);
            if (i >= k-1) {
                while (counter.get(maxHeap.peek()) < 1) {
                    maxHeap.remove();
                }
                res[i-k+1] = maxHeap.peek();
                counter.computeIfPresent(nums[i-k+1], (key,v) -> v-1);
            }
        }
        return res;
    }
}
