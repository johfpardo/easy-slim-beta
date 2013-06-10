package easy_slim_beta.entities;

import java.util.Date;

public class UserProfile {
	String name;
	int age;
	int year;
	int month;
	int day;
	float height;
	float weight;
	float imc;
	
	public void setName(String var){
		this.name=var;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAge(int var){
		this.age=var;
	}
	
	@SuppressWarnings("deprecation")
	public void setAge(){
		Date today = new Date();
		if(today.getMonth() >= this.month){
			if(today.getDay() >= this.day){
				this.age= today.getYear() - this.year;
			}else{
				this.age= today.getYear() - this.year - 1;
			}
		}else{
			this.age= today.getYear() - this.year - 1;
		}
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setHeight(float var){
		this.height=var;
	}
	
	public float getHeight(){
		return this.height;
	}
	
	public void setWeight(float var){
		this.weight=var;
	}
	
	public float getWeight(){
		return this.weight;
	}
	
	public void setImc(float var){
		this.imc=var;
	}
	
	public float getImc(){
		return this.imc;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}


	public void calculateImc(){
		this.imc=this.weight/((this.height/100)*(this.height/100));
	}
	
	public void set (String newName, int newYear, int newMonth, int newDay, float newHeight, float newWeight){
		setName(newName);
		setYear(newYear);
		setMonth(newMonth);
		setDay(newDay);
		setAge();
		setHeight(newHeight);
		setWeight(newWeight);
		calculateImc();	
	}
}
