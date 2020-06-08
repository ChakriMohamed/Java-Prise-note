package HamiSyphax.note;

import java.io.IOException;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
/**
 * classe qui gere l'insertion et la mise à jour et la suppression d'une note dans l'index Lucene
 * cette classe a besoin d'une instance Note deja initialiser
 * @author mohammed
 */
public class NoteLucene {

	
	private Note note;
	private static IndexWriter iw;
	Document doc;
	
	
	public NoteLucene(Note note,IndexWriter index) {
		this.note=note;
		iw=index;
		}
	
	public Document getDoc() {
		return doc;
	}

	/**
	 *@param  doc 
	 *methode ajoute le Document dans l'index Lucene approprier
	 */
	
	public static void addDoc(Document doc) throws IOException {
		iw.addDocument(doc);
	    iw.commit();
	}

	/**
	 * la method qui initialise le Document avec les attributs de la classe note
	 * @return Document
	 */
	public Document createDoc() {
            doc = new Document();
			doc.add(new TextField("titre", note.getTitre(), Field.Store.YES));
			doc.add(new TextField("nom", note.getNom(), Field.Store.YES));
			doc.add(new TextField("prenom", note.getPrenom(), Field.Store.YES));
			doc.add(new TextField("email", note.getEmail(), Field.Store.YES));
			doc.add(new TextField("context", note.getContext(), Field.Store.YES));
			doc.add(new TextField("project", note.getProject(), Field.Store.YES));
			doc.add(new TextField("message", note.getMessage(), Field.Store.YES)); // à modifier avec le contenu de la note
			doc.add(new TextField("mois", note.getMois(), Field.Store.YES)); // à modifier avec le contenu de la note
			return doc;
}
	
	/**
	 * Methode qui effectue les mise a jour en cherchant le document qui correspend au titre de la note
	 */
	public void updateDocLucene() {
		Term term= new Term("titre",note.getTitre());
		doc=createDoc();
		try {
			iw.updateDocument(term, doc);
			iw.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	
	/**
	 * Methode qui effectue la suppression de la note de l'index Lucene en cherchant le titre qui lui correspend
	 */
	public void deleteDocLucene() {
		   Term term= new Term("titre",note.getTitre());
		   try {
			iw.deleteDocuments(term);
			iw.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	  }
	
}
