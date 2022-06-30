package practice01;
import java.util.Scanner;

public class Prac03 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자):");
        int age = kb.nextInt();
        System.out.println();

        System.out.print("입장시간을 입력해 주세요.(숫자입력):");
        int time = kb.nextInt();
        System.out.println();


        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        String nationalMerit = kb.next();
        System.out.println();


        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        String card = kb.next();
        System.out.println();

        int price = 0;
        if (age < 3) {
            price = 0;
        } else if (nationalMerit == "y" || card == "y") {
            price = 8000;
        } else if (age >= 3 && age < 13) {
            price = 4000;
        } else if (time > 17) {
            price = 4000;
        } else {
            price = 10000;
        }

        System.out.println("입장료: " + price);
    }
}
