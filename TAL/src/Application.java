import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Application {

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		
		HashMap<String, Integer> tagList=new HashMap<String, Integer>();
		ArrayList<Categorie> Dictionary = new ArrayList<Categorie>();
		
		//createCategories(Dictionary, tagList);
		
		//readFile(Dictionary, tagList);
		
		//checkDictionary(Dictionary);
		
		String s1 = "le bien qu'il fait, il le fait bien.";
		fn_chomsky(s1);
	}
	
	
	private static void createCategories(ArrayList<Categorie> Dictionary, HashMap<String, Integer> tagList) {
		System.out.println("\n-----------------------------------------");
		System.out.println("Conception des Categories de mots");
		System.out.println("-----------------------------------------\n");
		
		int i=0;
		
		Categorie DET = new Categorie("DETERMINANT");
		tagList.put(DET.addTag("DET"), new Integer(i));
		tagList.put(DET.addTag("DETPREP"), new Integer(i));
		System.out.println(DET.toString());
		//tagList.addAll(DET.getTagAutorized());
		Dictionary.add(DET);
		i++;
		
		Categorie SUB = new Categorie("SUBSTANTIF");
		tagList.put(SUB.addTag("NOMC"), new Integer(i));
		tagList.put(SUB.addTag("NOMP"), new Integer(i));
		System.out.println(SUB.toString());
		//tagList.addAll(SUB.getTagAutorized());
		Dictionary.add(SUB);
		i++;
		
		Categorie PRO = new Categorie("PRONOM");
		tagList.put(PRO.addTag(("PRNSUJ")), new Integer(i));
		tagList.put(PRO.addTag(("PRNOBJ")), new Integer(i));
		tagList.put(PRO.addTag(("PRNREL")), new Integer(i));
		tagList.put(PRO.addTag(("PRNPNM")), new Integer(i));
		System.out.println(PRO.toString());
		//tagList.addAll(PRO.getTagAutorized());
		Dictionary.add(PRO);
		i++;
		
		Categorie VRB = new Categorie("VERBE");
		tagList.put(VRB.addTag(("VRB")), new Integer(i));
		tagList.put(VRB.addTag(("AUX")), new Integer(i));
		tagList.put(VRB.addTag(("PPAS")), new Integer(i));
		System.out.println(VRB.toString());
		//tagList.addAll(VRB.getTagAutorized());
		Dictionary.add(VRB);
		i++;
		
		Categorie MOD = new Categorie("MODIFIEUR");
		tagList.put(MOD.addTag(("ADJ")), new Integer(i));
		tagList.put(MOD.addTag(("ATT")), new Integer(i));
		tagList.put(MOD.addTag(("ADV")), new Integer(i));
		System.out.println(MOD.toString());
		//tagList.addAll(MOD.getTagAutorized());
		Dictionary.add(MOD);
		i++;
		
		Categorie PRE = new Categorie("PREPOSITION");
		tagList.put(PRE.addTag(("PREP")), new Integer(i));
		System.out.println(PRE.toString());
		//tagList.addAll(PRE.getTagAutorized());
		Dictionary.add(PRE);
		i++;
		
		Categorie CON = new Categorie("CONJONCTION");
		tagList.put(CON.addTag(("COOR")), new Integer(i));
		tagList.put(CON.addTag(("SUB")), new Integer(i));
		System.out.println(CON.toString());
		//tagList.addAll(CON.getTagAutorized());
		Dictionary.add(CON);
		i++;
		
		Categorie PON = new Categorie("PONCTUATION");
		tagList.put(PON.addTag("PNT"), new Integer(i));
		tagList.put(PON.addTag("VIR"), new Integer(i));
		tagList.put(PON.addTag("EXC"), new Integer(i));
		tagList.put(PON.addTag("INT"), new Integer(i));
		
		Dictionary.add(PON);
		i++;
		
		System.out.println("Liste des tags : "+tagList.toString());
	}

	private static void readFile(ArrayList<Categorie> Dictionary, HashMap<String, Integer> tagList) throws IOException {
		System.out.println("\n-----------------------------------------");
		System.out.println("Integration des mots");
		System.out.println("-----------------------------------------\n");
		
		File f= new File("Dictionnaire");
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		int ind=0;
		String tag="";
		while((line=br.readLine()) != null)
		{
			if(line.contains("-----"))
			{
				//Obtenir le tag dans le fichier
				tag=(String) line.subSequence(line.indexOf(":")+2, line.length());
				System.out.println("FOR "+tag+"\n");
				if(tagList.containsKey(tag))
				{
					ind=tagList.get(tag);
					System.out.println(ind);
				}
				else
				{
					System.err.println("Tag non valide dans le fichier : "+tag+"\n");
				}
			}
			else
			{
				Dictionary.get(ind).addWord(line, tag);
				System.out.println("Le mot <"+line+"> est intégré au tag "+tag+"\n");
			}
		}
		
		br.close();
	}

	private static void checkDictionary(ArrayList<Categorie> Dictionary) {
		System.out.println("\n-----------------------------------------");
		System.out.println("Verification des Dictionnaires");
		System.out.println("-----------------------------------------\n");
		
		for(int k=0;k<Dictionary.size();k++)
		{
			System.out.println(Dictionary.get(k).toString()+"\n");
		}
	}

	private static void fn_chomsky(String s) throws IOException {
		System.out.println("\n-----------------------------------------");
		System.out.println("Analyse de phrases en FN - Chomsky");
		System.out.println("-----------------------------------------\n");
		
		/*
		Soit une phrase s (ex : le bien qu'il fait, il le fait bien)
		
		 On recherche à decomposer cette phrase en séquences respectant les règles de notre grammaire
		 Algorithme(s:String, g:Grammaire)
		 	Decouper s en ArrayList<String>
		*/
		File fg = new File("Grammaire");
		File fw = new File("Dictionnaire");
		
		
		Grammaire g = new Grammaire(fg);
		g.fillRules(fw);
		System.out.println("\n");
		g.toString();
		
		g.analyse(s);
	}
	
}
