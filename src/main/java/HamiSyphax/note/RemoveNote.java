package HamiSyphax.note;


/**
 *Suppression de la note de l'index Lucene
 */
public  class RemoveNote implements Commande{
	
	private OrderNote ordernote;
	private NoteLucene notelucene;
	private NoteFile notefile;
	private Note note;
	
	public RemoveNote(String titre) {
		if(Index.getIndexW()==null) 
		{ System.err.println("L'index Lucene n'est pas initialisé");
		return;
		}
		note=new Note(titre);
		notelucene=new NoteLucene(note, Index.getIndexW());
		notefile= new NoteFile(note);
	}
	
	
	public void execute() {
		 if(note.getTitre().equals("index")) {
			 System.out.println("Impossible de supprimer le fichier index");
			 return;
		 }
		 notelucene.deleteDocLucene();
		 notefile.deleteFichier();
		 ordernote=new OrderNote();
		 ordernote.createIndex();
			}
	}
