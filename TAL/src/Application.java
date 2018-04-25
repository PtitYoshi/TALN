import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Application {

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		
		
		File fg = new File("Grammaire");
		
		Grammaire g = new Grammaire(fg);
		System.out.println("\n");
		g.toString();
						
		ArrayList<String> list = new ArrayList<String>();
		list.add("le bien qu'il fait, il le fait bien.");
		list.add("le fait est que j'ai peu de biens.");
		list.add("bien des gens ont fait un peu de bien.");
		list.add("bien qu'il ait fait du bien, il ne l'a pas bien fait.");
		
		for (String s : list) {
			g.fn_chomsky(s);
		}
	}

	
}
