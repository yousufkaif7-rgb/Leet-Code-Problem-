import java.util.*;

class Solution {
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return backtrack(s, wordSet);
    }

    private List<String> backtrack(String s, Set<String> wordSet) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (int end = 1; end <= s.length(); end++) {
            String prefix = s.substring(0, end);

            if (wordSet.contains(prefix)) {
                String suffix = s.substring(end);
                List<String> subList = backtrack(suffix, wordSet);

                for (String sub : subList) {
                    result.add(prefix + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}