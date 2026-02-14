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

public class Main {

    // 도시 별 소요 최소금액
    static int[] minMoney;
    static ArrayList<BusRoute>[] busGraph;
    static int cityCnt, busCnt, firstCity, lastCity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cityCnt = Integer.parseInt(br.readLine());
        busCnt = Integer.parseInt(br.readLine());
        busGraph = new ArrayList[cityCnt+1];
        minMoney = new int[cityCnt+1];

        for(int i=0; i<=cityCnt; i++) {
            busGraph[i] = new ArrayList<>();
            minMoney[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for(int i=0; i<busCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            busGraph[s].add(new BusRoute(e, p));
        }

        st = new StringTokenizer(br.readLine());
        firstCity = Integer.parseInt(st.nextToken());
        lastCity = Integer.parseInt(st.nextToken());

        dijkStra(firstCity, lastCity);

        System.out.println(minMoney[lastCity]);
    }

    static void dijkStra(int firstCity, int lastCity) {
        PriorityQueue<BusRoute> q = new PriorityQueue<>();
        q.add(new BusRoute(firstCity, 0));
        minMoney[firstCity] = 0;
        while(!q.isEmpty()) {
            BusRoute now = q.poll();
            int nowCity = now.city;
            int nowPrice = now.price;

            if(minMoney[nowCity] < nowPrice) continue;

            for(BusRoute next:busGraph[nowCity]) {
                int nextCity = next.city;
                int nextPrice = next.price + nowPrice;

                if(minMoney[nextCity]>nextPrice) {
                    q.add(new BusRoute(nextCity, nextPrice));
                    minMoney[nextCity] = nextPrice;
                }
            }
        }
    }
}

class BusRoute implements Comparable<BusRoute>{
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