package com.github.zhouzhu.java.base64;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Base64Demo {
    @Test
    public void test1(){
        try {
            String asB64 = Base64.getEncoder().encodeToString("some string".getBytes("utf-8"));
            System.out.println(asB64);
            byte[] asBytes = Base64.getDecoder().decode(asB64);
            System.out.println(new String(asBytes,"utf-8"));
            //URL编码：使用下划线替换URL里面的反斜线“/”
            String urlEncoder = Base64.getUrlEncoder().encodeToString("/subject?abcd".getBytes("utf-8"));
            System.out.println(urlEncoder);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * MIME编码：使用基本的字母数字产生BASE64输出，而且对MIME格式友好：每一行输出不超过76个字符，而且每行以“\r\n”符结束。
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testMIME() throws UnsupportedEncodingException {
        StringBuffer sb=new StringBuffer();
        for (int t=0;t<10;++t){
            sb.append(UUID.randomUUID().toString());
        }
        byte[] toEncode = sb.toString().getBytes("utf-8");
        String mineEncode = Base64.getMimeEncoder().encodeToString(toEncode);
        System.out.println(mineEncode);
    }
}
