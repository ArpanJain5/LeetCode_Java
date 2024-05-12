class Solution {
    public static int maxElement(int grid[][], int row, int col)
    {
        int element=0;
        for( int i=row; i<row+3; i++)
        {
            for( int j=col; j<col+3; j++)
            {
                element=Math.max(element, grid[i][j]);
            }
        }
        return element;
    }
    public int[][] largestLocal(int[][] grid) {
        int localMatrix [][]=new int [grid.length-2][grid.length-2];
        for( int i=0; i<grid.length-2; i++)
        {
            for(int j=0; j<grid.length-2; j++)
            {
                localMatrix[i][j]=maxElement(grid, i, j);
            }
        }
        return localMatrix;
    }
}