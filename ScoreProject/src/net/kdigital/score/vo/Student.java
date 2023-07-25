package net.kdigital.score.vo;

public class Student {
	private int stdid;
	private String stdname;
	private double it;
	private double language;
	private double basic;
	private double avg;
	private String grade;
	
	public Student(int stdid, String stdname, double it, double language, double basic) {
		this.stdid = stdid;
		this.stdname = stdname;
		this.it = it;
		this.language = language;
		this.basic = basic;
		calc()	;
	}
	private void calc() {
		// avg 구하는 코드
		avg = (it * 0.4) + (language* 0.3) + (basic* 0.3);
		
		// grade 구하는 코드
		if(avg >= 90) {
			grade = "1등급";
		}
		else if (avg >= 80) {
			grade = "2등급";
		}
		else if (avg >= 70) {
			grade = "3등급";
		}
		else if (avg >= 60) {
			grade = "4등급";
		}
		else {
			grade = "5등급";
		}
	}
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public double getIt() {
		return it;
	}
	public void setIt(double it) {
		this.it = it;
		calc();
	}
	public double getLanguage() {
		return language;
	}
	public void setLanguage(double language) {
		this.language = language;
		calc();
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
		calc();
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		String temp = String.format("%2d번 %s : %6.2f %6.2f %6.2f %6.2f %5s", 
				stdid, stdname, it, language, basic, avg, grade);
		return temp;
	}
}