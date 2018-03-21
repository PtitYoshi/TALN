import java.util.ArrayList;


public class Categorie {
	
	private String type;
	private ArrayList<Mot> dico;
	private ArrayList<Etiquette> tagAutorized;

	public Categorie(String t, ArrayList<Mot> d, ArrayList<Etiquette> tag) {
		
		this.type = t;
		setDico(new ArrayList<Mot>(d));
		
		/*
		for(int i=0;i<d.size();i++)
			dico.add(d.get(i));
		*/
		
		tagAutorized = new ArrayList<Etiquette>(tag);
	}
	
	public Categorie(String t, ArrayList<Etiquette> tag){
		this.type = t;
		dico = new ArrayList<Mot>();
		tagAutorized = new ArrayList<Etiquette>(tag);
	}
	
	public Categorie(String t)
	{
		dico = new ArrayList<Mot>();
		tagAutorized = new ArrayList<Etiquette>();
		this.type = t;
	}

	public ArrayList<Etiquette> getTagAutorized() {
		return tagAutorized;
	}

	public void setTagAutorized(ArrayList<Etiquette> tagAutorized) {
		this.tagAutorized = tagAutorized;
	}

	public ArrayList<Mot> getDico() {
		return dico;
	}

	public void setDico(ArrayList<Mot> dico) {
		this.dico = dico;
	}
	
	public void addTag(Etiquette e){
		tagAutorized.add(e);
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

}
