package easy_slim_beta.entities;

public class UserProfile {
	String name;
	int age;
	double height;
	double weight;
	double imc;
	
	public void setName(String var){
		this.name=var;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAge(int var){
		this.age=var;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setHeight(double var){
		this.height=var;
	}
	
	public double getHeight(){
		return this.height;
	}
	
	public void setWeight(double var){
		this.weight=var;
	}
	
	public double getWeight(){
		return this.weight;
	}
	
	public void setImc(double var){
		this.imc=var;
	}
	
	public double getImc(){
		return this.imc;
	}
}
