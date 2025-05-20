class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a, b;
        if (nums1.length < nums2.length) {
            a = nums1;
            b = nums2;
        } else {
            a = nums2;
            b = nums1;
        }
        int total = a.length + b.length;
        int half = total / 2;
        int l = 0, r = a.length - 1;
        while (true) {
            int i = (int) Math.floor((l + r) / 2.0); // !important (l+r)/2 will give 0 for -1/2 as opposed to python which gives -1 for -1//2 resulting in infinite loop 
            int j = half - i - 2;
            int leftA = i >= 0 ? a[i] : Integer.MIN_VALUE;
            int leftB = j >= 0 ? b[j] : Integer.MIN_VALUE;
            int rightA = i + 1 < a.length ? a[i + 1] : Integer.MAX_VALUE;
            int rightB = j + 1 < b.length ? b[j + 1] : Integer.MAX_VALUE;
            if (leftA <= rightB && leftB <= rightA) {
                if (total % 2 == 1) {
                    return Math.min(rightA, rightB);
                } else {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                }
            }
            if (leftA > rightB)
                r = i - 1;
            else
                l = i + 1;
        }
    }
}
