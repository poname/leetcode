// time: O(n)
// space: O(1)
class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int max = 0;
        while (l<r) {
            max = Math.max(max, Math.min(height[l], height[r])*(r-l));
            if (height[r] < height[l]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
