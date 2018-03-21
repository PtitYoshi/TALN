import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Application {

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		
		System.out.println("\n-----------------------------------------");
		System.out.println("Conception des Categories de mots");
		System.out.println("-----------------------------------------\n");
		
		ArrayList<Etiquette> tagList = new ArrayList<Etiquette>();
		
		Categorie DET = new Categorie("DETERMINANT");
		DET.addTag(new Etiquette("DET"));
		DET.addTag(new Etiquette("DETPREP"));
		
		System.out.println(DET.toString());
		
		tagList.addAll(DET.getTagAutorized());
		
		Categorie SUB = new Categorie("SUBSTANTIF");
		SUB.addTag(new Etiquette("NOMC"));
		SUB.addTag(new Etiquette("NOMP"));
		
		System.out.println(SUB.toString());
		
		tagList.addAll(SUB.getTagAutorized());
		
		Categorie PRO = new Categorie("PRONOM");
		PRO.addTag(new Etiquette("PRNSUJ"));
		PRO.addTag(new Etiquette("PRNOBJ"));
		PRO.addTag(new Etiquette("PRNREL"));
		PRO.addTag(new Etiquette("PRNPNM"));
		
		System.out.println(PRO.toString());
		
		tagList.addAll(PRO.getTagAutorized());
		
		Categorie VRB = new Categorie("VERBE");
		VRB.addTag(new Etiquette("VRB"));
		VRB.addTag(new Etiquette("AUX"));
		VRB.addTag(new Etiquette("PPAS"));
		
		System.out.println(VRB.toString());
		
		tagList.addAll(VRB.getTagAutorized());
		
		Categorie MOD = new Categorie("MODIFIEUR");
		MOD.addTag(new Etiquette("ADJ"));
		MOD.addTag(new Etiquette("ATT"));
		MOD.addTag(new Etiquette("ADV"));
		
		System.out.println(MOD.toString());
		
		tagList.addAll(MOD.getTagAutorized());
		
		Categorie PRE = new Categorie("PREPOSITION");
		PRE.addTag(new Etiquette("PREP"));
		
		System.out.println(PRE.toString());
		
		tagList.addAll(PRE.getTagAutorized());
		
		Categorie CON = new Categorie("CONJONCTION");
		CON.addTag(new Etiquette("COOR"));
		CON.addTag(new Etiquette("SUB"));
		
		
		System.out.println("Liste des tags : "+tagList.toString());
		
		//Rassemblement des Categories
				ArrayList<Categorie> dico = new ArrayList<Categorie>();
				dico.add(DET);
				dico.add(SUB);
				dico.add(PRO);
				dico.add(VRB);
				dico.add(MOD);
				dico.add(PRE);
				dico.add(CON);
		
		System.out.println("\n-----------------------------------------");
		System.out.println("Integration des mots");
		System.out.println("-----------------------------------------\n");
		
		File f= new File("src/Article");
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		
		while((line = br.readLine()) != null)
		{
			if(line.contains("-----"))
			{
				//Obtenir le tag dans le fichier
				//System.out.println(line.subSequence(line.indexOf(":")+2, line.length()));
				System.out.println("FOR "+line.subSequence(line.indexOf(":")+2, line.length())+"\n");
				for(int i=0;i<tagList.size();i++)
				{
					if(tagList.get(i).getEt().equals(line.subSequence(line.indexOf(":")+2, line.length())))
						System.out.println(tagList.get(i).getEt().equals(line.subSequence(line.indexOf(":")+2, line.length())));
						
				}
			}
		}
				
		/*
		System.out.println("-----------------------------------------");
		System.out.println("Conception de la categorie Determinant");
		
		ArrayList<ArrayList<Mot>> words=new ArrayList<ArrayList<Mot>>();
		File f=new File("src/Article");
		
		
		System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());

	    System.out.println("Nom du fichier : " + f.getName());

	    System.out.println("Est-ce qu'il existe ? " + f.exists());

	    System.out.println("Est-ce un répertoire ? " + f.isDirectory());

	    System.out.println("Est-ce un fichier ? " + f.isFile());
		
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		int i=-1;
		while ((line = br.readLine()) != null) {
		   //art.add(new Etiquette(line));
			if(line.contains("-----"))
			{
				words.add(new ArrayList<Mot>());
				i++;
			}
			else
				words.get(i).add(new Mot(line,new Etiquette("a")));
			
		}
		br.close();
		
		CategorieDet Article=new CategorieDet("Article",words.get(0));
		
		System.out.println(Article.toString());
		

		System.out.println("-----------------------------------------");
		System.out.println("Test : ");*/
	}
	
}
