package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MiscSolutions {
    public static void main(String[] args) {
        String sentence = "TheQuickBrownFoxJumpsOverTheLazyDog121";
        System.out.println(new MiscSolutions().checkIfPangram(sentence));

        String vowels = "IceCreAm";
        System.out.println(new MiscSolutions().reverseVowels(vowels));

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new MiscSolutions().maxProfit2(prices));

        String[] words = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String word1 = "fox", word2 = "dog";
        System.out.println(new MiscSolutions().shortestWordDistance(words, word1, word2));

        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println("numIdenticalPairs: " + new MiscSolutions().numIdenticalPairs(nums));
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                count += map.get(nums[i]);
            }
            map.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
        }
        return count;
    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;

            l++;
            r--;
        }
    }

    private int shortestWordDistance(String[] words, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        int i = -1, j = -1;
        for (int k = 0; k < words.length; k++) {
            if (words[k].equals(word1)) {
                i = k;
            } else if (words[k].equals(word2)) {
                j = k;
            }

            if (i > 0 && j > 0) ans = Math.min(Math.abs(i - j), ans);
        }

        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        int[] res = new int[2];

        int li = 0;
        int ri = nums.length - 1;

        while (li < ri) {
            int n = pairs[li].val + pairs[ri].val;

            if (n == target) {
                res[0] = pairs[li].idx + 1;
                res[1] = pairs[ri].idx + 1;
                break;
            } else if (n > target) {
                ri--;
            } else {
                li++;
            }
        }

        return res;
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int left = 0;

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                left = i;
            } else {
                maxProfit = Math.max(prices[i] - prices[left], maxProfit);
            }
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int l = 0, r = 1;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                maxProfit = Math.max(prices[r] - prices[l], maxProfit);
            } else {
                l = r;  // found smaller price than at l
            }
            r++;
        }

        return maxProfit;
    }

    public boolean checkIfPangram(String sentence) {
        Set<Character> s = new HashSet<>();
        sentence.chars()
                .filter(Character::isLetter)
                .map(Character::toUpperCase)
                .forEach(e -> s.add((char) e));

        return s.size() == 26;
    }

    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();

        int i = 0, j = chs.length - 1;
        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U');

        while (i < j) {
            while (i < chs.length
                    && !vowels.contains(Character.toUpperCase(chs[i]))) {
                i++;
            }

            while (j > i
                    && !vowels.contains(Character.toUpperCase(chs[j]))) {
                j--;
            }

            if (i < j) {
                char tmp = chs[i];
                chs[i] = chs[j];
                chs[j] = tmp;

                i++;
                j--;
            }
        }

        return String.valueOf(chs);
    }

    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.val > o.val) {
                return 1;
            } else if (this.val < o.val) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}