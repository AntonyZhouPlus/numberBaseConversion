package com.zhouhang.demo;

/**
 * @author zhouhang
 * @project_name numberBaseConversion
 * @package com.zhouhang.demo
 * @date 2018/10/12
 * 关于进制转换的轮子们
 *
 *
 * 以下方式为最易理解的数学方式
 */
public class Demo {

    /**
     * 10进制整数转换为N进制整数。 10进制转换为N进制的方法是：这个10进制数除以N,求出余数，并把余数倒叙排列。 除N取余，倒叙排列
     * @param tenRadix
     *            十进制整数
     * @param radix
     *            要转换的进制数，例如，要转成2进制数，radix就传入2
     * @return radix进制的字符串
     *
     *
     * 数学公式: （tenRadix%radix）第末位
     */
    public static String string10ToN(int tenRadix, int radix)
    {
        // 进制编码支持9+26=35进制
        String code = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder buf = new StringBuilder();
        int remainder = 0;
        while (tenRadix != 0)
        {
            remainder = tenRadix % radix;// 求余数
            tenRadix = tenRadix / radix;// 除以基数
            buf.append(code.charAt(remainder));// 保存余数，记得要倒叙排列
        }
        buf.reverse();// 倒叙排列
        return buf.toString();
    }

    /**
     * 返回N进制对应的10进制数。
     *
     * @param N_num
     *            N进制数
     * @param radix
     *            N进制计数
     * @return N进制数对应的10进制数
     */
    public static int stringNTo10(String N_num, int radix)
    {
        StringBuilder stringBuilder = new StringBuilder(N_num);
        stringBuilder.reverse();// 反转字符，为了把权重最大的放在最右边，便于下面从左到右遍历，根据下标求权重。
        //如果不反转，从右向左遍历(从字符串下标大的一端)也可以
        char bitCh;
        int result = 0;
        for (int i = 0; i < stringBuilder.length(); i++)
        {
            bitCh = stringBuilder.charAt(i);
            if (bitCh >= '0' && bitCh <= '9')
            {
                // '0'对应的ASCII码整数：48
                result += (int) (bitCh - '0') * Math.pow(radix, i);
            } else if (bitCh >= 'A' && bitCh <= 'Z')
            {
                // 减去'A'的ASCII码值(65),再加上10
                result += ((int) (bitCh - 'A') + 10) * Math.pow(radix, i);
            } else if (bitCh >= 'a' && bitCh <= 'z')
            {
                // 减去'a'的ASCII码值(97),再加上10
                result += ((int) (bitCh - 'a') + 10) * Math.pow(radix, i);
            }
        }
        return result;
    }


    /**
     * 把nRadix进制数nRadixNum转换为m进制数字符串并返回。
     * 具体做法是先把nRadix的nRadixNum转换成10进制数，然后再把这个10进制数转换成mRadix进制数。
     *
     * @param nRadixNum
     *            n进制数
     * @param nRadix
     *            n进制的基数
     * @param mRadix
     *            要转成的进制数基数m
     * @return m进制数字符串
     */
    public static String stringNToM(String nRadixNum, int nRadix, int mRadix)
    {
        return string10ToN(stringNTo10(nRadixNum, nRadix), mRadix);
    }



}
