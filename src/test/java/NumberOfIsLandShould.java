import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfIsLandShould {
    //Rule:
    // grid map of '1's (land) and '0's (water)
    // an isLand surrounded by water and is formed by connection adjacent lands horizontally or vertically.

    NumberOfIsLand numberOfIsLand;
    NumberOfIsLand numberOfIsLand2;

    @BeforeEach
    void setUp() {
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}};

        int[][] grid2 = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};

        numberOfIsLand = new NumberOfIsLand(grid);
        numberOfIsLand2 = new NumberOfIsLand(grid2);
    }
    @Test
    void get_count_the_number_of_isLands() {
        final int oneIsLand = numberOfIsLand.numIsLands();
        final int threeIsLand = numberOfIsLand2.numIsLands();

        assertThat(oneIsLand).isEqualTo(1);
        assertThat(threeIsLand).isEqualTo(3);
    }
}
