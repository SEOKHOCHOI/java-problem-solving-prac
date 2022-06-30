package practice01;
import java.util.Scanner;

public class Prac02 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요.(금액):");
        int amount = kb.nextInt();
        int cashback = 0;
        if (amount * 0.1 <= 300) {
            cashback = (int)Math.floor((amount * 0.1)/100) * 100;
        } else if (amount * 0.1 > 300) {
            cashback = 300;
        }
        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", amount, cashback);
    }
}
