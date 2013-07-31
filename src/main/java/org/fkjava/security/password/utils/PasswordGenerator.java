/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fkjava.security.password.utils;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author lwq
 */
public class PasswordGenerator {

    private static final char[] CHARS = new char[]{
        'a', 'b', 'c', 'd', 'e', 'f',
        'g', 'h', 'i', 'j', 'k', 'l',
        'm', 'n', 'o', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x',
        'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F',
        'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z',
        '!', '@', '#', '*', '_',
        '0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9'};

    public static String generate(PasswordGeneratRequest req) {
        String domainName = req.getDomainName();
        String securityQuestion = req.getSecurityQuestion();
        String securityAnswer = req.getSecurityAnswer();
        String birthday = req.getBirthday();
        String passwordLength = req.getPasswordLength();

        int length = Integer.parseInt(passwordLength);
        //计算密码
        /**
         * 密码算法： 利用域名、安全问题、安全答案、生日等组成一个字符串，并且把这个字符串使用DES3加密算法进行加密。
         *
         */
        StringBuilder builder = new StringBuilder();
        builder.append(domainName)
                .append(securityQuestion)
                .append(securityAnswer)
                .append(birthday);
        try {
            Cipher cipher = Cipher.getInstance("DES");

            KeyGenerator _generator = KeyGenerator.getInstance("DES");
            _generator.init(new SecureRandom(builder.toString().getBytes()));
            Key key = _generator.generateKey();

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] resultBytes = cipher.doFinal(builder.toString().getBytes());
            byte[] bytes = new byte[length];

            //把加密后的数据按密码长度累加计算
            int j = 0;
            for (int i = 0; i < resultBytes.length; i++) {
                byte rb = resultBytes[i];
                CALC:
                for (; j < length;) {
                    byte b = bytes[j];
                    byte temp = (byte) (b + rb);
                    bytes[j] = temp;
                    break CALC;
                }
                j++;
                if (j >= length) {
                    j = 0;
                }
            }

            char[] resultChars = new char[length];
            for (int i = 0; i < length; i++) {
                byte b = bytes[i];
                //字节范围
                int temp = b % CHARS.length;
                temp = Math.abs(temp);
                resultChars[i] = CHARS[temp];
            }

            String str = new String(resultChars);
            return str;
        } catch (InvalidKeyException ex) {
            Logger.getLogger(PasswordUtilsFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(PasswordUtilsFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(PasswordUtilsFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordUtilsFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(PasswordUtilsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
