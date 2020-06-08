package HamiSyphax.note;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class RemoveNoteTest {
    Programme p=Programme.EDITEUR;
    Note note = new Note("note");
    NoteFile notefile=new NoteFile(note);
      
	@Before
    public void setUp(){
	notefile.creerNote();
	}
	
	
	@After
	public void cleanNotes(){
	notefile.deleteFichier();
}
	
	@Test
	public void TestRemoveNote() {
		notefile.deleteFichier();
		assertNotEquals(notefile.getFichier(),null);
	}

}
