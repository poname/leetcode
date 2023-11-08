public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()+":");
            sb.append(s);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> strs = new ArrayList<>();
        while (str.length() > 0) {
            int idx = str.indexOf(":");
            int len = Integer.valueOf(str.substring(0, idx));
            strs.add(str.substring(idx+1, idx+1+len));
            str = str.substring(idx+len+1);
        }
        return strs;
    }
}
