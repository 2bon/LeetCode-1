package 动态规划.q1143_最长公共子序列;

/**
 * 动态规划 dp[i + 1][j + 1] = Math.max(dp[i+1][j], dp[i][j+1]) o(m*n)
 * <p>
 * 若题目为最长公共子串，则在c1,c2不相等时不做处理（赋值0），在遍历过程中记录最大值即可
 */
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 最长公共字串
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String longestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        int endIndex = -1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        if (maxLength == 0) {
            return "";
        }
        return str1.substring(endIndex - maxLength + 1, endIndex + 1);
    }
}
