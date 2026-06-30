import java.util.*;

class Solution {

    public List<Integer> search(String pat, String txt) {

        List<Integer> ans = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        if (m > n) {
            return ans;
        }

        long patHash = 0;
        long txtHash = 0;
        long power = 1;

        int base = 31;
        int mod = 1000000007;

        for (int i = 0; i < m - 1; i++) {
            power = (power * base) % mod;
        }

        for (int i = 0; i < m; i++) {
            patHash = (patHash * base + pat.charAt(i)) % mod;
            txtHash = (txtHash * base + txt.charAt(i)) % mod;
        }

        for (int i = 0; i <= n - m; i++) {

            if (patHash == txtHash) {

                if (txt.substring(i, i + m).equals(pat)) {
                    ans.add(i);
                }
            }

            if (i < n - m) {

                txtHash = (txtHash - txt.charAt(i) * power % mod + mod) % mod;
                txtHash = (txtHash * base + txt.charAt(i + m)) % mod;
            }
        }

        return ans;
    }
}