package com.example.tagtool.tagController;

//Md5加密生成32位md5码

import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5Encrypt {
    public static  String string1MD5(String inStr){
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            inStr = new BigInteger(1,md5.digest(inStr.getBytes())).toString(32);
            inStr = new String(inStr.getBytes());

        }catch (Exception e){

        }
        return inStr;
    }
}
