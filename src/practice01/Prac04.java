package practice01;
import java.util.Random;
import java.util.Scanner;

public class Prac04 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        String year = kb.next();
        System.out.println();

        System.out.print("출생월을 입력해 주세요.(mm):");
        String month = kb.next();
        System.out.println();

        System.out.print("출생일을 입력해 주세요.(dd):");
        String day = kb.next();
        System.out.println();

        System.out.print("성별을 입력해 주세요.(m/f):");
        String sex = kb.next();
        if ( sex.equals("m") ) {
            sex = "3";
        } else if ( sex.equals("f") ) {
            sex = "4";
        }

        System.out.println();

        Random random = new Random();
        int[] randomNumArr = new int[6];
        for ( int i = 0; i < 6; i++) {
            randomNumArr[i] = random.nextInt(9) + 1;
        }

        System.out.println(year + month + day + "-" + sex + randomNumArr[0] +
                randomNumArr[1] + randomNumArr[2] +
                randomNumArr[3] + randomNumArr[4] +
                randomNumArr[5]);
    }
}
