class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean direction = nums[i] > 0;

            int slow = i;
            int fast = i;

            while (true) {
                slow = next(nums, slow, direction);

                if (slow == -1)
                    break;

                fast = next(nums, fast, direction);

                if (fast == -1)
                    break;

                fast = next(nums, fast, direction);

                if (fast == -1)
                    break;

                if (slow == fast) {
                    // cycle length should be greater than 1
                    if (slow == next(nums, slow, direction))
                        break;

                    return true;
                }
            }
        }

        return false;
    }

    private int next(int[] nums, int index, boolean direction) {
        // different direction is not allowed
        if ((nums[index] > 0) != direction)
            return -1;

        int n = nums.length;

        int nextIndex = (index + nums[index]) % n;

        if (nextIndex < 0)
            nextIndex += n;

        return nextIndex;
    }
}