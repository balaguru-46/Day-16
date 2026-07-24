class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total = 0;

        for (int battery : batteries) {
            total += battery;
        }

        long low = 1;
        long high = total / n;
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canRun(batteries, n, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canRun(int[] batteries, int n, long time) {
        long available = 0;

        for (int battery : batteries) {
            available += Math.min((long) battery, time);
        }

        return available >= time * n;
    }
}