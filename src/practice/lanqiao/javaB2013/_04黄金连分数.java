package practice.lanqiao.javaB2013;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 标题: 黄金连分数
 * 黄金分割数0.61803... 是个无理数，这个常数十分重要，在许多工程问题中会出现。有时需要把这个数字求得很精确。
 * 对于某些精密工程，常数的精度很重要。也许你听说过哈勃太空望远镜，它首次升空后就发现了一处人工加工错误，对那样一个庞然大物，
 * 其实只是镜面加工时有比头发丝还细许多倍的一处错误而已，却使它成了“近视眼”!!
 * 言归正传，我们如何求得黄金分割数的尽可能精确的值呢？有许多方法。
 * 比较简单的一种是用连分数：
 * <p>
 *                 1
 * 黄金数 = ---------------------
 *                  1
 *         1 + -----------------
 *                      1
 *              1 + -------------
 *                          1
 *                  1 + ---------
 *                          1 + ...
 * <p>
 * 这个连分数计算的“层数”越多，它的值越接近黄金分割数。
 * 请你利用这一特性，求出黄金分割数的足够精确值，要求四舍五入到小数点后100位。
 * 小数点后3位的值为：0.618
 * 小数点后4位的值为：0.6180
 * 小数点后5位的值为：0.61803
 * 小数点后7位的值为：0.6180340
 * （注意尾部的0，不能忽略）
 * 你的任务是：写出精确到小数点后100位精度的黄金分割值。
 * 注意：尾数的四舍五入！ 尾数是0也要保留！
 * 显然答案是一个小数，其小数点后有100位数字，请通过浏览器直接提交该数字。
 * 注意：不要提交解答过程，或其它辅助说明类的内容。
 */
//1.化为求斐波那契相邻两项的比值，到多少项？越多越精确，n/n+1项，
// n再往上增加，这个比值的小数点后101位是稳定的，也就是不变的
//2.double无法表示100位小数，BigInteger和BigDecimal
// 化简成分数(1, 1/2, 2/3...)-》由分数观察得为斐波那契数列(1,2,3,5,8...)-》利用 BigInteger 计算斐波那契
public class _04黄金连分数 {
    public static void main(String[] args) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        //斐波那契数列的迭代形式
        for (int i = 3; i < 500; i++) {
//      BigInteger t=b;
//      b=a.add(b);//大整数的加法
//      a=t;
            BigInteger t = a.add(b);
            a = b;
            b = t;
        }
        //大浮点数的除法
        BigDecimal divide = new BigDecimal(a, 110).divide(new BigDecimal(b, 110), BigDecimal.ROUND_HALF_DOWN);
        //截取字符串
        System.out.println(divide.toPlainString().substring(0, 103));
    }
}
//0.6180339887498948482045868343656381177203091798057628621354486227052604628189024497072072041893911375
//0.61803398874989484820458683436563811772030917980576286213544862270526046281890244970720720418939113748