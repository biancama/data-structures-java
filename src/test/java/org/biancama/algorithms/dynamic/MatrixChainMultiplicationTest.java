package org.biancama.algorithms.dynamic;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.List;

/**
 * Created by massimo.biancalani on 25/09/2017.
 */
public class MatrixChainMultiplicationTest {

    // A1 (10 x 100), A2 (100 x 20), A3(20 x 5), A4 (5 x 80)
    @Test
    public void test01() {
        List<MatrixChainMultiplication.MatrixDimension> matrices = asList(
            new MatrixChainMultiplication.MatrixDimension(10, 100),
            new MatrixChainMultiplication.MatrixDimension(100, 20),
            new MatrixChainMultiplication.MatrixDimension(20, 5),
            new MatrixChainMultiplication.MatrixDimension(5, 80)
        );
        MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication(matrices);

        assertThat(matrixChainMultiplication.minimunNumberOfOperations()).isEqualTo(19000);
        assertThat(matrixChainMultiplication.optimalSplit()).isEqualTo("((A1(A2A3))A4)");
    }

    @Test
    public void test02() {
        List<MatrixChainMultiplication.MatrixDimension> matrices = asList(
            new MatrixChainMultiplication.MatrixDimension(30, 35),
            new MatrixChainMultiplication.MatrixDimension(35, 15),
            new MatrixChainMultiplication.MatrixDimension(15, 5),
            new MatrixChainMultiplication.MatrixDimension(5, 10),
            new MatrixChainMultiplication.MatrixDimension(10, 20),
            new MatrixChainMultiplication.MatrixDimension(20, 25)
        );
        MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication(matrices);

        assertThat(matrixChainMultiplication.minimunNumberOfOperations()).isEqualTo(15125);
        assertThat(matrixChainMultiplication.optimalSplit()).isEqualTo("((A1(A2A3))((A4A5)A6))");
    }
}
