package practice.lanqiao.javaB2013;/*

标题：幸运数

    幸运数是波兰数学家乌拉姆命名的。它采用与生成素数类似的“筛法”生成。

    首先从1开始写出自然数1,2,3,4,5,6,....

    1 就是第一个幸运数。
    我们从2这个数开始。把所有序号能被2整除的项删除，变为：

    1 _ 3 _ 5 _ 7 _ 9 ....

    把它们缩紧，重新记序，为：

    1 3 5 7 9 .... 。这时，3为第2个幸运数，然后把所有能被3整除的序号位置的数删去。
    注意，是序号位置，不是那个数本身能否被3整除!! 删除的应该是5，11, 17, ...

    此时7为第3个幸运数，然后再删去序号位置能被7整除的(19,39,...)

    最后剩下的序列类似：

    1, 3, 7, 9, 13, 15, 21, 25, 31, 33, 37, 43, 49, 51, 63, 67, 69, 73, 75, 79, ...

本题要求：

输入两个正整数m n, 用空格分开 (m < n < 1000*1000)
程序输出 位于m和n之间的幸运数的个数（不包含m和n）。

例如：
用户输入：
1 20
程序输出：
5

例如：
用户输入：
30 69
程序输出：
8

资源约定：
峰值内存消耗（含虚拟机） < 64M
CPU消耗  < 2000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.6及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。


*/

import java.util.Scanner;

public class _08幸运数 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int[] a = new int[n];//存储数据的数组
    for (int i = 0; i < n; i++) {
      a[i] = 2 * i + 1;
    }
    //已经把2的倍数（位置）删除了

    int l = 1;//幸运数的下标,a[l]是幸运数
    while (true) {
      int p = l + 1;//数字向前挪动的坑位
      for (int i = l + 1; i < n; i++) {
        if ((i + 1) % a[l] == 0) {
        } else {
          a[p] = a[i];
          p++;
        }
        // if (a[i]>n)break;//更正：此处应该是下方的代码
        if (a[p]>n)break;
      }

      // for (int i = 0; i < len; i++) {
      //   System.out.print(a[i] + " ");
      // }
      // System.out.println();
      l++;
      if(a[l]>=n)break;
    }
    int ans=0;
    for (int i = 0; i < n; i++) {
      if (a[i]>=n)break;
      if (a[i]>m)ans++;
    }
    System.out.println(ans);
  }
}
