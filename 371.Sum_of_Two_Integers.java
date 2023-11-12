class Solution {
    public int getSum(int a, int b) {
        int sum = 0;
        int c = 0;
        for (int i=0; i<32; i++) {
            int x = (a>>>i)&1;
            int y = (b>>>i)&1;
            int s = x ^ y ^ c;
            c = (x&c) | (y&c) | (x&y);
            sum |= s << i;
        }
        return sum;
    }
}
