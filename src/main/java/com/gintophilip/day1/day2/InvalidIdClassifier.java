package com.gintophilip.day1.day2;

import java.util.ArrayList;
import java.util.List;

public class InvalidIdClassifier {


    private String[] inputIds;
    List<Long> invalidIds = new ArrayList<>();

    public InvalidIdClassifier(String[] inputIds) {
        this.inputIds = inputIds;
    }


    public long getSumOfInvalidIds() {
        for (String id : inputIds) {
            findInvalidBetweenRange(id);
        }
        long sum = invalidIds.stream().mapToLong(Long::longValue).sum();
        return sum;
    }

    private void findInvalidBetweenRange(String range) {
        String[] input = range.split("-");
        long start = Long.parseLong(input[0]);
        long end = Long.parseLong(input[1]);
        for (long i = start; i <= end; i++) {
//            isRepeatingsequence(i);
            isRepeatingsequence2(i);
        }
    }

    private void isRepeatingsequence(long number) {
        String n = String.valueOf(number);
        int length = n.length();
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < length; i++) {
            c.append(String.valueOf(n.charAt(i)));
            String sub = n.substring(i + 1);
            if (c.toString().equals(sub)) {
                System.out.println("Sequence found " + n);
                invalidIds.add(Long.valueOf(n));
            }
        }
    }
    private void isRepeatingsequence2(long number) {
        String k = String.valueOf(number);
        k=k+k;
        k = k.substring(1, k.length() - 1);
        if(k.contains(String.valueOf(number))){
            System.out.println("sequence found " + number);
            invalidIds.add(number);

        }


//        String n = String.valueOf(number);
//        int length = n.length();
//        StringBuilder c = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            c.append(String.valueOf(n.charAt(i)));
//            String sub = n.substring(i + 1);
//            if (c.toString().equals(sub)) {
//                System.out.println("Sequence found " + n);
//                invalidIds.add(Long.valueOf(n));
//            }
//        }

    }
}
