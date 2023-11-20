class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y-x);
        for (int s : stones) {
            maxHeap.add(s);
        }
        while (maxHeap.size() > 1) {
            int y = maxHeap.remove();
            int x = maxHeap.remove();
            if (x != y) {
                maxHeap.add(y-x);
            }
        }
        return maxHeap.size()==0 ? 0 : maxHeap.peek();
    }
}
