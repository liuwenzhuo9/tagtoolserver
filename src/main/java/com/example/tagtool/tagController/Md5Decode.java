package com.example.tagtool.tagController;

//解密Md5
public class Md5Decode {
    public static String convertMD5(String inStr){
        char[] a = inStr.toCharArray();
        for(int i =0;i < a.length;i++){
            a[i] = (char)(a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }
}