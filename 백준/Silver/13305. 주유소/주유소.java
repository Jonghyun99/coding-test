import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCount = Integer.parseInt(st.nextToken());

        City[] citys = new City[cityCount];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cityCount-1; i++) {
            // distance는 int 범위여도 합치면 long이 될 수 있어 주의 필요하지만, 입력은 int로 받음
            citys[i] = new City(Integer.parseInt(st.nextToken()), 0);
        }

        citys[cityCount-1] = new City(0, 0);
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cityCount; i++) {
            citys[i].oilPrice = Integer.parseInt(st.nextToken());
        }

        // [수정 1] 총 비용은 int 범위를 넘을 수 있으므로 long 사용
        long price = 0; 

        // [수정 2] i++를 제거 (안쪽 루프 끝난 지점으로 i를 점프시키기 위해)
        for(int i=0; i<cityCount-1; ) { 
            City nowCity = citys[i];
            int nowOilPrice = nowCity.oilPrice;
            
            // 현재 주유소 가격으로 어디까지 갈지 계산할 거리 변수
            long distanceToDrive = 0; 
            
            // 다음 이동할 도시의 인덱스를 저장할 변수
            int nextCityIndex = cityCount - 1; 

            // 현재 도시(i)보다 더 싼 도시(j)를 찾으러 출발
            for(int j=i+1; j<cityCount; j++) {
                
                // [수정 3] 거리 누적: j-1번째 도시의 거리(distance)가 j로 가는 길임
                distanceToDrive += citys[j-1].distance;

                int nextOilPrice = citys[j].oilPrice;

                // 더 싼 주유소를 찾았다!
                if(nowOilPrice > nextOilPrice) {
                    // 여기까지(j)만 현재 가격으로 계산하고 탈출
                    price += (long)nowOilPrice * distanceToDrive;
                    nextCityIndex = j; // 다음 시작점은 여기(j)
                    break;
                } 
                
                // 만약 마지막 도시까지 더 싼 곳이 없다면?
                if(j == cityCount - 1) {
                     price += (long)nowOilPrice * distanceToDrive;
                     nextCityIndex = cityCount; // 끝까지 계산 완료
                }
            }
            
            // [수정 4] 이미 계산한 구간은 건너뛰기 위해 i를 j(nextCityIndex)로 점프
            i = nextCityIndex;
        }
        System.out.println(price);
    }
}

class City {
    int distance;
    int oilPrice;

    City (int distance, int oilPrice) {
        this.distance = distance;
        this.oilPrice = oilPrice;
    }
}