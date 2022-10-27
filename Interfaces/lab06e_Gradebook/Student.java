import java.util.Arrays;

public class Student implements Comparable<Student> {
	private String name;
	private Grades grades;
	
	public Student() {
		setName("");
		setGrades("");
	}
	
	public Student(String name, String gradeList) {
		this.name = name;
		this.grades = new Grades(gradeList);
	}
	
	public void setName(String name) {
		this.name = name;
	}	
	
	public void setGrades(String gradeList) {
		this.grades = new Grades(gradeList);
	}
	
	public void setGrade(int spot, double grade) {
		grades.setGrade(spot, grade);
	}

	public String getName() {
		return name;
	}
	
	public int getNumGrades() {
		return grades.getNumGrades();
	}

	public double getSum() {
		return grades.getSum();
	}
	
	public double getAverage() {
		return grades.getSum()/grades.getNumGrades();
	}

	public double getAverageMinusLow() {
		return getAverage()/grades.getSum();
	}
	
	public double getHighGrade() {
		return grades.getHighGrade();
	}
	
	public double getLowGrade() {
		return grades.getLowGrade();
	}

	public int compareTo(Student other) {
		if (this.name.equals(other.name))
			return this.name.compareTo(other.name);
		return (int) Math.ceil(this.getAverage() - other.getAverage());
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		return this.name.equals(other.name) && this.grades.equals(other.grades);
	}
	
	public String toString() {
		return this.name + " = " + grades.toString();
	}	
}