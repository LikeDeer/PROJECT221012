package Practice7_6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        HashMap<String, Location> locationHashMap = new HashMap<String, Location>();
        Scanner scanner = new Scanner(System.in);

        // 도시 정보 입력
        System.out.println("도시, 경도, 위도를 입력하세요.");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String input = scanner.nextLine();
            String[] splitting = input.split(", ");

            locationHashMap.put(
                    splitting[0],
                    new Location(splitting[0],
                            Double.parseDouble(splitting[1]),
                            Double.parseDouble(splitting[2])));
        }
        System.out.println("------------------------");

        // 모든 도시 출력
        Set<String> locationHashMapKeys = locationHashMap.keySet();
        for (String keys : locationHashMapKeys) {       // Collection 과 forEach
            System.out.println(locationHashMap.get(keys).getCityName() +
                    "\t" + locationHashMap.get(keys).getLatitude() +
                    "\t" + locationHashMap.get(keys).getLongitude());
        }
        System.out.println("------------------------");

        // 검색
        while (true) {
            // 검색 입력
            System.out.print("도시 이름 >> ");
            String searchCityName = scanner.nextLine();

            if (searchCityName.equals("그만"))
                break;      // 프로그램 종료

            // 탐색 및 출력
            Iterator<String> iterator_set = locationHashMapKeys.iterator();
            while (iterator_set.hasNext()) {
                String nextKey = iterator_set.next();
                if (locationHashMap.get(nextKey).getCityName().equals(searchCityName)) {
                    System.out.println(locationHashMap.get(nextKey).getCityName() +
                            "\t\t" + locationHashMap.get(nextKey).getLatitude() +
                            "\t\t" + locationHashMap.get(nextKey).getLongitude());
                    searchCityName = "Found";
                    break;
                }
            }
            if (!(searchCityName.equals("Found"))) {
                System.out.println(searchCityName + "는 없습니다.");
            }
        }

        scanner.close();
    }
}
