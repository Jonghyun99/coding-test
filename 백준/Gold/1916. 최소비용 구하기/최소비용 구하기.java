import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;



// 도시의 개수 1<=N<=1000, 버스의 개수 1<=M<=100000
// 3번째 줄: 버스의 정보, startCity, endCity, price
// 마지막 줄: 임의 출발점과 도착점번호
// 마지막 줄의 노드 간 최소 비용을 출력해라
// 시간제한 0.5초, 다익스트라 사용, 예상 시간복잡도 O(V+E)??

// visited, adjGraph, 각 도시별 최소금액 담을 금액, visited 대신 money 변수로 사용
// 내가 생각한 풀이법: 출발점에서 모든 노드를 통한 도착지점을 향한 가장 싼 경로를 탐색한다.
// 현재 가장 저렴한 루트를 찾기 위해 Priroity 사용, (굳이 Prirotiy Queue안써도 DFS나 BFS만으로도 될 것 같은데 맞나?)
// 도중 현재까지의 가장 싼 경로보다 비싸지면, 해당 탐색은 취소하고 이어간다.
// 현재까지의 가장 싼 경로는 배열이 아닌 int 변수에 담아서 해보자
// 흠.. visited 배열이 필요한가? money 비교로 커버 되려나??

public class Main {
    static int resultMoney = Integer.MAX_VALUE;
    static ArrayList<BusRoute>[] busGraph;
    static int cityCnt, busCnt, finalStartCity, finalEndCity;
    static int[] minMoney;
    final static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cityCnt = Integer.parseInt(br.readLine());
        busCnt = Integer.parseInt(br.readLine());
        busGraph = new ArrayList[cityCnt+1];
        minMoney = new int[cityCnt+1];
        
        for(int i=0; i<=cityCnt; i++){
            busGraph[i] = new ArrayList<>();
        }
        Arrays.fill(minMoney, INF);
        StringTokenizer st;
        for(int i=0; i<busCnt; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            busGraph[start].add(new BusRoute(end, price));
        }

        st = new StringTokenizer(br.readLine());
        finalStartCity = Integer.parseInt(st.nextToken());
        finalEndCity = Integer.parseInt(st.nextToken());

        dijkstra(finalStartCity, finalEndCity);
        System.out.println(minMoney[finalEndCity]);
    }

    static void dijkstra(int s, int e) {
        PriorityQueue<BusRoute> q = new PriorityQueue<>();
        q.add(new BusRoute(s, 0));
        minMoney[s] = 0;
        while(!q.isEmpty()) {
            BusRoute now = q.poll();
            int nowCity = now.city;
            int nowPrice = now.price;

            if(minMoney[nowCity] < nowPrice) continue;

            for(BusRoute next:busGraph[nowCity]){
                int nextCity = next.city;
                int nextPrice = nowPrice + next.price; 

                if(minMoney[nextCity] > nextPrice){
                    minMoney[nextCity] = nextPrice;
                    q.add(new BusRoute(nextCity, nextPrice));
                }
            }
        }
    }
}

class BusRoute implements Comparable<BusRoute> {
    int city;
    int price;

    BusRoute(int city, int price) {
        this.city = city;
        this.price = price;
    }

    @Override
    public int compareTo(BusRoute o) {
        return Integer.compare(this.price, o.price);
    }
}