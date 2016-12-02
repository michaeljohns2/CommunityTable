package com.community.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

/**
 * Created by mjohns on 12/1/16.
 * Adapted from concepts at https://gist.github.com/utkarsh2012/1276960
 */
public class Base64Utils {

    /**
     * Encode file to base64 String.
     *
     * @param file Path
     * @return String encoded file format
     *
     * @throws IOException
     */
    public static String encode(Path file) throws IOException {
        byte[] bytes = Files.readAllBytes(file);
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * Decode base64 String.
     *
     * @param b64 String
     * @return byte[]
     */
    public static byte[] decode(String b64){
        return Base64.getDecoder().decode(b64);
    }

    /**
     * Decode base64 String to file.
     *
     * @param b64 String
     * @param file Path
     *
     * @throws IOException
     */
    public static void decodeTo(String b64, Path file) throws IOException {
        byte[] bytes = decode(b64);
        Files.write(file, bytes);
    }
}
