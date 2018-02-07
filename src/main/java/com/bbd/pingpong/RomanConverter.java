package com.bbd.pingpong;

import java.util.*;
import java.util.regex.Pattern;

public class RomanConverter {
    public static int Convert(String s)
    {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("a message");
        }

        Pattern pattern = Pattern.compile("([a-z\\d])\\1\\1\\1", Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(s).find()) {
            throw new IllegalArgumentException("a message");
        }

        int ret = 0;
        String romanNum = s.toUpperCase();
        HashMap<Character, Integer> nums = new HashMap<>();
        nums.put('I', 1);
        nums.put('V', 5);
        nums.put('X', 10);
        nums.put('L', 50);
        nums.put('C', 100);
        nums.put('D', 500);
        nums.put('M', 1000);

        try{
            for (int i = 0; i < romanNum.length(); i++)
            {
                Object var = nums.get(romanNum.charAt(i));
                if ((i + 1)< romanNum.length()){
                    Object var2 = nums.get(romanNum.charAt(i + 1));

                    if ((int) var < (int) var2)
                        ret -= (int) var;
                    else
                        ret += (int) var;
                }else
                    ret += (int) var;
            }
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("a message");
        }
        return ret;
    }
}

