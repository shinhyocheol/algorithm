package javaLanguage.equals;



public class JavaEquals {

	
	public static void main(String[] args) {
		
		/**
		 * 아래의 결과는 모두 true를 리턴한다.
		 * equals, == 는 주소값(참조값)을 비교한다고 설명에 나와있는데 왜 모두 true가 나왔을까??
		 * 인스턴스를 생성할때 문자열을 객체 생성이 아닌 리터럴의 형태를 사용했기때문이다.
		 * new Person(String) 생성방식은 객체생성처럼 보일 수 있지만 엄연히 리터럴 형식이다.
		 * 
		 * Person 클래스를 보면 "AF Kiin"이라는 문자를 파라미터로 받아
		 * 내부에 정의해두었던 name에 넣어주는 코드를 볼 수 있을텐데
		 * new 연산자를 통해 생성이 아닌 this.name = name; 라고 리터럴 형식을 사용한 것을 볼 수 있다.
		 * 따라서 리터럴 형식으로 선언된 두 객체의 equals 또는 == 연산은 모두 true이다.
		 */
		Person person1 = new Person("AF Kiin");
		Person person2 = new Person("AF Kiin");
		
		System.out.println(person1.equals(person2));
		System.out.println(person1.name == person2.name);
		

		/**
		 * 그렇다면 해당 결과를 false로 나오게 하려면 어떻게 해야할까?
		 * new 연산자를 통해 각각의 객체를 생성하면 결과는 false를 반환한다.
		 */
		Person person3 = new Person(new String("AF Kiin"));
		Person person4 = new Person(new String("AF Kiin"));
		
		System.out.println(person3.equals(person4));
		System.out.println(person3.name == person4.name);
		
		
	}
	
}
