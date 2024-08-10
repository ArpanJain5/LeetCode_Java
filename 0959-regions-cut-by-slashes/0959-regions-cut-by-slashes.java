class Solution {
    private int n;
    enum Position {
        TOP, LEFT, BOTTOM, RIGHT;
    }
    private int index(int i, int j, Position position) {
        if (position == Position.LEFT || position == Position.RIGHT) {
            return (n + i) * (n + 1) + j + (position == Position.RIGHT ? 1 : 0);
        }
        return j * (n + 1) + i + (position == Position.BOTTOM ? 1 : 0);
    }
    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        var grids = 2 * n * (n + 1);
        var set = new UnionFindSet(grids);
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                switch (grid[i].charAt(j)) {
                    case '/':
                        set.union(index(i, j, Position.TOP), index(i, j, Position.LEFT));
                        set.union(index(i, j, Position.BOTTOM), index(i, j, Position.RIGHT));
                        break;
                    case '\\':
                        set.union(index(i, j, Position.TOP), index(i, j, Position.RIGHT));
                        set.union(index(i, j, Position.BOTTOM), index(i, j, Position.LEFT));
                        break;
                    default:
                        set.union(index(i, j, Position.TOP), index(i, j, Position.LEFT));
                        set.union(index(i, j, Position.LEFT), index(i, j, Position.BOTTOM));
                        set.union(index(i, j, Position.BOTTOM), index(i, j, Position.RIGHT));
                }
            }
        }
        return set.groups();
    }
}
class UnionFindSet {
    private int[] data;
    private int groups;
    public UnionFindSet(int size) {
        data = new int[size];
        for (var i = 0; i < size; i++) {
            data[i] = i;
        }
        groups = size;
    }
    public boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return false;
        }
        data[b] = a;
        groups--;
        return true;
    }
    public int find(int x) {
        if (data[x] == x) {
            return x;
        }
        return data[x] = find(data[x]);
    }
    public int groups() {
        return groups;
    }
}