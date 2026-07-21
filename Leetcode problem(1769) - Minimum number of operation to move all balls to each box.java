class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        
        int ballsLeft = 0;
        int movesLeft = 0;
        for (int i = 0; i < n; i++) {
            answer[i] += movesLeft;
            if (boxes.charAt(i) == '1') {
                ballsLeft++;
            }
            movesLeft += ballsLeft;
        }
        
        int ballsRight = 0;
        int movesRight = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += movesRight;
            if (boxes.charAt(i) == '1') {
                ballsRight++;
            }
            movesRight += ballsRight;
        }
        
        return answer;
    }
}
