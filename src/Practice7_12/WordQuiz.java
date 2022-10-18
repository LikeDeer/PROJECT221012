package Practice7_12;

import java.util.Scanner;
import java.util.Vector;

public class WordQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 단어 리스트 생성
        Vector<Word> wordVector = new Vector<>();
        fillingVector(wordVector);

        System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
        wordTest(wordVector);

        int command;
        do {
            System.out.print("단어 테스트:1, 단어 삽입:2, 종료:3>>");
            command = scanner.nextInt();

            switch (command) {
                case 1:
                    wordTest(wordVector);
                    break;
                case 2:
                    puttingWord(wordVector);
                    break;
                case 3:
                    System.out.println("프로그램 종료.");
                    break;          // 종료
                default:
                    System.out.println("명령 입력 오류!");
                    break;
            }
        } while (command != 3);

        scanner.close();
    }

    static void wordTest(Vector<Word> wordVector) {
        System.out.println("현재 " + wordVector.size() + "개의 단어가 들어 있습니다.");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 문제 단어 고르기
            // System.out.println("DEBUG >> 문제 단어 고르기");
            int randomProblem = (int)(Math.random() * wordVector.size());  // randomProblem: Vector 내 정답 단어 인덱스(0 ~ 19)
            // System.out.println("DEBUG >> randomProblem = " + randomProblem);

            // 문제와 랜덤 단어들 선택지 번호 매기기
            // System.out.println("DEBUG >> 문제와 랜덤 단어들 선택지 번호 매기기");
            int[] choices = new int[4];                      // choices[0~3]: 정답을 포함한 문제 인덱스 정수 배열
            int wheresAnswer = (int)(Math.random() * 4);       // wheresAnswer: choices 의 정답 위치(0 ~ 3)
            // System.out.println("DEBUG >> wheresAnswer = " + wheresAnswer);
            choices[wheresAnswer] = randomProblem;
            for (int i = 0; i < 4; i++) {
                if (i == wheresAnswer) continue;        // 이미 정답으로 선점된 곳이라면 패스
                int otherProblem;           // otherProblem: (지역) 다른 단어 인덱스
                do {
                    otherProblem = (int)(Math.random() * wordVector.size());
                    // System.out.println("DEBUG >> otherProblem = " + otherProblem);
                } while (otherProblem == randomProblem);
                choices[i] = otherProblem;                  // choices 에 다른 단어들 인덱스로 채움.
            }

            // 문제 출력
            // System.out.println("DEBUG >> 문제 출력");
            System.out.println(wordVector.get(randomProblem).getEng() + "?");
            for (int i = 0; i < 4; i++) {
                System.out.print("(" + (i + 1) + ")" + wordVector.get(choices[i]).getKor() + " ");
            }
            System.out.print(":>");

            // 입력부
            // System.out.println("DEBUG >> 입력부");
            int input = scanner.nextInt();

            // exit 확인
            // System.out.println("DEBUG >> exit 확인");
            if (input == -1) {
                System.out.println("\"명품영어\"를 종료합니다...");
                break;
            }

            // 정답 확인
            // System.out.println("DEBUG >> 정답 확인");
            if (wheresAnswer == input - 1) {                // input 과 wheresAnswer 비교
                System.out.println("Excellent !!");
            } else {
                System.out.println("No. !!");
            }
        }

        scanner.close();
    }

    static void fillingVector(Vector<Word> wordCollection) {
        wordCollection.add(new Word("love", "사랑"));
        wordCollection.add(new Word("cloud", "구름"));
        wordCollection.add(new Word("water", "물"));
        wordCollection.add(new Word("information", "정보"));
        wordCollection.add(new Word("chair", "의자"));

        wordCollection.add(new Word("book", "책"));
        wordCollection.add(new Word("glass", "유리"));
        wordCollection.add(new Word("wood", "목재"));
        wordCollection.add(new Word("cloth", "천"));
        wordCollection.add(new Word("schedule", "일과"));

        wordCollection.add(new Word("dictionary", "사전"));
        wordCollection.add(new Word("skirt", "치마"));
        wordCollection.add(new Word("bread", "빵"));
        wordCollection.add(new Word("light bulb", "전구"));
        wordCollection.add(new Word("nose", "코"));

        wordCollection.add(new Word("health", "건강"));
        wordCollection.add(new Word("budget", "예산"));
        wordCollection.add(new Word("city", "도시"));
        wordCollection.add(new Word("library", "도서관"));
        wordCollection.add(new Word("dish", "접시"));
    }

    static void puttingWord(Vector<Word> wordCollection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");

        while (true) {
            System.out.print("영어 한글 입력 >> ");
            String eng = scanner.next();
            if (eng.equals("그만")) break;
            String kor = scanner.next();
            wordCollection.add(new Word(eng, kor));
        }
        scanner.close();
    }
}
