// fast/slow pointers
// time: O(log(n))
// space: O(1)
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while (fast != 1) {
            slow = op(slow);
            fast = op(op(fast));
            if (fast == slow)
                break;
        }
        return fast==1;
    }

    int op(int n) {
        int s = 0;
        while (n > 0) {
            int r = n % 10;
            n /= 10;
            s += r * r;
        }
        return s;
    }
}

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while (fast != 1) {
            slow = ssq(slow);
            fast = ssq(ssq(fast));
            if (slow == fast) {
                return fast==1;
            }
        }
        return fast==1;
    }
    int ssq(int n) {
        int s = 0;
        while (n > 0) {
            int d = n%10;
            s += d*d;
            n /= 10;
        }
        return s;
    }
}

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n) && n!=1) {
            set.add(n);
            n = ssq(n);
        }
        return n==1;
    }
    int ssq(int n) {
        int s = 0;
        while (n > 0) {
            int d = n%10;
            s += d*d;
            n /= 10;
        }
        return s;
    }
}
