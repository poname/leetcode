// time: O(n)
// space: O(n)
// bucket sort
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.putIfAbsent(n, 0);
            map.computeIfPresent(n, (a,b) -> b+1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (bucket[e.getValue()] == null) {
                bucket[e.getValue()] = new ArrayList<>();
            }
            bucket[e.getValue()].add(e.getKey());
        }
        int[] out = new int[k];
        for (int i=nums.length; i>0; i--) {
            if (bucket[i] != null) {
                for (int j=0; j<bucket[i].size(); j++) {
                    out[--k] = bucket[i].get(j);
                    if (k==0) {
                        return out;
                    }
                }
                
            }
        }
        return out;
    }
}
// reverse map
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.putIfAbsent(n, 0);
            map.computeIfPresent(n, (a,b) -> b+1);
        }
        Map<Integer, List<Integer>> rev = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            rev.putIfAbsent(e.getValue(), new ArrayList<>());
            rev.get(e.getValue()).add(e.getKey());
        }
        int[] out = new int[k];
        for (int i=nums.length; i>0; i--) {
            if (rev.containsKey(i)) {
                for (int j=0; j<rev.get(i).size(); j++) {
                    out[--k] = rev.get(i).get(j);
                    if (k==0) {
                        return out;
                    }
                }
                
            }
        }
        return out;
    }
}

// time: O(nlog(k))
// space: O(n+k)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.putIfAbsent(n, 0);
            map.compute(n, (key, val) -> val+1);
        }
        Queue<int[]> minH = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            minH.add(new int[]{e.getKey(), e.getValue()});
            if (minH.size() > k) minH.poll(); // this line gurantees the above line to remain log(k) instead of log(n)
        }
        int[] out = new int[k];
        for (int[] e : minH) {
            out[--k] = e[0];
        }
        return out;
    }
}

// time: O(n + klog(n))
// space: O(n+k)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> maxH = new PriorityQueue<>(
                (a, b) -> count.get(b) - count.get(a));
        maxH.addAll(count.keySet());
        int[] out = new int[Math.min(maxH.size(), k)];
        for (int i = 0; i < out.length; i++) {
            out[i] = maxH.poll();
        }
        return out;
    }
}

// sort
// time: O(nlog(n))
// space: O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.putIfAbsent(n ,0);
            map.compute(n, (key,val) -> val+1);
        }
        int[][] count = new int[map.size()][2];
        int idx =0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            count[idx][0] = e.getKey();
            count[idx][1] = e.getValue();
            idx++;
        }
        Arrays.sort(count, (a, b) -> b[1]-a[1]);
        int[] out = new int[k];
        for (int i=0; i<k; i++) {
            out[i] = count[i][0];
        }
        return out;
    }
}
