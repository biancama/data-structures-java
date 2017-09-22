package org.biancama.algorithms.dynamic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Created by massimo.biancalani on 22/09/2017.
 */
public class LongestCommonSubSequenceTest {

    @Test
    public void test01() {
        LongestCommonSubSequence longestCommonSubSequence = new LongestCommonSubSequence("GAC", "AGCAT");
        assertThat(longestCommonSubSequence.longestCommonSubSequenceLength()).isEqualTo(2);
        assertThat(longestCommonSubSequence.longestCommonSubSequence()).containsExactlyInAnyOrder("AC", "GC", "GA");
    }

    @Test
    public void test02() {
        LongestCommonSubSequence longestCommonSubSequence = new LongestCommonSubSequence("XMJYAUZ", "MZJAWXU");
        assertThat(longestCommonSubSequence.longestCommonSubSequenceLength()).isEqualTo(4);
        assertThat(longestCommonSubSequence.longestCommonSubSequence()).containsExactlyInAnyOrder("MJAU");
    }
}
