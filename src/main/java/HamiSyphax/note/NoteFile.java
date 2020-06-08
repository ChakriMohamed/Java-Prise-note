package HamiSyphax.note;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * La creation et la sauvegarde de la note en format .adoc et la suppression de celle-ci
 * classe qui s'occupe des notes qui se trouvent dans le dossier de la sauvegarde 
 * @author mohammed
 */

public class NoteFile {

	private Note note;
	private File fichier;
	private File veriFileExist;
	private String path;
	
	
	public NoteFile(Note note) {
		this.note=note;
		fichier = new File(Programme.getChemin_fichier()+note.getTitre()+".adoc");
		path = fichier.getAbsolutePath();
		veriFileExist = new File(path);
	}
		
	public boolean existeNote() {
		if (veriFileExist.isFile()) 
			{ 		
			System.out.println("Note existe déja , ouverture de l'éditeur :");
			return true;
			}
		else return false;
	}
			
	/**
	 * methode qui creer le .adoc vide
	 */
	public void creerNote() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(fichier));
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();
		System.out.println(note.getTitre()+" note crée avec sucée.");
	}
	
	/**
	 * methode qui creer le .adoc avec un argument text
	 * @param contenu le text qu'on veut inserer dans la note 
	 */
	public void AddText(String contenu) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(fichier));
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println(contenu);
		out.close();
	}
	
	/**
	 * supprimer la note du dossier
	 */
	public void deleteFichier() {
	     File fichAdoc = new File(Programme.getChemin_fichier()+note.getTitre()+".html");
		 File fichHtml = new File(Programme.getChemin_fichier()+note.getTitre()+".adoc");
	     if(fichAdoc.delete())  System.out.print("Suppresion effectue de "+ note.getTitre()+".html\n");
		 if(fichHtml.delete())  System.out.print("Suppresion effectue de "+ note.getTitre()+".adoc\n");
	}
	
	public File getFichier() {
		return veriFileExist;
	}



	public String getPath() {
		return path;
	}


	/**
	 *methode override qui renvoie la note en format string
	 */
	public String toString() {
		String  N="";
		BufferedReader reader=null;
        try {
            reader = new BufferedReader(new FileReader(getFichier()));
            String ligne;
            N=ligne = reader.readLine();
            while((ligne = reader.readLine()) != null){
            	N+="\n"+ligne;
            }
        } catch (Exception ex){
            System.err.println("Error. "+ex.getMessage());
        }
        try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return N;
	}
	
	
	
}
