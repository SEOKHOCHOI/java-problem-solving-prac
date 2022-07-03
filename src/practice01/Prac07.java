package practice01;

import java.util.Arrays;
import java.util.Scanner;

public class Prac07 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("[로또 당첨 프로그램]");

        System.out.println();
        System.out.println();

        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");

        // 1. 로또 구매 수량 입력
        int numberOfPurchases = kb.nextInt();

        // 2. 입력한 개수만큼의 로또 개수 생성
        int[][] lottoNumbers = new int[numberOfPurchases][6];
        for ( int i = 0; i < numberOfPurchases; i++) {
            for (int j = 0; j < 6; j++) {

                lottoNumbers[i][j] = (int)(Math.random() * 45) + 1;

                // 중복 제거
                if (j > 0) {
                    for ( int z = j + 1; z < 6; z++ ) {
                        if ( lottoNumbers[i][j] == lottoNumbers[i][z]) {
                            j--;
                        }
                    }
                }
            }
        }

        for ( int i = 0; i < numberOfPurchases; i++ ) {
            System.out.print((char)(65 + i) + "    ");
            for ( int j = 0; j < 6; j++) {
                System.out.printf("%02d",lottoNumbers[i][j]);
                if ( j <= 4 ) System.out.print(" ,");
                else if (j == 5) System.out.println();
            }
        }

        // 3. 로또 당첨 번호 생성
        int[] winningNumber = new int[6];
        for ( int k = 0; k < winningNumber.length; k++) {
            winningNumber[k] = (int)(Math.random() * 45) + 1;

            // 중복 제거
            if (k > 0) {
                for ( int z = k + 1; z < 6; z++ ) {
                    if ( lottoNumbers[k] == lottoNumbers[z]) {
                        k--;
                    }
                }
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("[로또 발표]");
        System.out.print("    ");
        for (int i =0; i < 6; i++) {
            System.out.printf("%02d", winningNumber[i]);
            if (i <= 4) System.out.print(" ,");
        }

        System.out.println();
        System.out.println();

        // 4. 담천 번호와 구매 로또 비교하여 숫자 일치 여부 판단
        System.out.println("[내 로또 결과]");
        int count = 0;
        for ( int i = 0; i < numberOfPurchases; i++ ) {
            System.out.print((char)(65 + i) + "    ");
            for ( int j = 0; j < 6; j++) {

                for( int k = 0; k < 6; k++) {
                    if (winningNumber[j] == lottoNumbers[i][k]) {
                          count++;
                    }
                }

                System.out.printf("%02d", lottoNumbers[i][j]);
                if ( j <= 4 ) System.out.print(" ,");
                else if (j == 5) {
                    System.out.printf(" => %d개 일치%n", count);
                    count = 0;
                }
            }
        }
    }
}
