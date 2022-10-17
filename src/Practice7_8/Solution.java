package Practice7_8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        HashMap<String, Integer> pointManagement = new HashMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("** 포인트 관리 프로그램입니다 **");

        while (true) {
            // 입력부
            System.out.print("이름과 포인트 입력>> ");
            String inputName = scanner.next();
            if (inputName.equals("그만")) break;  // 프로그램 종료
            Integer inputPoint = scanner.nextInt();
            scanner.nextLine();

            // 이미 해쉬맵에 있는 이름이라면 누적, 저장. 아니면 그냥 저장.
            Integer temp = pointManagement.get(inputName);
            if (temp != null)
                inputPoint += temp;
            pointManagement.put(inputName, inputPoint);

            // 출력
            Iterator<String> iterator_hashMap = pointManagement.keySet().iterator();
            while (iterator_hashMap.hasNext()) {
                String key = iterator_hashMap.next();
                System.out.print("(" + key + "," + pointManagement.get(key) + ")");
            }
            System.out.println();
        }
    }

}
