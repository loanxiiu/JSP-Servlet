package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MaHoaMK {
    public static String toSHA1(String str){
        String salt = "adsweadsdgedssdd";
        String result = null;
        str = str + salt;
        try {
            byte[] dataBytes = str.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            result = Base64.getEncoder().encodeToString(md.digest(dataBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(toSHA1("loanxindsshiu"));
    }
}
