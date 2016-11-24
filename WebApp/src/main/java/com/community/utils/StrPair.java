package com.community.utils;

/**
 * Created by mjohns on 11/23/16.
 */
public class StrPair extends Pair<String,String> {

    /**
     * Support quicker construction.
     *
     * @param s1 String
     * @param s2 String
     * @return StrPair
     */
    public static StrPair of(String s1, String s2){
        return new StrPair(s1,s2);
    }

    public StrPair(String s1, String s2){
        super(s1, s2);
    }
}
