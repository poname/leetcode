// min heap
// time: O(n + nlog(k) + klog(k) + k) -> O(nlog(k))
// space: O(n + k) -> O(n)
// note: if we consider O(m) for compareTo then:
// time: O(n + nlog(k)*m + klog(k)*m + k) -> O(mnlog(k))
// space: O(nm + km) -> O(mn)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // O(n) memory
        Map<String, Integer> map = new HashMap<>();
        // O(n)
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        // O(k) memory
        Queue<String> minH = new PriorityQueue<>(
                (a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));
        // O(nlog(k))  
        for (String s : map.keySet()) {
            minH.add(s);
            if (minH.size() > k)
                minH.poll();
        }
        List<String> out = new ArrayList<>();
        // O(klog(k))
        while (minH.size() > 0) {
            out.add(minH.poll());
        }
        // O(k)
        Collections.reverse(out);
        return out;
    }
}

// max heap
// time: O(n + n + klog(n)) -> O(n + klog(n))
// space: O(n + n) -> O(n)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // O(n) memory
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        // O(n) memory
        Queue<String> maxH = new PriorityQueue<>(
                (a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));
        maxH.addAll(map.keySet());
        List<String> out = new ArrayList<>();
        for (int i = 0; i < Math.min(k, map.size()); i++) {
            out.add(maxH.poll());
        }
        return out;
    }
}

// sorting
// time: O(n + nlog(n) + k) -> O(nlog(n))
// space: O(n + n) -> O(n)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // O(n) memory
        Map<String, Integer> map = new HashMap<>();
        // O(n)
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        // O(n) memory
        List<String> items = new ArrayList<>(map.keySet());
        // O(nlog(n))
        items.sort((a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));
        List<String> out = new ArrayList<>();
        // O(k)
        for (int i = 0; i < Math.min(k, items.size()); i++) {
            out.add(items.get(i));
        }
        return out;
    }
}
