import java.io.File;
import java.io.IOException;


public class Application {

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
				
		//createCategories(Dictionary, tagList);
		
		//readFile(Dictionary, tagList);
		
		//checkDictionary(Dictionary);
		
		String s1 = "le bien qu'il fait, il le fait bien.";
		fn_chomsky(s1);
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
		
		
		Grammaire g = new Grammaire(fg);
		System.out.println("\n");
		g.toString();
		
		g.analyse(s);
	}
	
}
