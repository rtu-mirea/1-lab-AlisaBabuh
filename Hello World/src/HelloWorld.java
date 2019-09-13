public class HelloWorld {
		public static void main(String[] args) {
			Student student = new Student();
			
			student.age = 18;
			student.course = 2;
			student.name = "Babuh Alisa";
			student.isAlive = true;
System.out.println(student);
		}
}

class Student {
		String name;
		int age;
		int course;
		public boolean isAlive;
public String toString() {
	return this.name + ", " + this.age + " y.o.";
}
}