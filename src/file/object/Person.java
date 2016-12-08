package file.object;

import java.io.Serializable;

class Person implements Serializable {
	String name;
	int age;
	String father;
	String mother;

	Person(String name, int age, String father, String mother) {
		this.name = name;
		this.age = age;
		this.father = father;
		this.mother = mother;

	}

}
