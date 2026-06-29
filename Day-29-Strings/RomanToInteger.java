class Solution {

    public int romanToInt(String s) {

        int result = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            if (value(s.charAt(i)) < value(s.charAt(i + 1))) {
                result -= value(s.charAt(i));
            } else {
                result += value(s.charAt(i));
            }
        }

        result += value(s.charAt(s.length() - 1));

        return result;
    }

    private int value(char c) {

        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}