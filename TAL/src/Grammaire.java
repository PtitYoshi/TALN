import java.util.ArrayList;


public class Grammaire {

	private ArrayList<Rule> rules;
	
	
// Constructeur
	public Grammaire()
	{
		setRules(new ArrayList<Rule>());
	}
	
	
	
// Accesseurs
	// Get
	public ArrayList<Rule> getRules() { return rules; }
	
	// Set
	public void setRules(ArrayList<Rule> rules) { this.rules = rules; }
	
	
	
// Methodes
	public void addRule(String hypothesis, ArrayList<String> conclusion)
	{
		rules.add(new Rule(hypothesis, conclusion));
	}
	
	public void backtrack(String s)
	{
		ArrayList<String> phrase = new ArrayList<String>();
		String[] tmp = s.split("(?<=\\b|[^\\p{L}])", 0);
		for(int i=0; i<tmp.length;i++)
		{
			if (!tmp[i].equals(" "))
				phrase.add(tmp[i]);
		}
		System.out.println(phrase);
	}
	

}
