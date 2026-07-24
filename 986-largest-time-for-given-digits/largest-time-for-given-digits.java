class Solution {
    private String answer = "";

    public String largestTimeFromDigits(int[] arr) {
        backtrack(arr, 0);
        return answer;
    }

    private void backtrack(int[] arr, int index) {
        if (index == arr.length) {
            int hour = arr[0] * 10 + arr[1];
            int minute = arr[2] * 10 + arr[3];

            if (hour < 24 && minute < 60) {
                String time = String.format("%02d:%02d", hour, minute);
                if (answer.equals("") || time.compareTo(answer) > 0) {
                    answer = time;
                }
            }
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            backtrack(arr, index + 1);
            swap(arr, index, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}