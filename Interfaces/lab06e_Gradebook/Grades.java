import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Grades
{
	private double[] grades;
	
	public Grades() {
		setGrades("");
	}
	
	public Grades(String gradeList) {
		setGrades(gradeList);		
	}
	
	public void setGrades(String gradeList) {
		grades = Arrays.stream(gradeList.substring(gradeList.indexOf("-")+2).split(" ")).mapToDouble(Double::valueOf).toArray();
	}
	
	public void setGrade(int spot, double grade) {
		grades[spot] = grade;
	}
	
	public double getSum() {
		return Arrays.stream(grades).sum();
	}
	
	public double getLowGrade() {
		return Arrays.stream(grades).min().getAsDouble();
	}
	
	public double getHighGrade() {
		return Arrays.stream(grades).max().getAsDouble();
	}
	
	public int getNumGrades() {
		return grades.length;
	}
	
	public String toString() {
		return Arrays.toString(grades).replace("\\[|\\]|,","");
	}	
}