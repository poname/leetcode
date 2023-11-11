public class Solution {
    /**
     * @param n: the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    public int countComponents(int n, int[][] edges) {
        // write your code here
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int comp = n;
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];

            while (a != parent[a]) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }

            while (b != parent[b]) {
                parent[b] = parent[parent[b]];
                b = parent[b];
            }

            if (a != b) {
                if (rank[a] > rank[b]) {
                    parent[b] = a;
                    rank[a] += rank[b];
                } else {
                    parent[a] = b;
                    rank[b] += rank[a];
                }  
                comp--;
            }
            
        }

        return comp;
    }
}

public class Solution {
    /**
     * @param n: the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    public int countComponents(int n, int[][] edges) {
        // write your code here
        int[] parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
        int comp = n;
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];

            while (a != parent[a]) {
                a = parent[a];
            }

            while (b != parent[b]) {
                b = parent[b];
            }

            if (a != b) {
                parent[b] = a;
                comp--;
            }
            
        }

        return comp;
    }
}

public class Solution {
    /**
     * @param n: the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    public int countComponents(int n, int[][] edges) {
        // write your code here
        List<Integer>[] adj = new ArrayList[n];
        for (int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        boolean[] visited = new boolean[n];
        int comp = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                comp++;
                dfs(i, visited, adj);
            }
        }
        return comp;
    }
    private void dfs(int node, boolean[] visited, List<Integer>[] adj) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int nei : adj[node]) {
            dfs(nei, visited, adj);
        }
    }
}
