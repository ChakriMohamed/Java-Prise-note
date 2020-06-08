package HamiSyphax.note;

import java.io.File;
/**
 * Listing des notes dont le format est .adoc crees dans le dossier ou la sauvegarde se fait
 * @author mohammed
 */
public  class ListerNote implements Commande {
	
	private Programme p;
	
	public ListerNote() {
		if(Index.getIndexW()==null) 
		{ System.err.println("L'index Lucene n'est pas initialisé");
		return;
		}
	p=Programme.EDITEUR;
	}

	public void execute() {
		lister();
	}
	
	public String lister() {
		String out="";
		
		File repertoire = new File(Programme.getChemin_fichier());
		String [] rep = repertoire.list();
		for (int i =0 ;i<rep.length;i++) {
			if(rep[i].contains(".adoc")) { out+=rep[i];
			System.out.println(rep[i]);
			}
		}
		return out;
	}

}