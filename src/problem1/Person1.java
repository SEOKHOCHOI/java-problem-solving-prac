package problem1;

// 클래스는 결국 하나의 "타입"이다. 마치 int, double 등 처럼.
// 다만 int, double 처럼 Java가 미리 정해놓은 타입이 아니라 사용자가 정의한 새로운 타입이라
// 는 의미에서 "사용자 정의 타입"이라고 부르기도 한다.
// int 혹은 double 형 변수를 선언하고 사용하는 것처럼 Person1형 변수를 선언하고 사용한다.
// int count = 0,    Person1 first = new Person1();

// 프리미티브 타입과 클래스: 차이점
// 프리미티브 타입 변수의 경우 그 변수를 선언하면 그 변수안에 정수가 저장됨.
// 사용자 정의타입(클래스타입) 변수: 변수를 만들면 그 안에 저장되는게 아니라 
// 사실 new라는 명령어를 이용해서 클래스타입의 객체를 따로 만들어 그 객체안에 만들어짐.
// 그럼 만든 변수안에 저장되는건? -> = 연산자에 의해서 객체대한 참조( 공식적으로 java에선 주소라는 말은 안쓰지만 노골적으로 객체의 주소라 봐도됨, C의 포인터 생각. )가 변수에 저장됨.
// 프리미티브 타입이 아닌 모든 변수는 참조 변수이다.
// 즉 실제 데이터가 저장될 객체는 new명령으로 따로 만들어야 하고, 참조 변수에는 그 객체의 주소를 저장( 그 객체를 참조하고 있다가 더 장확함 )한다.
public class Person1 {
    public String name;  // 클래스의 field or data member라 부름
    public String number;
}


