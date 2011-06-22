package com.hundsun.client.ency.app;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.spec.*;

public class EncryDes {
        /* 加密类 */
        protected Cipher ecipher;

        /* 接密类 */
        protected Cipher dcipher;

        public EncryDes() {
                try {
                        // Create the key，"hshundsun2008"为随即初始化密文
                        String passPhrase = "hshundsun2008";
                        /* 生成秘钥 */
                        KeySpec keySpec = new DESKeySpec(passPhrase.getBytes());
                        SecretKey key = SecretKeyFactory.getInstance("DES").generateSecret(
                                        keySpec);
                        // SecretKeySpec key = new
                        // SecretKeySpec(passPhrase.getBytes(),"DES");
                        /* 初始化加解密实例 */
                        ecipher = Cipher.getInstance(key.getAlgorithm());
                        dcipher = Cipher.getInstance(key.getAlgorithm());

                        // Prepare the parameter to the ciphers
                        // AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt,
                        // iterationCount);
                        // Create the ciphers
                        ecipher.init(Cipher.ENCRYPT_MODE, key);
                        dcipher.init(Cipher.DECRYPT_MODE, key);

                } catch (Exception e) {
                        e.printStackTrace();
                }

        }

        /**
         * 对字符串加密
         *
         * @param source
         *            String 要加密的字符串
         * @return byte[] 已加密的字节
         */
        public byte[] encrypt(String source) {
                try {
                        // Encode the string into bytes using utf-8
                        // byte[] utf8 = new sun.misc.BASE64Decoder().decodeBuffer(str);

                        // Encrypt
                        byte[] enc = ecipher.doFinal(source.getBytes());

                        // Encode bytes to base64 to get a string
                        // return new sun.misc.BASE64Encoder().encode(enc);
                        return enc;
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return null;
        }

        /**
         * 对字节数组解密
         *
         * @param buf
         *            byte[]
         * @return String
         */
        public String decrypt(byte[] buf) {
                try {
                        // Decode base64 to get bytes
                        // byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

                        // Decrypt
                        byte[] utf8 = dcipher.doFinal(buf);

                        // Decode using utf-8
                        // return new String(utf8, "UTF8");
                        return new String(utf8);
                } catch (javax.crypto.BadPaddingException e) {
                } catch (IllegalBlockSizeException e) {
                        // } catch (UnsupportedEncodingException e) {
                }
                return null;
        }
        /**
        * 对符串解密
        *
        * @param buf
        *            byte[]
        * @return String
        */
       public String decrypt(String s) {
               try {
                       // Decode base64 to get bytes
                       // byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

                       // Decrypt
                       byte[] utf8 = dcipher.doFinal(s.getBytes());

                       // Decode using utf-8
                       // return new String(utf8, "UTF8");
                       return new String(utf8);
               } catch (javax.crypto.BadPaddingException e) {
               } catch (IllegalBlockSizeException e) {
                       // } catch (UnsupportedEncodingException e) {
               }
               return null;
       }


        /**
         * 专用密码加密
         *
         * @param password
         *            String
         * @return String
         */
        public String getEncPass(String password) {
                byte[] dst = encrypt(password + "        ");// 密码补足十二位
                String dstStr = "";
                for (int i = 0; i < dst.length && i < 12; i++) {// 密文只取前64位
                        int cTmp = (int) dst[i] & 0xff;
                        String hexStr = Integer.toHexString(cTmp);
                        while (hexStr.length() < 2) {
                                hexStr = "0" + hexStr;
                        }
                        dstStr += hexStr;
                }
                return dstStr.toUpperCase();
        }

        public static void main(String []args){
                EncryDes des = new EncryDes();
                System.out.println(des.encrypt("1234567890123"));
                System.out.println(des.decrypt(des.encrypt("1234567890123")));
        }

}
