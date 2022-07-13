public class NumberOfIsLand {

    private final int[][] grid;

    public NumberOfIsLand(int[][] grid){
        this.grid = grid;
    }
    public int numIsLands() {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isLand(grid[i][j], 1)) {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private boolean isLand(int i1, int i) {
        return i1 == i;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (!isValidCell(grid, row, col)) {
            return;
        }
        grid[row][col] = 0;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : directions) {
            dfs(grid, row + d[0], col + d[1]);
        }
    }

    private boolean isValidCell(int[][] grid, int row, int col) {
        try {
            return isLand(grid[row][col], 1);
        } catch (Exception e) {
            return false;
        }
    }


    public int numLands(int[][] grid) {
        int lands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isLand(grid[i][j], 1)) {
                    lands++;
                }
            }
        }
        return lands;
    }

    public int numWater(int[][] grid) {
        int water = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isLand(grid[i][j], 0)) {
                    water++;
                }
            }
        }
        return water;
    }
}
