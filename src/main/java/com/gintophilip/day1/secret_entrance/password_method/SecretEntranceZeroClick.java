package com.gintophilip.day1.secret_entrance.password_method;

import java.util.HashMap;
import java.util.Map;

public class SecretEntranceZeroClick {
    int dialStart = 50;
    int currentPos = dialStart;
    int dialSize = 100;
    Map<Integer,Integer> clickCountMapper = new HashMap<>();

    private int extractDigit(String input) {
        String digits = input.replaceAll("\\D", "");
        return Integer.parseInt(digits);
    }

    public void rotateL(String rotation) {
        int rotationCount = extractDigit(rotation);
        int pos = currentPos;
        for (int i = 0; i < rotationCount; i++) {
            pos--;
            if (pos < 0) {
                pos = dialSize - 1;
            }
            incrementClickCount(pos);
        }
        currentPos = pos;
    }

    public void rotateR(String rotation) {
        int rotationCount = extractDigit(rotation);
        int pos = currentPos;
        for (int i = 0; i < rotationCount; i++) {
            pos++;
            if (pos >= dialSize) {
                pos = 0;
            }
            incrementClickCount(pos);
        }
        currentPos = pos;
    }

    private void incrementClickCount(int pos) {

        if(clickCountMapper.containsKey(pos)){
            clickCountMapper.put(pos,clickCountMapper.get(pos)+1);
        }else {
            clickCountMapper.put(pos,1);
        }
    }

    public int getCurrentPositon() {
        return  currentPos;
    }
    public  int getClickCount(int pos){
        return clickCountMapper.get(pos);
    }
}
