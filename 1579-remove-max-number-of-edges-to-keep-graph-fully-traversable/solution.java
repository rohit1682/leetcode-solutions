class Solution {
    /**
     * UnionFind class to manage the connected components using Union-Find data structure.
     */
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufA = new UnionFind(n + 1); // Union-Find for Alice
        UnionFind ufB = new UnionFind(n + 1); // Union-Find for Bob
        int edgesAdded = 0; // variable to count the number of edges added to form fully traversable graphs

        // Process Type 3 edges (usable by both Alice and Bob)
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (ufA.union(edge[1], edge[2])) {
                    ufB.union(edge[1], edge[2]);
                    edgesAdded++;
                }
            }
        }

        // Process Type 1 and Type 2 edges (specific to Alice or Bob)
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (ufA.union(edge[1], edge[2])) {
                    edgesAdded++;
                }
            } else if (edge[0] == 2) {
                if (ufB.union(edge[1], edge[2])) {
                    edgesAdded++;
                }
            }
        }

        // Check connectivity for Alice and Bob
        int componentsA = 0, componentsB = 0;
        for (int i = 1; i <= n; i++) {
            if (ufA.find(i) == i) componentsA++;
            if (ufB.find(i) == i) componentsB++;
        }

        // If either Alice or Bob cannot traverse the entire graph, return -1
        if (componentsA != 1 || componentsB != 1) {//If comp>1 means graph has more than 1 component 
            return -1;
        }

        // Calculate the maximum number of removable edges
        return edges.length - edgesAdded;
    }
}