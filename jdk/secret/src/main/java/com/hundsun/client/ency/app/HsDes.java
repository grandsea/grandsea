package com.hundsun.client.ency.app;

public class HsDes {
    /**
            * des加密
            * @param arg
            * @return
            */
           public static final String  HUNDSUN_VERSION="@system  理财销售系统 @version 1.2.0.0 @lastModiDate @describe ";
         public static String enc(String arg){    //加密一段文本串

             if(arg==null || arg.length()==0){   //如果为null或者空则加密对0x00处理

                     byte [] b={0x00};
                     arg =new String(new String(b));        //如果为空则返回空


             }
                   Encryptor  enc=new Encryptor("HsAndMoe".getBytes());
                   return byte2hex( enc.encrypt(arg.getBytes()));

             }
         /**
          * des解密
          * @param arg
          * @return
          */
         public static String dec(String arg){    //加密一段文本串

            if(arg==null || arg.length()==0){   //如果为null或者空则返回空串
                           return new String();             //跟unix端c一致
            }

            Encryptor  dec=new Encryptor("HsAndMoe".getBytes());
                byte decByte[]=dec.decrypt(hex2byte(arg));

                return byte2string(decByte);

         }

             /**
              * 由于java字符串没有结束符号,去掉0x00后转换成字符串
              * @param decByte
              * @return
              */
         public  static String  byte2string(byte[] decByte){
            int len=0;
             for(int i=0;i<decByte.length;i++,len++){  //将结束符号0x00的去掉，然后再转成字符串，

                    if(decByte[i]==0x00){
                            len=i;
                            break;
                    }
                }
                return   len==0?new String():new String(decByte,0,len);
         }

            /**
             * 字节数组转换成16进制字符串
             * @param b
             * @return
             */
             public static String byte2hex(byte[] b) {//二行制转字符串
                   String hs="";
                   String stmp="";


                   for (int n=0;n<b.length;n++) {
                       stmp=byteHEX(b[n]);
                       hs=hs+stmp;
                   }
                   return hs;
               }


             public static String byteHEX(byte ib) {
             char[] Digit = { '0','1','2','3','4','5','6','7','8','9',
             'A','B','C','D','E','F' };
             char [] ob = new char[2];
             ob[0] = Digit[(ib >>> 4) & 0X0F];
             ob[1] = Digit[ib & 0X0F];
             String s = new String(ob);
             return s;
         }


             /**
              * 16进制字符串转换成字节数组
              * @param hex
              * @return
              */
             public static byte[] hex2byte(String hex) {
                       int len = (hex.length() / 2);
                       byte[] result = new byte[len];
                       char[] achar = hex.toCharArray();
                       for (int i = 0; i < len; i++) {
                        int pos = i * 2;
                        result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
                       }
                       return result;
                   }

                   private static byte toByte(char c) {
                       byte b = (byte) "0123456789ABCDEF".indexOf(c);
                       return b;
                   }
   public static void main(String[] args){
     String enc=HsDes.enc("tamcx20");
     System.out.println(enc);
     String des=HsDes.dec(enc);
     System.out.println(des);
   }

   }
