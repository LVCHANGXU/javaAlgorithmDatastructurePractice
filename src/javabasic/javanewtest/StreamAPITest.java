package javabasic.javanewtest;

/**
 * String 关注的是数据的运算，与 CPU 打交道
 * 集合关注的是数据的存储，与内存打交道
 * <p>
 * Stream 自己不会存储元素
 * 不会改变源对象。相反，它们会返回一个持有结果的新 Stream
 * 操作是延迟执行的。这意味着它们会等到需要结果的时候才执行
 * <p>
 * Stream 执行流程
 * 1. 实例化
 * 2. 一系列的中间操作（过滤、映射等）
 * 3. 终止操作
 * <p>
 * 说明：
 * 1. 一个中间操作链，对数据源的数据进行处理
 * 2. 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用，要想重新使用，得重新实例化。
 */
public class StreamAPITest {
}
