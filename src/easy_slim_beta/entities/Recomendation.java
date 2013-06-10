package easy_slim_beta.entities;

public class Recomendation {
	String textRecomendation;
	String imageName;
	
	public Recomendation(String textRecomendation, String imageName) {
		this.textRecomendation = textRecomendation;
		this.imageName = imageName;
	}

	public String getTextRecomendation() {
		return textRecomendation;
	}

	public String getImageName() {
		return imageName;
	}
}