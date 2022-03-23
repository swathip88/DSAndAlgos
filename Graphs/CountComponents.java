class CountComponents {
    //https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/submissions/
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            unionFind.union(A, B);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(unionFind.find(i));
        }
        
        return set.size();
    }
}

class UnionFind {
    
    private int[] parent;
    
    // For efficiency, we aren't using makeset, but instead initialising
    // all the sets at the same time in the constructor.
    public UnionFind(int n) {
        parent = new int[n];
        for (int node = 0; node < n; node++) {
            parent[node] = node;
        }
    }
    
    // The find method, without any optimizations. It traces up the parent
    // links until it finds the root node for A, and returns that root.
    public int find(int A) {
        while (parent[A] != A) {
            A = parent[A];
        }
        return A;
    }

    // The union method, without any optimizations. It returns True if a
    // merge happened, False if otherwise.
    public boolean union(int A, int B) {
        // Find the roots for A and B.
        int rootA = find(A);
        int rootB = find(B);
        // Check if A and B are already in the same set.
        if (rootA == rootB) {
            return false;
        }
        // Merge the sets containing A and B.
        parent[rootA] = rootB;
        return true;
    } 
}
