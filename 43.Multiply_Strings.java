class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String in1 = num1;
        String in2 = num2;
        int[] sum = new int[in1.length() + in2.length() + 1]; // + 1 for dummy carry in

        for (int i=in1.length()-1; i>=0; i--) {
            for (int j=in2.length()-1; j>=0; j--) {
                sum[i+j+1] += (in1.charAt(i)-'0') * (in2.charAt(j)-'0') + sum[i+j+2]/10; // pick carry from prev digit
                sum[i+j+2] %= 10; // set prev digit to single digit sum
            } 
        }
        // System.out.println(Arrays.toSt)
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<sum.length; i++) {
            if (i<sum.length-1 || sum[i]!=0) {
                sb.append(sum[i]);
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String in1 = num1;
        String in2 = num2;
        if (num1.length() < num2.length()) {
            in2 = num1;
            in1 = num2;
        }
        String sum = "";
        for (int i=0; i<in2.length(); i++) {
            sum = sum(sum+"0", mul(in1, in2.charAt(i)-'0'));
        }
        return sum;
    }
    private String mul(String in, int x) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=in.length()-1; i>=0; i--) {
            int s = (in.charAt(i)-'0')*x + carry;
            char sum = '0';
            sum += s%10;
            carry = s / 10;
            sb.append(sum);
        }
        if (carry > 0) {
            char sum = '0';
            sum += carry;
            sb.append(sum);
        }
        // System.out.println(Arrays.toString(in) + "*" + x + "=" + sb.reverse().toString());
        return sb.reverse().toString();
    }
    private String sum(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i>=0 && j>=0) {
            int s = (a.charAt(i)-'0') + (b.charAt(j)-'0') + carry;
            char sum = '0';
            sum += s%10;
            carry = s / 10;
            sb.append(sum);
            i--;
            j--;
        }
        while (i>=0) {
            int s = (a.charAt(i)-'0') + carry;
            char sum = '0';
            sum += s%10;
            carry = s / 10;
            sb.append(sum);
            i--;
        }
        while (j>=0) {
            int s = (b.charAt(j)-'0') + carry;
            char sum = '0';
            sum += s%10;
            carry = s / 10;
            sb.append(sum);
            j--;
        }
        if (carry > 0) {
            char sum = '0';
            sum += carry;
            sb.append(sum);
        }
        // System.out.println(a + "+" + b + "=" + sb.reverse().toString());
        return sb.reverse().toString();
    }
}
