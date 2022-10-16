package Practice7_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Double> scoreList = new ArrayList<Double>();
        Scanner scanner = new Scanner(System.in);

        // 점수 입력
        System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>");
        for (int i = 0; i < 6; i++) {
            char oneScore = scanner.next().charAt(0);
            switch (oneScore) {
                case 'a':
                case 'A':
                    scoreList.add(4.0); break;
                case 'b':
                case 'B':
                    scoreList.add(3.0); break;
                case 'c':
                case 'C':
                    scoreList.add(2.0); break;
                case 'd':
                case 'D':
                    scoreList.add(1.0); break;
                case 'f':
                case 'F':
                    scoreList.add(0.0); break;
                default:
                    System.out.println("Wrong score input. Ignored.");
            }
        }

        // 평균 계산
        double sum = 0;
        for (int i = 0; i < scoreList.size(); i++) {
            sum += scoreList.get(i);
        }
        double avg = sum / scoreList.size();
        System.out.println(avg);
    }
}
