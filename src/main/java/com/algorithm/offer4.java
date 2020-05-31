package com.algorithm;

import java.util.stream.IntStream;

/**
 * @author WhomHim
 * @description
 * @date Create in 2020-5-31 13:50:13
 */
public class offer4 {
    public static void main(String[] args) {
        String s = "We Are Happy.";
        StringBuffer stringBuffer = new StringBuffer();
        IntStream.range(0, s.length())
                .forEach(i -> stringBuffer.append(s.charAt(i)));
        String s1 = replaceSpace(stringBuffer);
        System.out.println(s1);
    }

    private static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();

        IntStream.range(0, str.length())
                .forEach(i -> {
                    if (String.valueOf(str.charAt(i)).equals(" ")) {
                        sb.append("%20");
                    } else {
                        sb.append(str.charAt(i));
                    }
                });

        return sb.toString();
    }
}
