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
	
	public void fillRules(File f) throws IOException
	{		
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		String tag="";
		while((line=br.readLine()) != null)
		{
			if(line.contains("-----"))
			{
				//Obtenir le tag dans le fichier
				tag=(String) line.subSequence(line.indexOf(":")+2, line.length());
			}
			else
			{
				rules.add(new Rule(tag,line));
			}
		}
		br.close();
	}
	
	public String toString()
	{
		System.out.println("Liste des règles de la grammaire : \n");
		for(int i=0;i<rules.size();i++)
		{
			System.out.println(rules.get(i).toString());
		}
		return null;
	}
	
// Accesseurs
	
	public ArrayList<Rule> getRules() { return rules; }
	
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
		CYK(phrase);
	}
	
	@SuppressWarnings("unchecked")
	private void CYK(ArrayList<String> phrase)
	{
		Object[][] cyk = new Object[phrase.size()][phrase.size()];
		
		for(int i=0;i<phrase.size();i++)
		{
			for(int j=0;j<phrase.size();j++)
			{
				cyk[i][j] = new ArrayList<String>();
			}
		}
		
		for(int i=0;i<phrase.size();i++)
		{
			//cyk[0][i] = new ArrayList<String>();
			for(int j=0;j<rules.size();j++)
			{
				if(rules.get(j).getConclusion().size()==1&&rules.get(j).getConclusion().get(0).equals(phrase.get(i)))
				{
					//cyk[i][i] = rules.get(j).getHypothesis();
					((ArrayList<String>) cyk[0][i]).add(rules.get(j).getHypothesis());
				}
			}
		}
		int step=0;
		for(int i=1;i<phrase.size();i++)
		{
			step++;
			for(int j=0;j<phrase.size()-1;j++)
			{
				System.out.println("Etape "+step+" : "+phrase.get(j));
				for(int k=0;k<i;k++)
				{
					//M(i,j) = A si B ∈  M(k,j) et C ∈  M(i-k-1,j+k+1) et A-> BC ∈  P.
					//System.out.println("\tIl y a-t-il une règle entre "+cyk[k][j]+" et "+cyk[i-k-1][j+k+1]+" ?");
					//cyk[i][j]=new ArrayList<String>();
					for(int r=0;r<rules.size();r++)
					{
						if(rules.get(r).getConclusion().size()==2
								&&((ArrayList<String>) cyk[k][j]).contains(rules.get(r).getConclusion().get(0))
								&&((ArrayList<String>) cyk[i-k-1][j+k+1]).contains(rules.get(r).getConclusion().get(1)))
						{
							System.out.println("\t\tYES");
							((ArrayList<String>) cyk[i][j]).add(rules.get(r).getHypothesis());
						}
					}
					System.out.println("\t\tVerification terminé !");
				}
			}
		}
		
		System.out.println("Affichage du CYK : \n");
		String display="";
		int numberTab;
		int tab=2;
		for(int i=0;i<cyk.length;i++)
		{
			display+=phrase.get(i);
			numberTab = display.length()%4;
			for(int t=0;t<tab-numberTab;t++)
			{
				display+="\t";
			}
			display+="|";
		}
		System.out.println(display);
		for(int i=0;i<cyk.length;i++)
		{
			display="";
			for(int j=0;j<cyk[i].length;j++)
			{
				display+=cyk[i][j];
				numberTab = display.length()%4;
				for(int t=0;t<tab-numberTab;t++)
				{
					display+="\t";
				}
				display+="|";
			}
			System.out.println(display);
		}
	}
	

}
