package com.z.starter.autoconfig.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class DigestUtils {

    public static String md5Hex(String data)  {
        try {


            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(data.getBytes(StandardCharsets.UTF_8));
            byte[] digest = messageDigest.digest();
            StringBuilder result = new StringBuilder();
            for (byte per : digest) {
                result.append(Integer.toHexString((0x000000FF & per) | 0xFFFFFF00).substring(6));
            }
            return result.toString();
        }catch (Exception e){

        }
        return null;
    }

}
