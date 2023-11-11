class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        Set<Integer> path = new HashSet<>();
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int i=0; i<numCourses; i++) {
            adj.put(i, new HashSet<>());
        }
        for (int[] e : prerequisites) {
            adj.get(e[0]).add(e[1]);
        }
        for (int i=0; i<numCourses; i++) {
            if(!dfs(i, visited, adj)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int node, boolean[] visited, Map<Integer, Set<Integer>> adj) {
        if (visited[node]) {
            return false;
        }
        if (adj.get(node).size()==0) {
            return true;
        }
        visited[node] = true;
        for (int child : adj.get(node)) {
            if (!dfs(child, visited, adj)) {
                return false;
            }
        }
        adj.get(node).clear();
        visited[node] = false;
        return true;
    }
}
