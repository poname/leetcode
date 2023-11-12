class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        String pal = "";
        for (int i=0; i<n; i++) {

            // odd length
            int l=i;
            int r=i;
            while(l>=0 && r<n && s.charAt(r)==s.charAt(l)) {
                if (r-l+1 > max) {
                    max = r-l+1;
                    pal = s.substring(l, r+1);
                }
                r++;
                l--;
            }

            // even length
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(r)==s.charAt(l)) {
                if (r-l+1 > max) {
                    max = r-l+1;
                    pal = s.substring(l, r+1);
                }
                r++;
                l--;
            }
        }
        return pal;
    }
}
