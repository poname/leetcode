// sort + stack
// time: O(nlog(n))
// space: O(n)
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] map = new int[n][2];
        for (int i=0; i<n; i++) {
            map[i][0] = position[i];
            map[i][1] = speed[i];
        }
        Arrays.sort(map, (a,b) -> b[0]-a[0]);
        Stack<Double> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            double time = (double)(target-map[i][0])/(double)map[i][1];
            if (stack.empty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        return stack.size();
    }
}

// sort + iteration
// time: O(nlog(n))
// space: O(n)
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] map = new int[n][2];
        for (int i=0; i<n; i++) {
            map[i][0] = position[i];
            map[i][1] = speed[i];
        }
        Arrays.sort(map, (a,b) -> b[0]-a[0]);
        int fleet = 0;
        double prev = 0.0;
        for (int i=0; i<n; i++) {
            double time = (double)(target-map[i][0])/(double)map[i][1];
            if (fleet == 0 || time > prev) {
                fleet++;
                prev = time;
            }
        }
        return  fleet;
    }
}

// iteration
// time: O(target)
// space: O(target)
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] time = new double[target];
        for (int i=0; i<n; i++) {
            time[position[i]] = (double)(target-position[i])/(double) speed[i];
        }
        int fleet = 0;
        double prev = 0.0;
        for (int i=time.length-1; i>=0; i--) {
            if (time[i] > prev) {
                fleet++;
                prev = time[i];
            }
        }
        return fleet;
    }
}
