package HamiSyphax.note;

import java.sql.Date;

/**
 * Classe qui reunit les differentes attributs de la note
 */
public class Note {

	private final String titre;
	private String nom;
	private String prenom;
	private String email;
	private String context;
	private String project ;
	private String message;
	private String mois;
	
	
	
	public Note(String titre) {
		this.titre=titre;
		nom="nom";
		prenom="prenom";
		email="email@adr.com";
		context="context";
		project="project";
		mois="Null";
		message="message";
	}


		public String getTitre() {
		return titre;
	}
		
		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getContext() {
			return context;
		}


		public void setContext(String context) {
			this.context = context;
		}


		public String getProject() {
			return project;
		}


		public String enTete() {
			Long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			return "= "+titre+"\n\n" + 
					nom+" "+ prenom+" <"+ email+ ">\n\n" + 
					date+"\n\n" + 
					":context:"+context+"\n\n" + 
					":project:"+project+"\n\n"+message+"\n";
		}


		public void setProject(String projet) {
			this.project = projet;
		}


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}




		public String getMois() {
			return mois;
		}


		public void setMois(String mois) {
			this.mois = mois;
		}
	
}