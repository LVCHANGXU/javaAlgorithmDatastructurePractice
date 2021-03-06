package algorithm.prim;

import java.util.Arrays;

/**
 * 普利姆算法，处理最小生成树(树的权值最小)
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示，10000 表示这个大数，两个点不连通
        int[][] weight = new int[][] {
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };


        //创建 MGraph 对象
        MGraph graph = new MGraph(verxs);
        //创建一个 MinTree 对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph,verxs,data,weight);

        minTree.showGraph(graph);
        minTree.prim(graph,1); //树的权值为 25

    }

    static class MinTree {
        //创建图的邻接矩阵

        /**
         *
         * @param graph 图对象
         * @param verxs 图对应的顶点个数
         * @param data 图的各个顶点的值
         * @param weight 图的邻接矩阵
         */
        public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
            for (int i = 0; i < verxs; i++) {
                graph.data[i] = data[i];
                for (int j = 0; j < verxs; j++) {
                    graph.weight[i][j] = weight[i][j];
                } //end for
            } //end for
        } //end createGraph()

        /**
         * 显示图的邻接矩阵
         * @param graph
         */
        public void showGraph(MGraph graph) {
            for (int[] link : graph.weight) {
                System.out.println(Arrays.toString(link));
            } //end for
        } //end showGraph()


        /**
         * 实现普利姆算法
         * @param graph
         * @param v
         */
        public void prim(MGraph graph, int v) {
            //标记节点是否被访问过
            int[] visited = new int[graph.verxs];
            //把当前这个节点标记为已访问
            visited[v] = 1;
            //h1 和 h2 记录两个顶点的下标
            int h1 = -1;
            int h2 = -1;
            int minWeight = 10000;
            for (int k = 0; k < graph.verxs; k++) {
                //确定每一次生成的子图
                for (int i = 0; i < graph.verxs; i++) {
                    for (int j = 0; j < graph.verxs; j++) {
                        if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                            minWeight = graph.weight[i][j];
                            h1 = i;
                            h2 = j;
                        } //end if
                    } //end for
                } //end for
                //找到一条边最小
                System.out.println("边<"+graph.data[h1] + "," + graph.data[h2] + ">权值：" + minWeight);
                //将当前这个节点标记为已访问
                visited[h2] = 1;
                minWeight = 10000;
            } //end for
        } //end prim()
    } //end MinTree


    /**
     *
     */
    static class MGraph {
        int verxs; //表示图的节点个数
        char[] data; //存放节点的数据
        int[][] weight; //存放边，邻接矩阵
        public MGraph(int verxs) {
            this.verxs = verxs;
            data = new char[verxs];
            weight = new int[verxs][verxs];
        } //end MGraph()
    } //end MGraph
}
