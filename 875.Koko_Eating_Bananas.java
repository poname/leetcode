class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int kMin = 1;
        int kMax = piles[0];
        for (int p : piles) {
            kMax = Math.max(p, kMax);
        }
        int k = kMin;
        while (kMin <= kMax) {
            int kMid = (kMin+kMax)/2;
            int hour=0;
            for (int p : piles) {
                hour += Math.ceil(p/(double)kMid);
            }
            if (hour <= h) {
                k = kMid; // Math.min(k, kMid) is not necessary
                kMax = kMid-1;
            } else {
                kMin = kMid+1;
            }
        }
        return k;
    }
}
