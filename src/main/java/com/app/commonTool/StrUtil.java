package com.app.commonTool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @describe 集成对字符串串的操作：MD5,SHA
 * @author zhanghj
 *
 */
public class StrUtil {

    /**  对字符串进行MD5加密     */
    public static String getMD5Str(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch ( NoSuchAlgorithmException e ) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch ( UnsupportedEncodingException e ) {
            e.printStackTrace();
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString();
    }

    /**  对字符串进行SHA加密     */
    public static String getSHAStr(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch ( NoSuchAlgorithmException e ) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch ( UnsupportedEncodingException e ) {
            e.printStackTrace();
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer shaStrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                shaStrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                shaStrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return shaStrBuff.toString();
    }
    
    /**  盐值加密     */
    public static String getEncryptStr(String str) {
        StringBuffer encryptStr = new StringBuffer(getSHAStr(str));
        encryptStr.append("880b32923e7beed3c19a9f4dcf56197c");
        return getMD5Str(encryptStr.toString());
    }


    /** 如果为null就转化为空empty **/
    public static String IsNullToEmpty(String str) {
        if (str.equals(null))
            str = "";
        return str;
    }
    /** 将传递进来的字节数组转换成十六进制的字符串形式并返回  **/
    @SuppressWarnings("unused")
	private static String toHex(byte[] buffer){
         StringBuffer sb = new StringBuffer(buffer.length * 2);
         for (int i = 0; i < buffer.length; i++){
                sb.append(Character.forDigit((buffer[i] & 0xf0) >> 4, 16));
                sb.append(Character.forDigit(buffer[i] & 0x0f, 16));
         }
         return sb.toString();
      }

}
