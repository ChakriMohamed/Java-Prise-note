package HamiSyphax.note;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class EditNoteTest {
	
    Programme p=Programme.EDITEUR;
    Note note = new Note("note");
    NoteFile notefile=new NoteFile(note);
    Note note1=new Note("note");
    
      
	@Before
    public void setUp(){
	notefile.AddText(note.enTete());
	}
	
	
	@After
	public void cleanNotes(){
	notefile.deleteFichier();
  }
	
	@Test
	public void testEditNote() {
	note.setMessage("Bonjour je suis la meme note mais avec un autre contenu");
	notefile.AddText(note.enTete());
	assertEquals(notefile.toString(),note.enTete());
	assertNotEquals(note.toString(),note1.enTete());

	}
	
	
	

}
