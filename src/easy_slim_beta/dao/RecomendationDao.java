package easy_slim_beta.dao;

import java.util.ArrayList;
import java.util.List;

import easy_slim_beta.entities.Recomendation;

public class RecomendationDao {
	
	public List<Recomendation> getRecomendationForBMI(double bmi) {
		List<Recomendation> list = new ArrayList<Recomendation>();
		list.add(new Recomendation(18,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et nunc a quam egestas tincidunt. Suspendisse lacinia, ligula eget aliquet posuere, risus orci mollis odio, eu laoreet nisl volutpat.\n\n"+
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et nunc a quam egestas tincidunt. Suspendisse lacinia, ligula eget aliquet posuere, risus orci mollis odio, eu laoreet nisl volutpat.","human"));
		list.add(new Recomendation(18,"fat Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et nunc a quam egestas tincidunt. Suspendisse lacinia, ligula eget aliquet posuere, risus orci mollis odio, eu laoreet nisl volutpat.\n\n"+
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur et nunc a quam egestas tincidunt. Suspendisse lacinia, ligula eget aliquet posuere, risus orci mollis odio, eu laoreet nisl volutpat.","fathuman"));
		return list;
	}

}