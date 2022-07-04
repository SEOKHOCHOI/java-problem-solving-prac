package practice01;

import java.util.Scanner;
import java.util.ArrayList;

class ReturnToString {
    private int annualIncome;
    private int taxRate;
    private int progressiveDeduction;
    private int resultIncom;

    void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }
    void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
    }
    void setProgressiveDeduction(int progressiveDeduction) {
        this.progressiveDeduction = progressiveDeduction;
    }

    void setResultIncom(int resultIncom) {
        this.resultIncom = resultIncom - this.progressiveDeduction;
    }

    int getTotalTax() {
        return this.resultIncom;
    }

    @Override
    public String toString() {
        String returnStringValue = String.format("% 11d * % 3d%% = % 11d", this.annualIncome, this.taxRate, this.resultIncom);
        return returnStringValue;
    }
}

public class Prac08 {
    public static void main(String[] args) {
        // 단어는 네이버 영사전에서 검색하였습니다.
        // 연소득 annualIncome
        // 세금 tax
        // 세율 taxRate
        // 누진공제 progressiveDeduction
        Scanner kb = new Scanner(System.in);
        ReturnToString taxResult = new ReturnToString();
        ArrayList<String> incomeArr = new ArrayList<>();

        System.out.println("[과세금액 계산 프로그램]");

        System.out.println();


        // 2. 주어진 종합소득세율표를 통한 조건 생성
        int progressiveDeduction = 0;
        double taxRate = 0;

        int totalTax = 0;

        loop : while(true) {

            System.out.println("'세금계산', '결과', '종료' 중 하나를 입력해주세요.");
            String inputTxt = kb.next();

            if (inputTxt.equals("세금계산")) {

                // 1. 연소득 금액 입력
                System.out.print("연소득을 입력해 주세요.:");
                int annualIncome = kb.nextInt();

                if (annualIncome <= 12000000) {
                    taxRate = 0.06;
                    taxResult.setProgressiveDeduction(progressiveDeduction);
                    taxResult.setTaxRate((int)(taxRate * 100));
                    taxResult.setAnnualIncome(annualIncome);
                    taxResult.setResultIncom((int)(annualIncome * taxRate));
                    incomeArr.add(taxResult.toString());
                    totalTax += taxResult.getTotalTax();

                } else if (annualIncome > 12000000 && annualIncome <= 46000000) {
                    progressiveDeduction = 1080000;
                    taxRate = 0.15;
                    taxResult.setProgressiveDeduction(progressiveDeduction);
                    taxResult.setTaxRate((int)(taxRate * 100));
                    taxResult.setAnnualIncome(annualIncome);
                    taxResult.setResultIncom((int)(annualIncome * taxRate));
                    incomeArr.add(taxResult.toString());
                    totalTax += taxResult.getTotalTax();

                } else if (annualIncome > 46000000 && annualIncome <= 88000000) {
                    progressiveDeduction = 5220000;
                    taxRate = 0.24;
                    taxResult.setProgressiveDeduction(progressiveDeduction);
                    taxResult.setTaxRate((int)(taxRate * 100));
                    taxResult.setAnnualIncome(annualIncome);
                    taxResult.setResultIncom((int)(annualIncome * taxRate));
                    incomeArr.add(taxResult.toString());
                    totalTax += taxResult.getTotalTax();

                }else if (annualIncome > 88000000 && annualIncome <= 150000000) {
                    progressiveDeduction = 14900000;
                    taxRate = 0.35;
                    taxResult.setProgressiveDeduction(progressiveDeduction);
                    taxResult.setTaxRate((int)(taxRate * 100));
                    taxResult.setAnnualIncome(annualIncome);
                    taxResult.setResultIncom((int)(annualIncome * taxRate));
                    incomeArr.add(taxResult.toString());
                    totalTax += taxResult.getTotalTax();

                }else if (annualIncome > 150000000 && annualIncome <= 300000000) {
                    progressiveDeduction = 19400000;
                    taxRate = 0.38;
                    taxResult.setProgressiveDeduction(progressiveDeduction);
                    taxResult.setTaxRate((int)(taxRate * 100));
                    taxResult.setAnnualIncome(annualIncome);
                    taxResult.setResultIncom((int)(annualIncome * taxRate));
                    incomeArr.add(taxResult.toString());
                    totalTax += taxResult.getTotalTax();

                }else if (annualIncome > 300000000 && annualIncome <= 500000000) {
                    progressiveDeduction = 25400000;
                    taxRate = 0.40;
                    taxResult.setProgressiveDeduction(progressiveDeduction);
                    taxResult.setTaxRate((int)(taxRate * 100));
                    taxResult.setAnnualIncome(annualIncome);
                    taxResult.setResultIncom((int)(annualIncome * taxRate));
                    incomeArr.add(taxResult.toString());
                    totalTax += taxResult.getTotalTax();

                }else if (annualIncome > 500000000 && annualIncome <= 1000000000) {
                    progressiveDeduction = 35400000;
                    taxRate = 0.42;
                    taxResult.setProgressiveDeduction(progressiveDeduction);
                    taxResult.setTaxRate((int)(taxRate * 100));
                    taxResult.setAnnualIncome(annualIncome);
                    taxResult.setResultIncom((int)(annualIncome * taxRate));
                    incomeArr.add(taxResult.toString());
                    totalTax += taxResult.getTotalTax();

                }else if (annualIncome > 1000000000) {
                    progressiveDeduction = 65400000;
                    taxRate = 0.45;
                    taxResult.setProgressiveDeduction(progressiveDeduction);
                    taxResult.setTaxRate((int)(taxRate * 100));
                    taxResult.setAnnualIncome(annualIncome);
                    taxResult.setResultIncom((int)(annualIncome * taxRate));
                    incomeArr.add(taxResult.toString());
                    totalTax += taxResult.getTotalTax();

                }

            } else if (inputTxt.equals("결과")) {
                for ( int i = 0; i < incomeArr.size(); i++) {
                    System.out.println(incomeArr.get(i));
                }

                System.out.println();
                System.out.printf("[세율에 의한 세금]: % 18d%n", totalTax);
                System.out.printf("[누전공제 계산에 의한 세금]: % 11d", totalTax);
                System.out.println();

            } else if (inputTxt.equals("종료")) {
                System.out.println("프로그램이 종료됩니다.");
                break loop;
            }
        }
    }
}
