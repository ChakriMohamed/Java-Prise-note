package HamiSyphax.note;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Enumeration programme pour le lancement de l'editeur de text et du navigateur
 * ainsi leur chemins  
 */
public enum Programme {
NAVIGATEUR("n"),EDITEUR("e");
	
	
private Process prog;
private String choix;
private String chemin_prog;
private static String chemin_fichier;

Programme(String choix) {
this.choix=choix;
get_chemin_prog();
}

public void run(String titre_fichier ) {
		
try {
    prog = Runtime.getRuntime().exec(new String[] {chemin_prog,titre_fichier});
    
   } catch (IOException e) {
	e.printStackTrace();
   						   }
	}


public void get_chemin_prog() {
	
	try{
		InputStream flux=new FileInputStream("PATH_PROG"); 
		InputStreamReader lecture=new InputStreamReader(flux);
		BufferedReader buff=new BufferedReader(lecture);
		String ligne;
		String [] parts;
		
		while ((ligne=buff.readLine())!=null){
			parts=ligne.split("=");
			if(parts.length==2 && parts[0].equals("chemin_fichier")) {
				chemin_fichier=parts[1];
			}
			else if(parts.length==2 && choix=="n" && parts[0].equals("chemin_navigateur") )
				{ 
				chemin_prog=parts[1];
				break;
				}			
			else if(parts.length==2 && choix=="e" && parts[0].equals("chemin_editeur"))
			{ 
			chemin_prog=parts[1];
			break;
			}
		}
		buff.close(); 
		}		
		catch (Exception e){
		System.out.println(e.toString());
		}
System.out.println("Le chemin des fichiers est initilialisé à :"+chemin_fichier);
}

public Process getProg() {
	return prog;
}

public static String getChemin_fichier() {
	return chemin_fichier;
}


}

