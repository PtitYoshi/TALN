import java.util.ArrayList;
import java.util.HashMap;


public class Categorie {
	
	private String type;
	private HashMap<String,String> dico;
	private ArrayList<String> tagAutorized;

	public Categorie(String t, HashMap<String,String> d, ArrayList<String> tag) {
		
		this.type = t;
		dico = new HashMap<String,String>(d);
		
		/*
		for(int i=0;i<d.size();i++)
			dico.add(d.get(i));
		*/
		
		tagAutorized = new ArrayList<String>(tag);
	}
	
	public Categorie(String t, ArrayList<String> tag){
		this.type = t;
		dico = new HashMap<String,String>();
		tagAutorized = new ArrayList<String>(tag);
	}
	
	public Categorie(String t)
	{
		dico = new HashMap<String,String>();
		tagAutorized = new ArrayList<String>();
		this.type = t;
	}

	public ArrayList<String> getTagAutorized() {
		return tagAutorized;
	}

	public void setTagAutorized(ArrayList<String> tagAutorized) {
		this.tagAutorized = tagAutorized;
	}

	public HashMap<String,String> getDico() {
		return dico;
	}

	public void setDico(HashMap<String,String> dico) {
		this.dico = dico;
	}
	
	public String addTag(String e){
		tagAutorized.add(e);
		return e;
	}
	
	public String toString(){
		return "Type de Categorie : "+type.toString()
				+"\ntag autorise : "+tagAutorized.toString()
				+"\ndictionnaire : "+dico.toString();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void addWord(String mot, String tag)
	{
		dico.put(mot, tag);
	}

}
