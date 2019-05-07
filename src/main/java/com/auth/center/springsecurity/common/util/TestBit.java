package com.auth.center.springsecurity.common.util;

import java.math.BigInteger;

/**
 * ClassName: <br>
 * Function: <br>
 * date: 2019/4/21 上午7:27<br>
 * @author liqiangqiang<br>
 * @version
 * @since JDK 1.8
 */
public class TestBit {
    public static void main(String[] args) {
//        BigInteger bi = new BigInteger("12");

        //testBit 的判断条件为((this & (1<<n)) != 0    当且仅当指定的位被设置时返回true。
//        System.err.println("Test Bit on " + bi + " at index 1 returns  "+bi.testBit(1));
//        System.err.println("Test Bit on " + bi + " at index 2 returns  "+bi.testBit(2));
//        System.err.println("Test Bit on " + bi + " at index 3 returns  "+bi.testBit(3));
//        System.err.println("Test Bit on " + bi + " at index 4 returns  "+bi.testBit(4));
        //12 的二进制表示为1100
        //1    的二进制表示为0001  ,1<<1 为00000010,  (this & (1<<1))为0,bi.testBit(1)为FALSE
        //2    的二进制表示为0010  ,1<<2 为00000100,  (this & (1<<2))为4,bi.testBit(2)为true
        //3    的二进制表示为0011  ,1<<3 为00001000,  (this & (1<<3))为8,bi.testBit(3)为true
        //4    的二进制表示为0100  ,1<<4 为00010000,  (this & (1<<4))为0,bi.testBit(4)为FALSE
//        System.out.println(Integer.toBinaryString(1<<3));
//        System.out.println(Integer.toBinaryString(1<<4));
//        System.out.println(Integer.toBinaryString(1<<5));
//        System.out.println(Integer.toBinaryString(1<<6));
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i+" values: "+Integer.toBinaryString(i));
//        }

//        String muleId="1,2,36,37,39,38,43,3,40,41,42,9,44,62,61,53,8,6,7,51,52,54,55,57,56,58,22,23,24,30,31,33,45,47,46,34,32,35";
//
//        BigInteger rights=RightsHelper.sumRights(Tools.str2StrArray(muleId.trim(),","));
//        System.out.println(rights);
//
//        System.out.println(new BigInteger("36").testBit(0));
//        System.out.println(new BigInteger("36").testBit(1));
        BigInteger b1=new BigInteger("0");
//        System.out.println(b1=b1.setBit(1));
//        System.out.println(b1=b1.setBit(2));
        System.out.println(b1.setBit(10000));
    }
}
