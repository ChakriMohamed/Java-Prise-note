package HamiSyphax.note;

public class CommandLigne {
	Commande commande ;
	
	
	public CommandLigne(Commande commande) {
		this.commande = commande ;
	}
	
	public void command() {
		commande.execute();
	}
	
}
