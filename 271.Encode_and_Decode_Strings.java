// m is the sum of lengths of all the strings 
// n is the number of strings
// k is the average length of all teh strings
// m ~ k * n
// header size: 4 ~ log(k)
// header overhead: n * 4 ~ n * log(k)
// time: 
//       encode -> O(m + n*4) ~ O(n * (k+log(k))
//       decode -> same
// space: 
//       encode -> O(m + n*4) ~ O(n * (k+log(k))
//       decode -> same
// basically O(m) or O(nk)
public class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> out = new ArrayList<>();
        int i=0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            i = j+1;
            j = i+len;
            out.add(str.substring(i, j));
            i = j;
        }
        return out;
    }
}
