package HamiSyphax.note;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import HamiSyphax.note.Index;
import HamiSyphax.note.Note;
import HamiSyphax.note.NoteLucene;
import HamiSyphax.note.Programme;
import HamiSyphax.note.SearchNote;



public class SearchNoteTest {
    Programme p=null;
    Index index =null;
    Note note = null;
    NoteLucene noteLuce=null;
    SearchNote snote=null;
    
	@Before
    public void setUp(){
		p=Programme.EDITEUR;

	try {
		index=new Index();
	} catch (Exception e) {
		e.printStackTrace();
	}
	note = new Note("note");
	note.setProject("java");
	noteLuce=new NoteLucene(note,Index.getIndexW());// création de NoteLucene grace à une Note
	try {
		NoteLucene.addDoc(noteLuce.createDoc());
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} //ajouter la noteLucene dans l'index Writer

	try {
		snote=new SearchNote("nom");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	@After
	public void cleanNotes(){
		noteLuce.deleteDocLucene();
}
	
	@Test
	public void testSearchLuceneNote() {
	String out="1. java trouver dans le fichier note.adoc dans le champ project";
	assertEquals(out,snote.afficher_result("java","project"));

	}
    
    
    

}
