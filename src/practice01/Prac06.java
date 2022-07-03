package practice01;

import java.util.Random;

class VotesChange {
    private int c1Votes;
    private int c2Votes;
    private int c3Votes;
    private int c4Votes;

    static int tmp1;
    static int tmp2;
    static int tmp3;
    static int tmp4;

    // 가장 투표수가 많은 후보의 이름을 뱉어내는 메서드 입니다.
    // < 기능구현 실패 >!!!!!!!!!
    /*
        실패 이유:
            3명의 후보가 0인 상태로 한 명의 후보만 c1Votes (투표수)를 올렸을 때는 에러가 나지 않지만,
            한 명의 후보라도 0이 아닌채로 다른 후보의 투표수가 올라갔을시 에러발생.

        제가 생각한 해결 방법:
            변수의 변화를 감지하는 무언가가 필요하다 생각.
            알아본 것중엔 ArrayList라는 걸 사용하여 size와 오버라이드, super 등을
            활용 하면 가능하다는 댓글을 봤습니다. ( 아직 공부하지 않아 이해는 하지 못했습니다. )
     */
    String getDetectChangesInVotes() {

        if ( tmp1 == this.c1Votes && tmp2 == this.c2Votes && tmp3 == this.c3Votes && tmp4 == this.c4Votes ) {
            return "직전 투표자를 표시";
        } else if ( tmp1 <= this.c1Votes && tmp2 == this.c2Votes && tmp3 == this.c3Votes && tmp4 == this.c4Votes ) {
            return "이재명";
        }else if ( tmp1 == this.c1Votes && tmp2 <= this.c2Votes && tmp3 == this.c3Votes && tmp4 == this.c4Votes ) {
            return "윤석열";
        }else if ( tmp1 == this.c1Votes && tmp2 == this.c2Votes && tmp3 <= this.c3Votes && tmp4 == this.c4Votes ) {
            return "심상정";
        }else if ( tmp1 == this.c1Votes && tmp2 == this.c2Votes && tmp3 == this.c3Votes && tmp4 <= this.c4Votes ) {
            return "안철수";
        }
        return "오류가 있습니다. 코드를 확인하세요.";
    }

    void setDetectChangesInVotes(int c1Votes, int c2Votes, int c3Votes, int c4Votes) {
            this.c1Votes = c1Votes;
            this.c2Votes = c2Votes;
            this.c3Votes = c3Votes;
            this.c4Votes = c4Votes;
    }
}

public class Prac06 {

    // 후보자의 투표수를 감지하는 메서드 입니다.
    // 하지만 현재 투표수가 가장 많은 후보자의 투표수만 도출 할 수 있을뿐,
    //  바로직전 투표된 후보자를 찾는것을 실패했습니다.
    //  그 이전과 같은지 다른지 하나하나 짜는 로직을 넣을까?도 생각했습니다.
    static int detectNumberOfVotes(int c1Votes, int c2Votes, int c3Votes, int c4Votes) {
        int num1 = Math.max(c1Votes, c2Votes);
        int num2 = Math.max(num1, c3Votes);
        int num3 = Math.max(num2, c4Votes);
        return num3;
    }

    static String detectTheCandidates(int c1Votes, int c2Votes, int c3Votes, int c4Votes, int num3) {
        if (num3 == 0) {
            return "투표가 진행되지 않았습니다.";
        }
        else if ( num3 == c1Votes ) {
            return "이재명";
        } else if ( num3 == c2Votes ) {
            return "윤석열";
        } else if ( num3 == c3Votes ) {
            return "심상정";
        } else if ( num3 == c4Votes ) {
            return "안철수";
        }
        else {
            return " ";
        }
    }

    public static void main(String[] args) {
        String[] candidate = new String[4];
        Random random = new Random();

        int currentNumberOfVotes = 0; //현재 투표수

        // 동일한 비율로 랜덤하게 발생이 이 뜻이 맞을까요..?
        // ( 단, 당선자는 동율이 안됨 ) 이라는 표현을 보면 제가 한 경우에선
        // 매우매우 낮은 확률로 수가 일치하는 경우도 있을텐데 어떤식으로 해결해야할지 감이 안잡힙니다.
        int vo1 = random.nextInt((int)(10000 * 0.25));
        int vo2 = random.nextInt((int)(10000 * 0.25));
        int vo3 = random.nextInt((int)(10000 * 0.25));
        int vo4 = random.nextInt((int)(10000 * 0.25));

        int c1Votes = vo1; // 이재명 투표수
        int c2Votes = vo2; // 윤석열 투표수
        int c3Votes = vo3; // 심상정 투표수
        int c4Votes = vo4; // 안철수 투표수
        // 10000 / 10000 == 1
        // 10000 * 100 / 10000 = 100%
        // 0 / 100 == 0%
        // 870 / 870 == 1 == 1 * 100 == 100%


        int totalVotes = 10000; // 총 투표수 10000
        int currentTotalVotes = c1Votes + c2Votes + c3Votes + c4Votes; // 현재 총 투표수
        double turnout = (currentTotalVotes * 100 )/ totalVotes; // 전체 투표비율

        double c1Turnout = (c1Votes * 100 )/ totalVotes;
        double c2Turnout = (c2Votes * 100 )/ totalVotes;
        double c3Turnout = (c3Votes * 100 )/ totalVotes;
        double c4Turnout = (c4Votes * 100 )/ totalVotes;


        VotesChange candidateChage = new VotesChange();
        candidateChage.setDetectChangesInVotes(c1Votes, c2Votes, c3Votes , c4Votes);
        String curCandidate = candidateChage.getDetectChangesInVotes();

        int detectedVoteCount = detectNumberOfVotes(c1Votes, c2Votes, c3Votes, c4Votes);
        String detectedCandedate = detectTheCandidates(c1Votes, c2Votes, c3Votes, c4Votes, detectedVoteCount);

        String candidateName1 = "이재명";
        String candidateName2 = "윤석열";
        String candidateName3 = "심상정";
        String candidateName4 = "안철수";

        candidate[0] = String.format("[기호:1] %s: %.2f%%, (투표수: %d)", candidateName1, c1Turnout, c1Votes);
        candidate[1] = String.format("[기호:2] %s: %.2f%%, (투표수: %d)", candidateName2, c2Turnout, c2Votes);
        candidate[2] = String.format("[기호:3] %s: %.2f%%, (투표수: %d)", candidateName3, c3Turnout, c3Votes);
        candidate[3] = String.format("[기호:4] %s: %.2f%%, (투표수: %d)", candidateName4, c4Turnout, c4Votes);

        System.out.printf("[투표진행율]: %.2f%%, %d명 투표 => %s%n", turnout, currentNumberOfVotes, curCandidate);

        for( int i = 0; i < candidate.length; i++) {
            System.out.println(candidate[i]);
        }

        System.out.printf("[투표결과] 당선인: %s", detectedCandedate);
    }
}
