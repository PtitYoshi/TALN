
public class Mot {

	private String word;
	private Etiquette et;
	
	public Mot(String w,Etiquette e){
		this.setWord(w);
		this.setEt(e);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Etiquette getEt() {
		return et;
	}

	public void setEt(Etiquette et) {
		this.et = et;
	}
}
