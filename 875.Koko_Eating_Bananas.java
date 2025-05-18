// faster
// time: O(nlog(m))
// space : O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int p : piles) {
            max = Math.max(max, p);
        }
        int min = 1;
        int k = max;
        while (min <= max) {
            int mid = (min + max) / 2;
            long time = 0;
            for (int p : piles) {
                time += (p + mid - 1) / mid;
            }
            if (time <= h) {
                k = Math.min(k, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return k;
    }
}

// time: O(nlog(m))
// space : O(1)
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
