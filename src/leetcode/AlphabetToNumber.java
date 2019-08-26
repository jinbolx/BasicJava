package leetcode;

import java.util.HashMap;

public class AlphabetToNumber {

    public static int romanToInt(String s) {
        if (s == null) {
            return -1;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'I':
                    if (i < chars.length - 1) {
                        switch (chars[i + 1]) {
                            case 'V':
                                i++;
                                count += 4;
                                break;
                            case 'X':
                                count += 9;
                                i++;
                                break;
                            default:
                                count++;
                                break;
                        }
                    } else {
                        count++;
                    }
                    break;
                case 'V':
                    count += 5;
                    break;
                case 'X':
                    if (i < chars.length - 1) {
                        switch (chars[i + 1]) {
                            case 'L':
                                i++;
                                count += 40;
                                break;
                            case 'C':
                                count += 90;
                                i++;
                                break;
                            default:
                                count += 10;
                                break;
                        }
                    } else if (i > 0 && chars[i - 1] == 'V') {
                        return -1;
                    } else {
                        count += 10;
                    }
                    break;
                case 'L':
                    if (i > 0 && (chars[i - 1] == 'I' || chars[i - 1] == 'V')) {
                        return -1;
                    } else {
                        count += 50;
                    }
                    break;
                case 'C':
                    if (i < chars.length - 1) {
                        switch (chars[i + 1]) {
                            case 'D':
                                i++;
                                count += 400;
                                break;
                            case 'M':
                                count += 900;
                                i++;
                                break;
                            default:
                                count += 100;
                                break;
                        }
                    } else if (i > 0 && (chars[i - 1] == 'I' || chars[i - 1] == 'V'
                            || chars[i - 1] == 'L')) {
                        return -1;
                    } else {
                        count += 100;
                    }
                    break;
                case 'D':
                    if (i > 0 && (chars[i - 1] == 'I' || chars[i - 1] == 'V' || chars[i - 1] == 'X'
                            || chars[i - 1] == 'L')) {
                        return -1;
                    } else {
                        count += 500;
                    }
                    break;
                case 'M':
                    if (i > 0 && (chars[i - 1] == 'I' || chars[i - 1] == 'V' || chars[i - 1] == 'X'
                            || chars[i - 1] == 'L' || chars[i - 1] == 'D')) {
                        return -1;
                    } else {
                        count += 1000;
                    }
                    break;
                default:
                    return -1;
            }
        }

        return count;
    }

    public static int romanToIntUseMap(String s) {
        if (s == null) {
            return -1;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        for (int i = 0; i < chars.length; i++) {
            int tempI = romanMap.get(chars[i]);
            if (i < chars.length - 1) {
                int tempIPlus = romanMap.get(chars[i + 1]);
                if (tempI < tempIPlus) {
                    count -= tempI;
                } else {
                    count += tempI;
                }
            } else {
                count += tempI;
            }
        }
        return count;
    }

    public static int romanToIntCommon(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int length = s.length();
        char []chars=s.toCharArray();
        for (int i = 0; i < length; i++) {
            switch (chars[i]) {
                case 'I':
                    if (i < length - 1) {
                        if (chars[i+1] == 'V') {
                            count += 4;
                            i++;
                        } else if (chars[i+1] == 'X') {
                            count += 9;
                            i++;
                        } else {
                            count++;
                        }
                    } else {
                        count++;
                    }
                    break;
                case 'V':
                    count += 5;
                    break;
                case 'X':
                    if (i < length - 1) {
                        if (chars[i+1] == 'L') {
                            count += 40;
                            i++;
                        } else if (chars[i+1] == 'C') {
                            count += 90;
                            i++;
                        } else {
                            count+=10;
                        }
                    } else {
                        count+=10;
                    }
                    break;
                case 'L':
                    count += 50;
                    break;
                case 'C':
                    if (i < length - 1) {
                        if (chars[i+1] == 'D') {
                            count += 400;
                            i++;
                        } else if (chars[i+1] == 'M') {
                            count += 900;
                            i++;
                        } else {
                            count+=100;
                        }
                    } else {
                        count+=100;
                    }
                    break;
                case 'D':
                    count += 500;
                    break;
                case 'M':
                    count += 1000;
                    break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String roman = "LVIII";
        System.out.println("romanToInt: " + roman + " int: " + romanToIntCommon(roman));
    }
}
