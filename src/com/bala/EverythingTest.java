package com.bala;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2021/3/18 17:57
 */

public class EverythingTest {
    @Test
    public void test(){

        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes = "A".getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes.length);
        byte[] encode = encoder.encode(bytes);
        System.out.println(encode.length);
        System.out.println(new String(encode));
    }
}
