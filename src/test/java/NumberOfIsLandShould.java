import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfIsLandShould {
    // grid map of '1's (land) and '0's (water)
    // an isLand surrounded by water and is formed by connection adjacent lands horizontally
    // or vertically

    NumberOfIsLand numberOfIsLand;
    int[][] grid;
    @BeforeEach
    void setUp() {
        grid = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        numberOfIsLand = new NumberOfIsLand(grid);
    }

    @Test
    void get_number_of_grid_lands() {
        final int numIsLands = numberOfIsLand.numLands(grid);

        assertThat(numIsLands).isEqualTo(9);
    }

    @Test
    void get_number_of_grid_water() {
        final int numIsLands = numberOfIsLand.numWater(grid);

        assertThat(numIsLands).isEqualTo(11);
    }

    @Test
    void get_count_the_number_of_isLands() {
        final int numIsLands = numberOfIsLand.numIsLands();

        assertThat(numIsLands).isEqualTo(1);
    }
}
