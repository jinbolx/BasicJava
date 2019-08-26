package leetcode;

/**
 * @author matengfei
 * @date: 2018/12/27.
 */
public class RomaNumber {
    public static void main(String[] args) {
        RomaNumber number = new RomaNumber();
        long time1 = System.currentTimeMillis();
        for(int i = 0; i < 1000000 ; i++)
        {
            number.parse("MMCDLXV");
        }
        long time2 = System.currentTimeMillis();
        for(int i = 0; i < 1000000 ; i++)
        {
            number.romanToInt("MMCDLXV");
        }
        long time3 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        System.out.println(time3 - time2);
    }

    private int parse(String number) {
        int nowNumber, lastNumber = 0;
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            nowNumber = getSingleNumber(number.charAt(i));
            if (i != 0 && lastNumber < nowNumber) {
                sum = sum + nowNumber - lastNumber * 2;
            } else {
                sum += nowNumber;
            }
            lastNumber = nowNumber;
        }
        return sum;
    }

    private int getSingleNumber(char c) {
        int result;
        switch (c) {
            case 'M':
                result = 1000;
                break;
            case 'D':
                result = 500;
                break;
            case 'C':
                result = 100;
                break;
            case 'L':
                result = 50;
                break;
            case 'X':
                result = 10;
                break;
            case 'V':
                result = 5;
                break;
            case 'I':
                result = 1;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }

    public int romanToInt(String s) {
        if("".equals(s) || null == s) {
            return 0;
        }
        //transform String to char array
        char[] chars = s.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            switch (chars[i]) {
                case 'I':
                    if(i + 1 == chars.length) {
                        sum += 1;
                        break;
                    } else{
                        if(chars[i + 1] == 'V' || chars[i + 1] == 'X'){
                            sum -= 1;
                        } else{
                            sum += 1;
                        }
                        break;
                    }
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if(i + 1 == chars.length) {
                        sum += 10;
                        break;
                    } else{
                        if(chars[i + 1] == 'L' || chars[i + 1] == 'C'){
                            sum -= 10;
                        } else {
                            sum += 10;
                        }
                        break;
                    }
                case 'L':
                    sum +=50;
                    break;
                case 'C':
                    if(i + 1 == chars.length) {
                        sum += 100;
                        break;
                    } else{
                        if(chars[i + 1] == 'D' || chars[i + 1] == 'M'){
                            sum -= 100;
                        } else{
                            sum += 100;
                        }
                        break;
                    }
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
                default:
                    return 0;
            }
        }
        return sum;
    }

}