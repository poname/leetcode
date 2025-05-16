// 3 pass
// time: O(n)
// space: O(n)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] ltr = new int[n];
        int[] rtl = new int[n];
        int maxR = 0;
        for (int i=0; i<n; i++) {
            ltr[i] = maxR;
            maxR = Math.max(maxR, height[i]);
        }
        int maxL = 0;
        for (int i=n-1; i>=0; i--) {
            rtl[i] = maxL;
            maxL = Math.max(maxL, height[i]);
        }
        int vol = 0;
        for (int i=0; i<n; i++) {
            vol += Math.max(0, Math.min(rtl[i], ltr[i])-height[i]);
        }
        return vol;
    }
}

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] rain = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int maxL = 0;
        for (int i=0; i<n; i++) {
            leftMax[i] = maxL;
            maxL = Math.max(maxL, height[i]);
        }

        int maxR = 0;
        for (int i=n-1; i>=0; i--) {
            rightMax[i] = maxR;
            maxR = Math.max(maxR, height[i]);
        }

        for (int i=0; i<n; i++) {
            rain[i] = Math.max(0, Math.min(leftMax[i], rightMax[i])-height[i]);
        }

        int sum = 0;
        for (int r : rain) {
            sum += r;
        }
        return sum;
    }
}
