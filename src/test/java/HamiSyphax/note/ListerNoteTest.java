package HamiSyphax.note;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import HamiSyphax.note.Programme;


import static org.junit.Assert.*;


public class ListerNoteTest {
	
	Programme p;
	Note n1=new Note("test1");
	NoteFile note1;
	Note n2=new Note("index");
	NoteFile index ;

	
	@Before
    public void setUp(){
		p=Programme.EDITEUR;
		note1=new NoteFile(n1);
		note1.creerNote();
		index=new NoteFile(n2);
		index.creerNote();
	}
	
	@After
    public void clean(){
		note1.deleteFichier();
		index.deleteFichier();
	}
	
	
	@Test
	public void test() {		
		String ldn= "index.adoc"+"test1.adoc";
		ListerNote ln=new ListerNote();
		String ListeDesNotes=ln.lister();
		assertEquals(ListeDesNotes,ldn);
		
	}

}