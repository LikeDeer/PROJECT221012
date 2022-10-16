package Practice7_4;

import java.util.Scanner;
import java.util.Vector;

public class Solution {
    public static void main(String[] args) {
        Vector<Integer> rainfallVector = new Vector<Integer>();
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        while (true) {
            System.out.print("강수량 입력 (0 입력시 종료)>> ");
            int input = scanner.nextInt();

            if (input == 0) break;

            rainfallVector.add(input);
            sum += input;

            // 입력된 모든 강수량 출력
            for (int i = 0; i < rainfallVector.size(); i++) {
                System.out.print(rainfallVector.get(i) + " ");
            }

            // 평균 출력
            System.out.println("\n현재 평균 " +
                    sum / rainfallVector.size());
        }

        scanner.close();
    }
}
