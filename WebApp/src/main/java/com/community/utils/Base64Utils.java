package com.community.utils;

import com.google.common.io.ByteStreams;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static String[] separateBase64DataUrlToParts(String base64DataUrl){
        return base64DataUrl.split(",", 2);//get just the 2 parts (first comma)
    }

    public static String getBase64MetaDataFromParts(String[] parts){
        return parts[0];
    }

    public static String getBase64ImgFormatFromParts(String[] parts){
        String s = getBase64MetaDataFromParts(parts);
        s = s.substring(s.indexOf("/") + 1);
        return s.substring(0, s.indexOf(";"));
    }

    public static String getBase64ImgDataFromParts(String[] parts){
        return parts[1];
    }

    public static BufferedImage decodeToBufferedImage(String base64Data) throws IOException {
        try(ByteArrayInputStream bis = new ByteArrayInputStream(decode(base64Data))) {
            return ImageIO.read(bis);
        }
    }

    public static String mimeTypeForExtension(String ext){
        final MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
        return fileTypeMap.getContentType("test."+ext);
    }

    public static void main(String[] args) throws IOException {

//        String[] parts = separateBase64DataUrlToParts("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPAAAADwCAYAAAA+VemSAAAgAEl...==");
//        System.out.println("Meta: "+getBase64MetaDataFromParts(parts));
//        System.out.println("Format: "+getBase64ImgFormatFromParts(parts));
//        System.out.println("Data: "+getBase64ImgDataFromParts(parts));

//        // get name of default featured img resource (expect it to be on classpath)
//        String defImgName = MessageManager.getInstance().getMessage("default.featured.img");
//        System.out.println("Default Img Name: "+defImgName);
//
//        // get file extension of image to use as the format
//        String imgFormat = defImgName.substring(defImgName.lastIndexOf('.') + 1).trim();
//        System.out.println("Img Format: "+imgFormat);
//
//        // load the resource and copy to stream
//        try(ByteArrayOutputStream imgos = new ByteArrayOutputStream()){
//            ByteStreams.copy(Base64Utils.class.getClassLoader().getResourceAsStream(defImgName), imgos);
//            System.out.println("Byte[] Length: "+imgos.toByteArray().length);
//        }

        System.out.println(mimeTypeForExtension("tif"));

    }
}
