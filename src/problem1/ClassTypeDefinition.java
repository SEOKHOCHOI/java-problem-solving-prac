package problem1;

public class ClassTypeDefinition {

    public static void main(String[] agrs) {

        // 1. 변수를 만들고
         Person1 first;

        // 2. new는 항상 뭔가를 생성하는 일을 함.
        // 이때 new가 생성하는걸 객체라고 부름.
         first = new Person1();

         // 클래스 안의 필드들을 엑세스 하기위해 . 을 찍어줌.
         // 여기까진 c의 구조체와 완전히 동일.
         first.name = "John";
         first.number = "01012345678";

         System.out.println("name: " + first.name + ", Number: " + first.number);

         // Person1 이라는게 하나의 데이터 타입이기에
         // int나 double같은 기본 타입으로 가능한 것들을 다 할 수 있음.
         // 그러니 배열도 선언가능.
         Person1 [] members = new Person1 [2];
         members[0] = first;
         // 두번째 칸에 새로운 사람을 저장하고 싶으면 new personw1() 으로 객체를 만들고
         // 이 객체의 name필드에 추가 해주면 됨.
         members[1] = new Person1();
         members[1].name = "David";
         members[1].number = "234234234";
         System.out.println(members[1]);
         System.out.println("memebers[1].name: " + members[1].name + ", members[1].number: " + members[1].number);
    }
}
