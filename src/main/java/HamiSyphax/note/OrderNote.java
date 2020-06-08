package HamiSyphax.note;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;

/**
 * La creation du fichier index pour avior une vision globale sur les fichiers .adoc crees
 * les notes sont ordonnes par ordre alphabetique 
 * par context
 * par projet
 * par date
 */
public class OrderNote {

	private IndexReader reader;
	private NoteFile notefile;
	private static Note note;
	
	public OrderNote() {
		try {
			reader = DirectoryReader.open(Index.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		note=new Note("index");
		notefile=new NoteFile(note);
	}

	
	public TreeMap<String, Set<String> > lister(String champ) {	
		
		TreeMap<String, Set<String> > tree = new TreeMap<>();
		Set<String> tabTitre=null;
		
		for (int i=0; i<reader.maxDoc(); i++) {
				    Document doc = null;
					try {
						doc = reader.document(i);
					} catch (IOException e) {
						e.printStackTrace();
					}
				    String docId = doc.get(champ); // context , project , date 
				    String titre = doc.get("titre");
				    tabTitre=tree.get(docId);
				    if(tabTitre==null) 
				    tabTitre = new TreeSet<String>();
				    tabTitre.add(titre);
				    tree.put(docId,tabTitre);
				}
		return tree;
		}
	
	public String WriteIndex(String facteur) {
	
	String contenu ="\n== Par "+facteur+"\n\n";
	Set<Entry<String, Set<String> > > set = lister(facteur).entrySet();
    Iterator<Map.Entry<String, Set<String> >> it = set.iterator();
    while(it.hasNext()){
        Map.Entry<String, Set<String>> entry = it.next();
        contenu+=("* "+entry.getKey().toString()+"\n");
        
        Iterator<String> titre = entry.getValue().iterator();
        while(titre.hasNext()){
           contenu+=("** link:"+titre.next().toString()+".adoc[]\n");
        }
     }
	return contenu;
	}
	
	public void createIndex() {
		String contenu="= Index\n"+":toc:\n\n";
		contenu+=WriteIndex("context");
		contenu+=WriteIndex("project");
		contenu+=WriteIndex("mois");
		notefile.AddText(contenu);
	}
	
	
}
