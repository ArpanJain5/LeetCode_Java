class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        sx = Math.abs(sx - fx);
        sy = Math.abs(sy - fy);
        if(sx == 0 && sy == 0)
            return t != 1;
        return Math.max(sx, sy) <= t;
    }
}