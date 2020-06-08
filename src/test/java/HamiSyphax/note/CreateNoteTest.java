package HamiSyphax.note;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateNoteTest {
	
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
	public void testCreateNote() {
		assertTrue(notefile.getFichier().isFile());
	}
	
}