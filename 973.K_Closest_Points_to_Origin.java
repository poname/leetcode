class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>(k, (a,b) -> (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        for (int[] p : points) {
            minHeap.add(p);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        int[][] arr = new int[k][2];
        int i = 0;
        for (int[] c : minHeap) {
            arr[i][0] = c[0];
            arr[i][1] = c[1];
            i++;
        }
        return arr;
    }
}
