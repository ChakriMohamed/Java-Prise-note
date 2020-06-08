package HamiSyphax.note;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AjoutNoteLuceneTest {

    Programme p=null;
    Index index =null;
    Note note = null;
    NoteLucene noteLuce=null;
    int nbr_doc=0;
    
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
	}
	
	
	@After
	public void cleanNotes(){
	noteLuce.deleteDocLucene();//suprimer la note Lucene
}
	
	@Test
	public void testAjoutNoteLucene() {
		
		nbr_doc=Index.getIndexW().maxDoc();
		try {
			NoteLucene.addDoc(noteLuce.createDoc()); //ajouter la noteLucene dans l'index Writer
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//tester l'ajout de la noteLucene  dans l'indexWriter
		assertEquals(Index.getIndexW().maxDoc(),nbr_doc+1);

	}

}
