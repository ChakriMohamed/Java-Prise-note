package HamiSyphax.note;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *Lecture d'une note apres creation ou modification
 *mise à jour l'instance de la classe note
 */
public class ReadNote {
	
	private Note note;
	private NoteFile notefile;
	
	public ReadNote(Note n) {
		note=n;
		notefile=new NoteFile(n);
		}
	
	public void LireNote(){
		BufferedReader reader;
		String  N="";
		int i=0;
        try {
            reader = new BufferedReader(new FileReader(notefile.getFichier()));
            String ligne;
            while((reader.readLine()) != null && i<8) i+=1;
            while((ligne =reader.readLine()) != null) N+="\n"+ligne;
            	
        } catch (Exception ex){
            System.err.println("impossible de trouver la note. "+ex.getMessage());
        }
		note.setMessage(N);
}
	
	
	public void AttributNote(){    
		BufferedReader reader;
		String  N="";
		String [] tab=null;
        try {
            reader = new BufferedReader(new FileReader(notefile.getFichier()));
            String ligne;
            int i=0;
            ligne = reader.readLine();
            ligne = reader.readLine();
            while((ligne = reader.readLine()) != null && i!=7 ){
	        		N+=ligne+" ";
	        	    i++;
	            //    System.out.println(N);

	         	}
            tab=N.split(" ");
           note.setNom(tab[0]);
           note.setPrenom(tab[1]);
           note.setEmail(tab[2]);
           note.setMois(tab[4].split("-")[1]);
           note.setContext(tab[6].split(":context:")[1]);
           note.setProject(tab[8].split(":project:")[1]);
        } catch (Exception ex){
            System.err.println("Erreur dans l'enTete. "+ex.getMessage());
        }  
    }
	

}
