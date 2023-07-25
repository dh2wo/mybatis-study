package net.kdigital.bmiproject.vo;

public class MemberVO {
	private String id; //VARCHR2(10) PK
	private String name; //VARCHR2(30) NN
	private double height; //VARCHR2(5,2) NN
	private double weight; //VARCHR2(5,2) NN
	private double bmi; //VARCHR2(5,2) NN
	private int deleteFlag;
	private String bmiresult; //VARCHR2(9) NN CHECK
	private String regDate; //Date default sysdate
	private String updDate; //Date default sysdate
	
	public MemberVO() {
		
	}

	public MemberVO(String id, String name, double height, double weight) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		bmiCalc();
	}
	
	private void bmiCalc() {
		double heightToM = height * 0.01;
		bmi = weight / (heightToM * heightToM);
		
		if (bmi >= 25) {
			bmiresult = "비만";
		}
		else if (bmi >= 23) {
			bmiresult = "과체중";
		}
		else if (bmi >= 18.5) {
			bmiresult = "정상";
		}
		else {
			bmiresult = "저체중";
		}
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getBmiresult() {
		return bmiresult;
	}

	public void setBmiresult(String bmiresult) {
		this.bmiresult = bmiresult;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public void setUpdDate(String updDate) {
		this.updDate = updDate;
	}

	@Override
	public String toString() {
		return String.format("아이디: %s 이름: %s "
				+ "키: %.2fcm 몸무게: %.2fkg "
				+ "BMI: %.2f BMI결과: %s 회원등록날짜: %s 회원수정날짜: %s%n"
				, id, name, height, weight, bmi, bmiresult, regDate, updDate);
		
//		return "아이디 : " + id +  
//				"\n이름 : " + name + 
//				"\n키 : " + height + 
//				"\n몸무게 : " + weight + 
//				"\nBMI : " + bmi + 
//				"\n체질량 검사 결과 : " + bmiresult;
	} 
}
