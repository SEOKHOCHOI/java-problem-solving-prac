package practice01;

import java.time.LocalDate;
import java.util.Scanner;

public class Prac05 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("[달력 출력 프로그램]");

        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int year = kb.nextInt();

        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = kb.nextInt();

        System.out.println();
        System.out.println();

        System.out.printf("[%d년 %02d월]", year, month);
        System.out.println();

        // 기준일자
        // year과 month만을 사용하려 했으나 년 월 일 전부를 입력해야 오류가 나지 않아,
        // 뒤에 일자까지 추가해 주었습니다.
        // month 부분이 두자리수일때는 괜찮으나 한자리수 일때는 앞에 0을 붙여줘야 에러가 나지 않아,
        // 당장 떠오른 재할당 방법으로 해결하였습니다.
        // 더 좋은 방법이 뭐가있는지 아직 자바의 문법을 몰라 찾지 못하였습니다.
        String inputDate = year + "-" + month + "-" + "02";
        if (month < 10) {
            String month0 = "0" + month;
            inputDate = year + "-" + month0 + "-" + "02";
        }
        LocalDate date = LocalDate.parse(inputDate);

        // 해당 월의 첫 번째 일자 가져오기
        LocalDate firstDate = date.withDayOfMonth(1);

        // 해당 월의 마지막날 일자 가져오기
        LocalDate lastDate = date.withDayOfMonth(date.lengthOfMonth());

        // 첫 번째 일자부터 마지막 일자까지 뽑아내기, 요일 뽑아내기
        int dayFirst = firstDate.getDayOfMonth();
        String firstDayOfWeek = firstDate.getDayOfWeek().toString();

        int dayLast = lastDate.getDayOfMonth();
        String LastDayOfWeek = lastDate.getDayOfWeek().toString();


        // equals 오버라이딩 후 문자열 체크
        EqualsOverrideClass str1 = new EqualsOverrideClass();
        EqualsOverrideClass str2 = new EqualsOverrideClass();

/*
   MONDAY
   TUESDAY
   WEDNESDAY
   THURSDAY
   FRIDAY
   SATURDAY
   SUNDAY
 */


        // 첫 번째 일자와 요일을 매칭
        str1.setInput("SUNDAY");
        str2.setInput(firstDayOfWeek);
        String tmpString = "";
        int tmpInt = 0;
        if(str1.equals(str2)) {
            tmpString = "";
            tmpInt = 7;
        }
        str1.setInput("MONDAY");
        if(str1.equals(str2)) {
            tmpString = "     ";
            tmpInt = 6;
        } str1.setInput("TUESDAY");
        if(str1.equals(str2)) {
            tmpString = "          ";
            tmpInt = 5;
        } str1.setInput("WEDNESDAY");
        if(str1.equals(str2)) {
            tmpString = "               ";
            tmpInt = 4;
        } str1.setInput("THURSDAY");
        if(str1.equals(str2)) {
            tmpString = "                    ";
            tmpInt = 3;
        } str1.setInput("FRIDAY");
        if(str1.equals(str2)) {
            tmpString = "                         ";
            tmpInt = 2;
        } str1.setInput("SATURDAY");
        if(str1.equals(str2)) {
            tmpString = "                              ";
            tmpInt = 1;
        }

        // 반복문 이용하여 첫일자부터 마지막 일자까지 출력
        System.out.println(" 일    월   화    수   목    금   토");
        System.out.print(tmpString);
        for ( int i = dayFirst; i <= dayLast; i++ ) {
            System.out.printf(" %02d  ", i);
            if(i == tmpInt) {
                System.out.println();
                tmpInt += 7;
            }
        }
    }
}

class EqualsOverrideClass {
    private String inputState;

    public void setInput(String inputState) {
        this.inputState = inputState;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof EqualsOverrideClass)) return false;
        EqualsOverrideClass overrideClass = (EqualsOverrideClass) obj;
        if (inputState == overrideClass.inputState) {
            return true;
        } else {
            return false;
        }
    }
}
