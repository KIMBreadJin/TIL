package basic;

import java.util.Comparator;

public class Person implements Comparable<Person>{
	private String id;
	private String name;
	private int age;
	private Comparator<Person> comparator;
	
	public Person(String id, String name, int age, Comparator<Person> comparator) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.comparator=comparator;
	}
	@Override
	public String toString() { 
		return "Person{" + "id = " + id + ", " + "name = " + name + ", " + "age = " +age + "}";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Person o) {
		//return this.age -o.getAge(); //나이순
		return -(this.age -o.getAge()); //나이 역순
		//return this.name.compareTo(o.getName()); // 이름순
		//return o.name.compareTo(this.getName()); // 이름역순
		
	}
	
}

