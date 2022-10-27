import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Class
{
	private String name;
	private Student[] studentList;
	
	public Class() {
		name = "";
		studentList = new Student[0];
	}
	
	public Class(String name, int stuCount) {
		this.name = name;
		this.studentList = new Student[stuCount];
	}
	
	public void addStudent(int stuNum, Student s) {
		if (stuNum >= studentList.length)
			return;
		studentList[stuNum] = s;
	}
	
	public void sort() {
		Arrays.sort(studentList);
	}
	
	public String getClassName() {
	   return name;
	}
	
	public double getClassAverage() {
		if (studentList.length == 0)
			return -1.0d;
		return Arrays.stream(studentList).mapToDouble(Student::getAverage).average().getAsDouble();
	}
	
	public double getStudentAverage(int stuNum) {
		if (stuNum >= studentList.length)
			return -1.0d;
		return studentList[stuNum].getAverage();
	}

	public double getStudentAverage(String stuName) {
		if (List.of(studentList).contains(stuName))
			return -1.0d;
		return Arrays.stream(studentList).filter(e -> e.getName().equals(stuName)).findFirst().get().getAverage();
	}
	
	public String getStudentName(int stuNum) {
		return studentList[stuNum].getName();
	}

	public String getStudentWithHighestAverage() {
		Student highest = studentList[0];
		for (Student s: studentList)
			if (s.getAverage() < highest.getAverage())
				highest = s;
		return highest.getName();
	}

	public String getStudentWithLowestAverage() {
		Student lowest = studentList[0];
		for (Student s: studentList)
			if (s.getAverage() < lowest.getAverage())
				lowest = s;
		return lowest.getName();
	}
	
	public String getFailureList(double failingGrade) {
		return Arrays.stream(studentList)
				.filter(e -> e.getAverage() <= failingGrade)
				.map(e -> e.getName())
				.reduce((a, b) -> a + ", " + b)
				.get();
	}
	
	public String toString() {
		String output=""+getClassName()+"\n";
		output += Arrays.toString(studentList);
		return output;
	}  	
}