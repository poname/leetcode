class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();
        wordList.add(beginWord);
        for (int i=0; i<wordList.size(); i++) {
            String word_i = wordList.get(i);
            graph.putIfAbsent(word_i, new HashSet<>());
            for (int j=i; j<wordList.size(); j++) {
                String word_j = wordList.get(j);
                graph.putIfAbsent(word_j, new HashSet<>());
                if (check(word_i, word_j)) {
                    graph.get(word_i).add(word_j);
                    graph.get(word_j).add(word_i);
                }
            }
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        int step = 0;
        while (q.size() > 0) {
            int curLen = q.size();
            step++;
            for (int k=0; k<curLen; k++) {
                String top = q.remove();
                if (top.equals(endWord)) {
                    return step;
                }
                for (String nei : graph.get(top)) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        q.add(nei);
                    }
                }
            }
        }
        return 0;
    }
    boolean check(String a, String b) {
        int diff = 0;
        for (int i=0; i<a.length(); i++) {
            diff += a.charAt(i) == b.charAt(i) ? 0 : 1;
        }
        return diff == 1;
    }
}
