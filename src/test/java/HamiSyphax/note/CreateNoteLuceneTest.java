package HamiSyphax.note;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateNoteLuceneTest {

    Programme p=null;
    Index index =null;
    Note note = null;
    NoteLucene noteLuce=null;
      
    
	@Before
    public void setUp(){
	try {
		index=new Index();
	} catch (Exception e) {
		e.printStackTrace();
	}
	note = new Note("note");
	p=Programme.EDITEUR;
	noteLuce=new NoteLucene(note,Index.getIndexW());// création de NoteLucene grace à une Note
	noteLuce.createDoc();
	}
	
	
	@After
	public void cleanNotes(){
	noteLuce.deleteDocLucene();
	try {
		Index.getIndexW().close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	@Test
	public void testCreateNoteLucene() {
		assertEquals(noteLuce.getDoc().get("titre"),note.getTitre());
		assertEquals(noteLuce.getDoc().get("nom"),note.getNom());
		assertEquals(noteLuce.getDoc().get("prenom"),note.getPrenom());
		assertEquals(noteLuce.getDoc().get("message"),note.getMessage());
		assertEquals(noteLuce.getDoc().get("mois"),note.getMois());
	}
}
