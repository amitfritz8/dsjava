package org.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static class Edge {
        public int u, v;
        public long w;
        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static class UnionFind {
        private int parent[];
        private int rank[];

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findSet(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b) {
            int setA = findSet(a);
            int setB = findSet(b);

            if (rank[setA] > rank[setB]) {
                parent[setB] = setA;
            } else {
                parent[setA] = setB;
                if (rank[setA] == rank[setB]) {
                    rank[setB] += 1;
                }
            }
        }

        public boolean connected(int a, int b) {
            return (findSet(a) == findSet(b));
        }
    }
    
    public static void main(String[] args) {
            long n = 7;
            long m = 6;
            long lib = 3;
            long road = 2;
            int city_1=0 ;
            int city_2=0;
            
            List<Edge> edges = new ArrayList<>();
                edges.add(new Edge(1, 7, road));
                edges.add(new Edge(1, 2, road));
                edges.add(new Edge(1, 3, road));
                edges.add(new Edge(2, 3, road));
                edges.add(new Edge(5, 6, road));
                edges.add(new Edge(6, 8, road));
            
            UnionFind uf = new UnionFind((int)(n + 2));
            long minCost = n * lib;
            long roadCosts = 0;
            long libCosts = n * lib;
            
            for (Edge edge : edges) {
                if (!uf.connected(edge.u, edge.v)) {
                    uf.union(edge.u, edge.v);
                    roadCosts += road;
                    libCosts -= lib;
                    minCost = Math.min(minCost, roadCosts + libCosts);
                }
            }
            
            System.out.println(minCost);
    }
}



//2
//3 3 2 1
//1 2
//3 1
//2 3
//6 6 2 5
//1 3
//3 4
//2 4
//1 2
//2 3
//5 6