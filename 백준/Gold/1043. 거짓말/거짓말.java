import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalPeopleCount = Integer.parseInt(st.nextToken());
        int totalPartyCount = Integer.parseInt(st.nextToken());
        
        parent = new int[totalPeopleCount+1];
        for(int i=0; i<=totalPeopleCount; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthPeopleCount = Integer.parseInt(st.nextToken());

        if(truthPeopleCount>0) {
            for(int i=0; i<truthPeopleCount; i++){
                union(0,Integer.parseInt(st.nextToken()));
            }
        }
        

        int[] partys = new int[totalPartyCount];
        for(int i=0; i<totalPartyCount; i++){
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            int leader = Integer.parseInt(st.nextToken());
            partys[i] = leader;
            for(int j=1; j<partySize; j++){
                // 파티에 온 모든 이들을 한 그룹으로 묶기, 뭐랑묶어야하지? 파티번호랑?
                // 만약 파티온 사람이 1명이면 어쩔건데?
                // 모르겠으니까 일단 2명 이상온 팀만 묶자
                // 아닌가.. 파티랑 뭔갈 묶어야하는건가 모르겠네
                // 맞는진 모르겠지만 파티 대장을 담는 변수를 따로 만들자
                int guest = Integer.parseInt(st.nextToken());
                union(leader, guest);
            }
        }

        int result = 0;
        for(int i=0; i<totalPartyCount; i++){
            if(find(partys[i])!=0) result++;
        }

        System.out.println(result);


    }

    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        // 만약에 0을 전부 한부모로 안하고 (진실을아는자 3,1,5일경우) 5 <- 0, 3->0, 1->0 이런식으로 부모를 설정해도 정상동작하나?
        if(ra!=rb){
            if(ra>rb) {
                parent[ra] = rb;
            } else {
                parent[rb] = ra;
            }
        }
    }
}