package com.zhouhang.test;

import com.zhouhang.demo.Demo;
import org.junit.Test;

/**
 * @author zhouhang
 * @project_name numberBaseConversion
 * @package com.zhouhang.test
 * @date 2018/10/12
 */

public class DemoTest {

    /**
     * 将十进制的10转为16进制
     */
    @Test
    public void testString10ToN() {
        //设置n值
        int n = 16;

        String target = Demo.string10ToN(10, n);
        System.out.println("十进制数："+10+"的"+n+"进制数为:"+target);

    }

    /**
     * 将2进制"1010"的转为10进制
     */
    @Test
    public void testStringNTo10() {
        //设置n值
        String n = "AAA";
        int radix = 16;

        int target = Demo.stringNTo10(n, radix);
        System.out.println(radix+"进制数："+n+"的十进制数为:"+target);

    }

    /**
     * 将2进制"1010"的转为16进制
     */
    @Test
    public void testStingNtoM() {
        int n10 = Demo.stringNTo10("1010", 2);
        String target = Demo.string10ToN(n10, 16);
        System.out.println(target);

        System.out.println("==========");
        System.out.println(Demo.stringNToM("1010", 2, 16));
    }

}
