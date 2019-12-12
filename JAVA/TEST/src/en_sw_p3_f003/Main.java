package en_sw_p3_f003;

import java.util.Scanner;

class Course{
	private String name;//课程名称
	private String student; //学生姓名
	private double examScore; //该学生本门课程成绩
	public Course(String name, String student, double examScore) {
		super();
		this.name = name;
		this.student = student;
		this.examScore = examScore;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getName() {
		return name;
	}
	public void setExamScore(double examScore) {
		this.examScore = examScore;
	}
	
	public double getExamScore() {
		return examScore;
	}
	//一般课程的考试成绩就是最终成绩
	public double getFinalScore(){
		return examScore;
	}
}
/******start******/
class  PracticeCourse  extends Course{
     private double proportion;
     private double practiceScore;
     
     /** 参数构造方法*/
	public PracticeCourse(String name, String student, double examScore,double practiceScore, double proportion) {
		super(name, student, examScore);
		this.proportion=proportion;
		this.practiceScore=practiceScore;
	}


	public double getProportion() {
		return proportion;
	}
    public void setProportion(double proportion) {
		this.proportion = proportion;
	}
	public double getPracticeScore() {
		return practiceScore;
	}
	public void setPracticeScore(double practiceScore) {
		this.practiceScore = practiceScore;
	}
	
	public double getFinalScore(){
		return getExamScore()*proportion+practiceScore*(1-proportion);
	}
}











/******end******/
public class Main {
	public static void main(String[] args) {
		System.out.println("Enter courseName, studentName,examScore,practiceScore and Proportion:");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		String student = scanner.next();
		double examScore = scanner.nextDouble();
		double practiceScore = scanner.nextDouble();
		double proportion = scanner.nextDouble();
		PracticeCourse c1 = new PracticeCourse(name, student, examScore, practiceScore, proportion);
		System.out.println(c1 instanceof Course);
		System.out.println(c1.getStudent()+"的《"+c1.getName()+"》课程的最终成绩是："+c1.getFinalScore());
		c1.setStudent("Jack");
		c1.setExamScore(100);
		c1.setPracticeScore(80);
		c1.setProportion(0.5);
		System.out.println(c1.getStudent()+"的《"+c1.getName()+"》课程的最终成绩是："+c1.getFinalScore());
		scanner.close();
	}
}