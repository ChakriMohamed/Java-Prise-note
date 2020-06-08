package HamiSyphax.note;

import java.io.File;
import java.io.IOException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * L'index qui permet la sauvegarde des notes par attribut , ainsi les rechercher par la suite
 */
public class Index {
	// 0. Specify the analyzer for tokenizing text.
	//    The same analyzer should be used for indexing and searching
	private StandardAnalyzer analyzer;
	private static Directory path ;
	private IndexWriterConfig config;
	private static  IndexWriter w=null;
	private final String chemin_sauvegarde;
	
	
	public Index() throws IOException, Exception {
		chemin_sauvegarde="FichierRechercheLucene/";
		analyzer = new StandardAnalyzer(Version.LUCENE_40); //analyse le text enleve des caracteres
		// 1. create the index
		if(Programme.getChemin_fichier()!=null) {
		path = FSDirectory.open(new File(Programme.getChemin_fichier()+chemin_sauvegarde)) ;
		config = new IndexWriterConfig(Version.LUCENE_40, analyzer);
	    setIndexW(new IndexWriter(path, config));
		Index.getIndexW().commit();
		System.out.println("Fichiers initialisés à :"+Programme.getChemin_fichier()+chemin_sauvegarde);
		}
		else System.out.println("Chemin fichiers recherche Lucene introuvable");
		}


	public static IndexWriter getIndexW() {
		return w;
	}


	public static void setIndexW(IndexWriter w) {
		Index.w = w;
	}

	public static Directory getPath() {
		return path;
	}


	public static void setPath(Directory path) {
		Index.path = path;
	}
	
}
