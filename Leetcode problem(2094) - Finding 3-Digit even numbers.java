import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }
        
        List<Integer> resultList = new ArrayList<>();
        for (int i = 100; i <= 998; i += 2) {
            int hundreds = i / 100;
            int tens = (i / 10) % 10;
            int ones = i % 10;
            
            count[hundreds]--;
            count[tens]--;
            count[ones]--;
            
            if (count[hundreds] >= 0 && count[tens] >= 0 && count[ones] >= 0) {
                resultList.add(i);
            }
            
            count[hundreds]++;
            count[tens]++;
            count[ones]++;
        }
        
        int[] result = new int[resultList.size()];
        for (int j = 0; j < resultList.size(); j++) {
            result[j] = resultList.get(j);
        }
        return result;
    }
}
