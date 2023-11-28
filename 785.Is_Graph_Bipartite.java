class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] val = new int[n];
        for (int i=0; i<n; i++) {
            if (val[i]==0 && !bfs(i, graph, val)) {
                return false;
            }
        }
        return true;
    }
    private boolean bfs(int node, int[][] graph, int[] val) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        val[node] = 1; // odd
        while (q.size() > 0) {
            int top = q.remove();
            if (val[top] == 1) {
                for (int nei : graph[top]) {
                    if (val[nei] == 1) {
                        return false;
                    } else if (val[nei] == 0) {
                        val[nei] = 2;
                        q.add(nei);
                    } else {
                        // already visite and safe : 2
                    }
                }
            } else if (val[top] == 2) {
                for (int nei : graph[top]) {
                    if (val[nei] == 2) {
                        return false;
                    } else if (val[nei] == 0) {
                        val[nei] = 1;
                        q.add(nei);
                    } else {
                        // already visite and safe : 1
                    }
                }
            }
        }
        return true;
    }
}
