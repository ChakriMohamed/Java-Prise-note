package HamiSyphax.note;

import java.io.File;
import java.io.IOException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 *Recherche de la note de l'index Lucene
 */

public class SearchNote implements Commande {
	
	private final String mot_cle;
	private StandardAnalyzer analyzer;
	private static Directory path ;
	private IndexReader reader;
	private IndexSearcher searcher;
	private final String chemin_sauvegarde="FichierRechercheLucene/";
	
	
	public SearchNote(String mot) throws IOException {
        this.mot_cle=mot;
		analyzer = new StandardAnalyzer(Version.LUCENE_40); //analyse le text enleve des caracteres
		path = FSDirectory.open(new File(Programme.getChemin_fichier()+chemin_sauvegarde)) ;
		reader = null;
}
	
	public Query requete(String mot_cle,String champ) {
		// 2. query
		// the "title" arg specifies the default field to use		

		// when no field is explicitly specified in the query.
		Query q = null;
		try {
			q = new QueryParser(Version.LUCENE_40, champ, analyzer).parse(mot_cle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}


	public ScoreDoc[] recherche(String mot_cle , String champ) {
	// 3. search
	int hitsPerPage = 10;
	try {
		reader = DirectoryReader.open(path);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	searcher = new IndexSearcher(reader);
	TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
	try {
		searcher.search(this.requete(mot_cle,champ), collector);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ScoreDoc[] hits = collector.topDocs().scoreDocs;
	return hits;
	}
	

	public String afficher_result(String mot_cle, String champ) {
		String ss = "";
	ScoreDoc[] hits=recherche(mot_cle,champ);
	// 4. display results
	if(hits.length>0) {
	System.out.println("Trouver " + hits.length + " fichiers.");
	for (int i = 0; i < hits.length; ++i) {
		int docId = hits[i].doc;
		Document d = null;
		try {
			d = searcher.doc(docId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ss=i+1+". "+mot_cle+" trouver dans le fichier "+ d.get("titre")+".adoc "+"dans le champ "+champ; 
		System.out.println((i + 1) + ". " + mot_cle+ " trouver dans le fichier " + d.get("titre")+".adoc "+"dans le champ "+champ);
	}
	// reader can only be closed when there
	// is no need to access the documents any more.
	try {
		reader.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	return ss;
}
	
	public void rechercheNote() {
		this.afficher_result(mot_cle, "nom");
		this.afficher_result(mot_cle, "prenom");
		this.afficher_result(mot_cle, "context");
		this.afficher_result(mot_cle, "project");
		this.afficher_result(mot_cle, "message");		
		this.afficher_result(mot_cle, "email");
	}
	
	@Override
	public void execute() {
	rechercheNote();
	}
	
	
}
