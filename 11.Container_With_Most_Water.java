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

// Brute-Force
// time: O(n^2)
// space: O(1)
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }
}
