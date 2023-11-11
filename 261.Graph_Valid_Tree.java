public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
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
            if (a == b) { // cycle
                return false;
            }
            comp--;
            if (rank[a] > rank[b]) {
                parent[b] = a;
                rank[a] += rank[b];
            } else {
                parent[a] = b;
                rank[b] += rank[a];
            }
        }
        return comp==1; // tree
    }
}
