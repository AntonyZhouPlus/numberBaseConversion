package com.zhouhang.demo;

/**
 * @author zhouhang
 * @project_name numberBaseConversion
 * @package com.zhouhang.demo
 * @date 2018/10/13
 */
public class MyConverter {
    // 进制转换对照表，用于十进制以上的进制转换对照，最大支持10+26*2=62进制
    private static final String BASE_CODE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * 10进制转N进制
     * @param sourceNum 需要进行转换的十进制数
     * @param radix 基数，例如，要转成2进制数，radix就传入2
     * @return 转换后进制的数
     *
     *
     * 基本原理 十进制数每除一次N（目标进制），得到的余数是目标数第末、次末...位数，反复除N直到商为0，最后的余数就是第一位数。
     */
    public static String convert10ToN(int sourceNum,int radix) {

        StringBuilder sb = new StringBuilder();

        // 0的任何进制数都是0
        if (sourceNum == 0) {
            return "0";
        }

        //核心算法
        int remainder = 0;
        while (sourceNum != 0)
        {
            remainder = sourceNum % radix;// 求余数---目标数的其中一位
            sourceNum = sourceNum / radix;// 除以基数得到的商再次作为分母
            sb.append(BASE_CODE.charAt(remainder));// 保存余数，charAt函数刚好得到目标数的字符串表示形式，例如charAt(10)=A
        }

        return sb.reverse().toString();
    }

    /**
     *
     * @param sourceNum 需要进行转换的N进制数
     * @param radix 基数，即N值
     * @return
     *
     * 基本原理 16进制数 AAA 的十进制表示为 A(11) * 16^2 + A(11) * 16^1 + A(11) * 16^0 = 2730;
     */
    public static Integer converNTo10(String sourceNum, int radix) {
        StringBuilder sb = new StringBuilder(sourceNum);
        // 位字符
        char bitCh;
        int result = 0;
        for (int i = 0; i < sb.length(); i--)
        {
            bitCh = sb.charAt(i);
            // 原理和上面差不多，主要是字符与码表的一个转换，码表你可以自己写
            result += BASE_CODE.indexOf(bitCh) * Math.pow(radix, i);
        }
        return result;
    }

    /**
     * 把nRadix进制数nRadixNum转换为m进制数字符串并返回。
     * 具体做法是先把nRadix的nRadixNum转换成10进制数，然后再把这个10进制数转换成mRadix进制数。
     *
     * @param sourceNum
     *            n进制数
     * @param nRadix
     *            n进制的基数
     * @param mRadix
     *            要转成的进制数基数m
     * @return m进制数字符串
     */
    public static String stringNToM(String sourceNum, int nRadix, int mRadix)
    {
        return convert10ToN(converNTo10(sourceNum, nRadix), mRadix);
    }
}
