class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        //Check for obstacles at start or end positions.
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0; // No path if start or end is blocked
        }

        Deque<int[]> queue = new ArrayDeque<>();
        int[][] distances = new int[n][n];
        final int INF = 1 << 30;

        // Initialize distances to "infinity"
        for (int[] distanceRow : distances) {
            Arrays.fill(distanceRow, INF);
        }

        // Initial distance for all obstacles set to 0 and added to queue
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid.get(i).get(j) == 1) {
                    distances[i][j] = 0;
                    queue.offer(new int[] {i, j});
                }
            }
        }

        //Directions for up, right, down, left traversal
        int[] directionDeltas = {-1, 0, 1, 0, -1};

        //Perform a multi-source BFS to find shortest distance to obstacles for each cell
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int i = position[0], j = position[1];
            for (int k = 0; k < 4; ++k) {
                int x = i + directionDeltas[k], y = j + directionDeltas[k + 1];
                if (x >= 0 && x < n && y >= 0 && y < n && distances[x][y] == INF) {
                    distances[x][y] = distances[i][j] + 1;
                    queue.offer(new int[] {x, y});
                }
            }
        }

        //Store each cell as [distance, row, column]
        List<int[]> sortedCellsByDistance = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                sortedCellsByDistance.add(new int[] {distances[i][j], i, j});
            }
        }

        //Sort cells by distance in descending order
        sortedCellsByDistance.sort((a, b) -> Integer.compare(b[0], a[0]));

        UnionFind unionFind = new UnionFind(n * n);

        //Try to connect cells starting with the safest (largest distance)
        for (int[] cell : sortedCellsByDistance) {
            int distance = cell[0], i = cell[1], j = cell[2];
            for (int k = 0; k < 4; ++k) {
                int x = i + directionDeltas[k], y = j + directionDeltas[k + 1];
                if (x >= 0 && x < n && y >= 0 && y < n && distances[x][y] >= distance) {
                    unionFind.union(i * n + j, x * n + y);
                }
            }
            //Check if start is connected to end
            if (unionFind.find(0) == unionFind.find(n * n - 1)) {
                return distance;
            }
        }
        return 0; //if no path is found
    }
}

class UnionFind {
    private int[] parents;
    private int count;

    public UnionFind(int totalNodes) {
        parents = new int[totalNodes];
        for (int i = 0; i < totalNodes; ++i) {
            parents[i] = i; //Each node is its own parent at the begining
        }
        this.count = totalNodes;
    }

    public boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) {
            return false;
        }
        parents[parentA] = parentB;
        --count;
        return true;
    }
    public int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
}