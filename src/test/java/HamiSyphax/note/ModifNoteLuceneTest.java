package HamiSyphax.note;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModifNoteLuceneTest {

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
	try {
		Index.getIndexW().addDocument(noteLuce.createDoc());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //ajouter la noteLucene dans l'index Writer

	}
	
	@After
	public void cleanNotes(){
	noteLuce.deleteDocLucene();
	try {
		Index.getIndexW().deleteAll();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		Index.getIndexW().close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	@Test
	public void testModifNoteLucene() {		
		note.setMessage("Je suis un autre message dans la note Lucene");
		noteLuce.updateDocLucene(); //mise a jour dans lucene
		//tester que la mise a jour a été faite dans la note Lucene
		assertEquals(noteLuce.getDoc().get("message"),note.getMessage());
	}

}
