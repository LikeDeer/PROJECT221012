package OpenChallenge;

import java.util.Scanner;
import java.util.Vector;

public class WordQuiz {
    public static void main(String[] args) {
        Vector<Word> wordVector = new Vector<Word>();
        fillingVector(wordVector);

        System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
        int size = wordVector.size();
        System.out.println("현재 " + size + "개의 단어가 들어 있습니다.");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 문제 단어 고르기
            int randomProblem = (int)Math.random() % size;  // 0 ~ 19

            // 문제와 랜덤 단어들 선택지 번호 매핑
            int otherWords = 1;
            break;

            // 문제 제시


            // 입력부


            // exit 확인


            // 정답 확인

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
}
