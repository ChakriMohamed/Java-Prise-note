package HamiSyphax.note;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SupNoteLuceneTest {

    Programme p=null;
    Index index =null;
    Note note = null;
    NoteLucene noteLuce=null;
    
	@Before
    public void setUp(){
	p=Programme.EDITEUR;

	try {
		index=new Index();
	} catch (Exception e) {
		e.printStackTrace();
	}
	note = new Note("note");
	noteLuce=new NoteLucene(note,Index.getIndexW());// création de NoteLucene grace à une Note
	try {
		NoteLucene.addDoc(noteLuce.createDoc());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	@After
	public void cleanNotes(){
	try {
		Index.getIndexW().close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	@Test
	public void testRemoveNoteLucene() {
		noteLuce.deleteDocLucene();//suprimer la note Lucene
		assertEquals(Index.getIndexW().maxDoc(),0); //test si l'index Lucene est vide 	
		}

}
