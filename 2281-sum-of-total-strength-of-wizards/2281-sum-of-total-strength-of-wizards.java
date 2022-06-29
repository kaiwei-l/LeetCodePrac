class Solution {
    public int totalStrength(int[] strength) {
        final var mod = (int) 1e9 + 7;

        var n = strength.length;
        var left = new int[n];  
        var right = new int[n];
        Arrays.fill(right, n);
        var st = new ArrayDeque<Integer>();
        for (var i = 0; i < n; i++) {
            while (!st.isEmpty() && strength[st.peek()] >= strength[i]) right[st.pop()] = i;
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        var s = 0L;
        var ss = new int[n + 2];
        for (var i = 1; i <= n; ++i) {
            s += strength[i - 1];
            ss[i + 1] = (int) ((ss[i] + s) % mod);
        }

        var ans = 0L;
        for (var i = 0; i < n; ++i) {
            int l = left[i] + 1, r = right[i] - 1;
            var tot = ((long) (i - l + 1) * (ss[r + 2] - ss[i + 1]) - (long) (r - i + 1) * (ss[i + 1] - ss[l])) % mod;
            ans = (ans + strength[i] * tot) % mod;
        }
        return (int) (ans + mod) % mod;
    }
}