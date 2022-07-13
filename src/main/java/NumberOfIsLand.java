public class NumberOfIsLand {

    private static final int LAND = 1;
    private static final int WATER = 0;

    private final int[][] grid;

    public NumberOfIsLand(int[][] grid) {
        this.grid = grid;
    }

    public int numIsLands() {
        int numIsLand = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (isLand(grid[row][col])) {
                    numIsLand++;
                    dfs(row, col);
                }
            }
        }
        return numIsLand;
    }

    private boolean isLand(int cell) {
        return cell == LAND;
    }

    private void dfs(int row, int col) {
        if (!isValidCell(row, col))
            return;

        markCellAsVisited(row, col);
        checkCellNeighbors(row, col);
    }

    private boolean isValidCell(int row, int col) {
        try {
            return isLand(grid[row][col]);
        } catch (Exception e) {
            return false;
        }
    }

    // If the cell is valid, let's first mark it as a water cell to make sure we won't visit it again.
    private void markCellAsVisited(int row, int col) {
        grid[row][col] = WATER;
    }

    private void checkCellNeighbors(int row, int col) {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : directions)
            dfs(row + d[0], col + d[1]);
    }
}
