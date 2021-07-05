package javaLanguage.equals;

public class Person {
	
	String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			return false;
		} else {
			return this.name == ((Person)obj).name;
		}
	}

}
