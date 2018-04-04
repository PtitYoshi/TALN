import java.util.ArrayList;


public class Grammaire {

	private ArrayList<Rule> rules;
	
	public Grammaire()
	{
		setRules(new ArrayList<Rule>());
	}
	
	public void addRule(String hypothesis, ArrayList<String> conclusion)
	{
		rules.add(new Rule(hypothesis, conclusion));
	}
	
	public void backtrack(String s)
	{
		String[] tmp = s.split(" ");
		
		ArrayList<String> phrase = new ArrayList<String>();
		
		for(int i=0; i<tmp.length;i++)
		{
			phrase.add(tmp[i]);
		}
		
		System.out.println(phrase);
	}
	
	//Accesseurs
	
	public ArrayList<Rule> getRules() {
		return rules;
	}

	public void setRules(ArrayList<Rule> rules) {
		this.rules = rules;
	}
}
