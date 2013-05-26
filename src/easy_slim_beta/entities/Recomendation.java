package easy_slim_beta.entities;

public class Recomendation {
	int bmi;
	String textRecomendation;
	String imageName;
	
	public Recomendation(int bmi, String textRecomendation, String imageName) {
		this.bmi =bmi;
		this.textRecomendation = textRecomendation;
		this.imageName = imageName;
	}
	
	public int getBmi() {
		return bmi;
	}

	public String getTextRecomendation() {
		return textRecomendation;
	}

	public String getImageName() {
		return imageName;
	}

}