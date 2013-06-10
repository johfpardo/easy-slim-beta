package easy_slim_beta.entities;

public class Nutrient {

	String name;
	String description;
	String foodList;
	String typeOfNutrient;
	
	public Nutrient(String name,String description, String foodList, String typeOfNutrient){
		this.name = name;
		this.description = description;
		this.foodList = foodList;
		this.typeOfNutrient = typeOfNutrient;
	}
	
	public String getName(){
		return name;		
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getFoodList(){
		return foodList;
	}
	
	public String getTypeOfNutrient(){
		return typeOfNutrient;
	}
}
