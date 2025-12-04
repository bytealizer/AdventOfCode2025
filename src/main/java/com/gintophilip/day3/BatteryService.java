package com.gintophilip.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BatteryService {
    private final List<String> inputAsList;
    String input = "";
    private int banksCount=0;

    public BatteryService(String input) {
        this.input = input;
        this.inputAsList = storeInput(input);
    }

    private List<String> storeInput(String input) {

        return Arrays.asList(input.split("\\r?\\n"));
    }

    public void turnOnBanks(int batteryCount) {
        this.banksCount = batteryCount;


    }

    public long getJoltage() {
        List<Long> col = new ArrayList<>();

        for (String  item:inputAsList){
            col.add(maxSubsequence(item,12));
        }
        return col.stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    public static Long maxSubsequence(String digits, int k) {
        int n = digits.length();
        StringBuilder result = new StringBuilder();
        int start = 0;
        for (int i = 0; i < k; i++) {
            int end = n - (k - i);

            char maxDigit = '0';
            int maxPos = start;

            for (int j = start; j <= end; j++) {
                char c = digits.charAt(j);
                if (c > maxDigit) {
                    maxDigit = c;
                    maxPos = j;
                }
            }

            result.append(maxDigit);
            start = maxPos + 1;
        }

        return Long.parseLong(result.toString());
    }

    public List<String> getInput() {

        return this.inputAsList;
    }
}
