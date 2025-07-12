// time: O(nlog(k))
// space: O(k)
// add is O(log(k)), n adds in the constructor then at most n adds by user
class KthLargest {

    final Queue<Integer> minHeap;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int i: nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else {
            if (val > minHeap.peek()) {
                minHeap.remove();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
