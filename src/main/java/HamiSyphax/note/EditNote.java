package HamiSyphax.note;

import java.io.IOException;

/**
 * classe qui herite de l'interface commande et qui permet de gerer la creation et la modification note 
 * dans le dossier de sauvegarde et dans l'index Lucene
 */

public class EditNote implements Commande {
	private Note note;
	private NoteFile notefile;
	private Programme p;
	private NoteLucene docLuce;
	private ReadNote readNote;
	private OrderNote ordernote;
	
	public EditNote(String titre) throws IOException, Exception {
	p=Programme.EDITEUR;
	note=new Note(titre);
	docLuce=new NoteLucene(note,Index.getIndexW());
	readNote=new ReadNote(note);
	notefile=new NoteFile(note);
	}
	

	public void execute() {
	if(note.getTitre().equals("index")) {
		System.out.println("Impossible de modifier le fichier index");
		return;
	}
	
	if(notefile.existeNote()==true) {
		ouvrirNote();
		updateNote();
		docLuce.updateDocLucene();
	}
	
	else {
		notefile.AddText(note.enTete());
		ouvrirNote();
		updateNote();
		try {
			NoteLucene.addDoc(docLuce.createDoc());
		} catch (IOException e) {
			e.printStackTrace();
		}
	     }
	ordernote=new OrderNote();
	ordernote.createIndex();
    }
	
	
	public void ouvrirNote() {
		p.run(notefile.getPath());
		try {
			p.getProg().waitFor(); 
		    } catch (InterruptedException e1) {
			e1.printStackTrace();
		}
}
	
	public void updateNote() {
		readNote.AttributNote();
		readNote.LireNote();
	}
	
	

}
