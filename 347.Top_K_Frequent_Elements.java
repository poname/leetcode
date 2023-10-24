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
