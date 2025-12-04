package com.gintophilip.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestPossibleJolt {

    private List<String> joltList;
    private List<Integer> joltValueCollection;

    public LargestPossibleJolt(String input) {
        joltList = createJoltArray(input);
        joltValueCollection = new ArrayList<>();
    }

    private List<String> createJoltArray(String input) {
        return Arrays.asList(input.split("\\r?\\n"));
    }
    public List<String> getInputList() {
        return joltList;
    }

    public void getLargestPossibleJolt(String input) {
        String[] joltValues = input.split("");
        int[] nums = new int[joltValues.length];
        for (int i = 0; i < joltValues.length; i++) {
            nums[i] = Integer.parseInt(joltValues[i]);
        }
        int currentMaxDigit = nums[0];
        int secondMaxDigit = nums[0];
        int firstDigitMaxPos = 0;
        int secondDigitMaxPos = 0;
        for (int i = 1; i < nums.length-1; i++) {
            int currentDigit = nums[i];
            if (currentDigit  > currentMaxDigit) {
                currentMaxDigit = nums[i];
                firstDigitMaxPos = i;
                secondDigitMaxPos = i + 1;
            }

        }
        int k = 0;
        secondMaxDigit = nums[secondDigitMaxPos];
        if (firstDigitMaxPos == secondDigitMaxPos) {
            secondDigitMaxPos += 1;
            k = secondDigitMaxPos;
            System.out.println(k);
            secondMaxDigit = nums[secondDigitMaxPos];
        } else {
            k = secondDigitMaxPos + 1;
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > secondMaxDigit) {
                secondMaxDigit = nums[i];
                secondDigitMaxPos = i;
            }

        }

        joltValueCollection.add(Integer.parseInt(currentMaxDigit + "" + secondMaxDigit));
    }



    public int getSumOfJolt() {
        return joltValueCollection.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
