package com.gintophilip.day1.secret_entrance;

public class SecretEntrance {
    int dialStart = 50;
    int currentPos = dialStart;
    int dialSize = 100;

    private int extractDigit(String input) {
        String digits = input.replaceAll("\\D", "");
        return Integer.parseInt(digits);
    }

    public void rotateL(String rotation) {
        int step = extractDigit(rotation);
        int pos = (currentPos - step % dialSize + dialSize) % dialSize;
        currentPos = pos;
    }

    public void rotateR(String rotation) {
        int step = extractDigit(rotation);
        int pos = (currentPos + step) % dialSize;
        currentPos = pos;
    }

    public int getCurrentPositon() {
        return  currentPos;
    }
}
