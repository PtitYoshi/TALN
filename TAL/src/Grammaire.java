import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Grammaire {

	private ArrayList<Rule> rules;
	
	
// Constructeur
	public Grammaire()
	{
		setRules(new ArrayList<Rule>());
	}
	
	@SuppressWarnings("resource")
	public Grammaire(File file) throws IOException
	{
		rules = new ArrayList<Rule>();
		System.out.println("Construction de la grammaire");
		String hypothesis;
		ArrayList<String> conclusion;
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		System.out.println("Demmarage de l'integration de règles");
		while((line=br.readLine())!=null)
		{
			System.out.println("Lancement de l'analyse de "+line);
			hypothesis=null;
			conclusion=new ArrayList<String>();
			
			hypothesis=line.substring(0, line.indexOf("->"));
			line=line.substring(line.indexOf("->")+2);
			while(line.contains(";"))
			{
				System.out.println(line);
				conclusion.add(line.substring(0,line.indexOf(";")));
				line=line.substring(line.indexOf(";")+1);
			}
			conclusion.add(line);
			System.out.println("Nouvelle règle : "+hypothesis+"->"+conclusion.toString());
			rules.add(new Rule(hypothesis,conclusion));
		}
		System.out.println("Liste de règles : \n"+rules.toString());
	}
	
// Accesseurs
	// Get
	public ArrayList<Rule> getRules() { return rules; }
	
	// Set
	public void setRules(ArrayList<Rule> rules) { this.rules = rules; }
	
	
	
// Methodes
	public void addRule(String hypothesis, ArrayList<String> conclusion)
	{
		System.out.println("Regle ! Je te construit ! "+hypothesis+"->"+conclusion.toString());
		Rule r = new Rule(hypothesis, conclusion);
		r.toString();
		this.rules.add(r);
	}
	
	public void analyse(String s)
	{
		ArrayList<String> phrase = new ArrayList<String>();
		String regex="((?<=[^\\p{L}])|(?=[^\\p{L}'+]))";
		String[] tmp = s.split(regex, 0);
		for(int i=0; i<tmp.length;i++)
		{
			if (!tmp[i].equals(" "))
				phrase.add(tmp[i]);
		}
		System.out.println(phrase);
		
		ArrayList<Object> result=new ArrayList<Object>();
		if(backtrack(phrase,result,"P"))
			System.out.println("resultat trouvé : "+result.toString());
		else
			System.out.println("Phrase invalide");
	}
	
	public boolean backtrack(ArrayList<String> aTraiter,ArrayList<Object> traite, String currentTag)
	{
		/*Pour chaque mot :
		 * Si son tag est une hypothese de règle, alors il faut pouvoir découper le tableau pour valider la conclusion d'au moins l'une de ces regles (recurrence), sinon phrase invalide
		 * Si son tag n'est pas hypothese d'une regle, alors le mot doit apparaitre dans le dico approprié au tag, sinon mot inconnu
		 * */
		return false;
	}
	

}
