import brute_force.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        brute_force brute_force = new brute_force();

//        brute_force.bf_2309(args);    //아홉난쟁이 문제
//        brute_force.bf_3085(args);  //사탕게임
//        brute_force.bf_1476(args);  //날짜계산
//        brute_force.bf_1107(args);  //리모컨
//        brute_force.bf_14500(args);  //테트로미노
//        brute_force.bf_6064(args);  //카잉달력
//        brute_force.bf_1748(args);  //수 이어 쓰기1
//        brute_force.dfs_bfs_1260(args);  //DFS와 BFS(인접리스트)
//        brute_force.dfs_bfs_1260_2(args);  //DFS와 BFS(인접리스트)
        brute_force.dfs_bfs_2178(args);  //미로탐색 - BFS(최단경로)

    }
}
