package ms.graphDFS;

//3.给一个无向图，N个顶点，M条边，0为起点，N-1为终点，每条边初始权值为 1。图中除普通节点外有 4 种节点。#
//        第一种：走过这种节点后的两条边权值翻倍(Sand)
//
//        第二种：走过这种节点后的两条边权值减半 (Nitro)
//
//        第三种：走到这个节点就停止，不能再走了(Cop)
//
//        第四种：走到这个节点，下一条边的权值+1(Crash)
//
//        求节点 0 到 N-1 的最短权值和路径。
//
//        类似于图的深度优先遍历，需要进行回溯

import java.util.*;

public class GraphDFS {

    class Path {
        List<Integer> path;
        double cost;

        public Path(List<Integer> path, double cost) {
            this.path = path;
            this.cost = cost;
        }
    }

    //存储最短路径
    Path minPath = new Path(new ArrayList<>(), Integer.MAX_VALUE);

    public int[] minTimes(int city, String[] strs, int road, int[][] arr) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> set;
            if (!map.containsKey(arr[i][0])) {
                set = new HashSet<>();
            } else {
                set = map.get(arr[i][0]);
            }
            set.add(arr[i][1]);
            map.put(arr[i][0], set);
        }
        Path path = new Path(new ArrayList<>(), 0);

        dfs(0, city - 1, strs, map, path);

        int[] res = new int[minPath.path.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = minPath.path.get(i);
        }
        return res;

    }

    //计算起点到终点的花费
    public double cal(String[] strs, Path path) {
        double res = 0;
        int size = path.path.size();
        double[] cost = new double[size - 1];
        Arrays.fill(cost, 1);
        for (int i = 0; i < size; i++) {
            if (strs[path.path.get(i)].equals("Nitro")) {
                if (i < size - 1) {
                    cost[i] *= 0.5;
                }
                if (i + 1 < size - 1) {
                    cost[i + 1] *= 0.5;
                }

            } else if (strs[path.path.get(i)].equals("Sand")) {
                if (i < size - 1) {
                    cost[i] *= 2;
                }
                if (i + 1 < size - 1) {
                    cost[i + 1] *= 2;
                }

            } else if (strs[path.path.get(i)].equals("Crash")) {
                if (i < size - 1) {
                    cost[i] += 1;
                }
            }

        }

        for (int i = 0; i < cost.length; i++) {
            res += cost[i];
        }
        return res;

    }
    //图的深度优先遍历
    public void dfs(int begin, int end, String[] strs, Map<Integer, Set<Integer>> map, Path path) {
        if (begin == end) {
            path.path.add(end);
            double cost = cal(strs, path);
            if (cost < minPath.cost) {
                // 一定要使用new ArrayList<>(path.path)。
                // 直接传入path.path，会导致返回的minPath.path为空，这是由于Java的值传递导致的。
                minPath = new Path(new ArrayList<>(path.path), cost);
                //                System.out.println("cost:" + cost);
                //                System.out.println("minPath" + minPath.path.toString());
            }
            //回溯
            path.path.remove(Integer.valueOf(end));

            return;
        }

        Set<Integer> set = map.get(begin);
        //寻找下一个可访问的节点
        for (int nextCity : set) {
            if (path.path.contains(nextCity) || strs[nextCity].equals("Cop")) {
                continue;
            }
            path.path.add(begin);
            dfs(nextCity, end, strs, map, path);
            //回溯
            path.path.remove(Integer.valueOf(begin));

        }

    }

//    Test1:
//    int city = 5;
//    int road = 5;
//    String[] strs = {"None", "Cop", "None", "None", "None"};
//    int[][] map = {{0, 1}, {0, 2}, {1, 2}, {2, 3}, {3, 4}};
//
//    result：{0,2,3,4}
//
//    Test2:
//    int city1 = 7;
//    int road1 = 8;
//    String[] strs1 = {"None", "Cop", "Sand", "None", "Nitro", "None", "None"};
//    int[][] map1 = {{0, 1}, {0, 2}, {1, 2}, {2, 3}, {2, 4}, {3, 6}, {4, 5}, {5, 6}};
//
//    result：{0,2,4,5,6}

}
