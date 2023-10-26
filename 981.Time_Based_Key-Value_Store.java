class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if (map.containsKey(key)) {
            List<Pair> items = map.get(key);
            int start = 0;
            int end = items.size()-1;
            while(start <= end) {
                int mid = (start+end)/2;
                if (items.get(mid).timestamp > timestamp) {
                    end = mid-1;
                } else if (items.get(mid).timestamp <= timestamp) {
                    res = items.get(mid).value;
                    start = mid+1;
                }
            }
        }
        return res;
    }
}

class Pair {
    String value;
    int timestamp;
    public Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
