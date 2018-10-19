# numberBaseConversion
# 利用四则运算方式实现N到M的进制转换

  1. 原理：
	1.1 
	
	10进制转成N进制：
	
	除N取余，逆序排列
	
	逆序排列使用StringBuilder类的reverse()函数来实现。
	
	1.2
	N进制数转成10进制数：
	
	按权展开：权是N的ex次幂，例如2进制：1110=1*2^3+1*2^2+1*2^1+0*2^0 =8+4+2+0=14
	
	权的展开使用了Math.pow()方法
	
	1.3
	N进制转M进制数：
	
	通过以上两个基准方法先将N进制转10进制再将得到的10进制数转为M进制数
	
	
	注意：
	非10进制数无法用基本数据类型int long表示，如”AAA“，所以只能通过转为十进制数来进行四则运算并且需要一个转换对照表【char数组】，这里使用的是String BASE_CODE作为对照表，使用charAt和indexOf两个方法实现数字的解析。
	2转4 4转8 可以通过运算方式实现，计算效率更高，更适用于生产场景
	参考：https://blog.csdn.net/u010137760/article/details/52610442?utm_source=blogxgwz2
