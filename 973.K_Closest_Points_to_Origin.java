class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>(k, (a,b) -> (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        for (int[] p : points) {
            maxHeap.add(p);
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        int[][] arr = new int[k][2];
        int i = 0;
        for (int[] c : maxHeap) {
            arr[i][0] = c[0];
            arr[i][1] = c[1];
            i++;
        }
        return arr;
    }
}
