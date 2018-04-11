import java.util.ArrayList;


public class Rule {
	
	private String hypothesis;
	private ArrayList<String> conclusion;

	public Rule() {
		conclusion = new ArrayList<String>();
	}
	
	public Rule(String hyp, ArrayList<String> con)
	{
		hypothesis = hyp;
		conclusion = new ArrayList<String>();
		for(int i=0;i<con.size();i++)
		{
			conclusion.add(con.get(i));
		}
	}

	public String toString()
	{
		return hypothesis+" -> "+conclusion.toString();
	}
	
	//Accesseurs
	
	public String getHypothesis() {
		return hypothesis;
	}

	public void setHypothesis(String hypothesis) {
		this.hypothesis = hypothesis;
	}

	public ArrayList<String> getConclusion() {
		return conclusion;
	}

	public void setConclusion(ArrayList<String> conclusion) {
		this.conclusion = conclusion;
	}

}
