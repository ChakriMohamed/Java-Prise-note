package HamiSyphax.note;

import static org.asciidoctor.OptionsBuilder.options;
import java.io.File;
import java.util.Map;
import org.asciidoctor.Asciidoctor;
import static org.asciidoctor.Asciidoctor.Factory.create;


/**
 *visualisation de la note dans le navigateur
 */

public class ViewNote implements Commande{
	
	private String titre;
	
	public ViewNote(String titre) {
	this.titre=titre;
	}


	public void execute() {
	    Programme p=Programme.NAVIGATEUR;
       // note_to_html(p.getChemin_fichier()+titre); //conversion d'un fichier "TitreNote.adoc" to "TitreNote.html"  
	    p.run(Programme.getChemin_fichier()+titre+".adoc");
	}
	
	public void note_to_html(String TitreNote) {
		Asciidoctor asciidoctor=create();
		Map<String, Object> options = options()
				  .inPlace(true)
				  .backend("html")
				  .asMap();
		asciidoctor.convertFile(new File(TitreNote+".adoc"), options);	
	 		 }	
	
}
