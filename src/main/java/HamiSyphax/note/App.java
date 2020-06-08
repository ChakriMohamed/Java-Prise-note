package HamiSyphax.note;
import java.io.IOException;
import java.util.Scanner;

/**
 * classe gere l'interaction avec l'utilisateur avec argument et sans argument
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws IOException, Exception
    {	
    	CommandLigne commandeUi = null;
    	Scanner sc = null;
    	Programme p=Programme.EDITEUR;
    	Index index=new Index();

        System.out.println(" ");
        System.out.println("***********************");
        System.out.println("*****edit nom_note ou e nom_note pour modifier ou créer une note******");
		System.out.println("*****view nom_note ou v nom_note pour visualiser une note*************");		
		System.out.println("*****search mot_clé ou s mot_clé pour chercher dans les notes*********");
        System.out.println("*****remove nom_note ou rm nom_note pour supprimer une note***********");
        System.out.println("*****lister ou ls pour afficher toute les notes crées*****************");
		System.out.println("***********************");
        System.out.println(" ");

		
    	if(args.length>1 && args[0].equals("note")) {
    		if(args[1].equals("edit") || args[1].equals("e") ) {
    			commandeUi=new CommandLigne(new EditNote(args[2]));
    	        commandeUi.command();
    		}
    		else if (args[1].equals("view") || args[1].equals("v") ) {
    			commandeUi=new CommandLigne(new ViewNote(args[2]));
    	        commandeUi.command();
    		}
    		else if (args[1].equals("remove") || args[1].equals("rm") ) {
    			commandeUi=new CommandLigne(new RemoveNote(args[2]));
    	        commandeUi.command();
    		}
    		else if (args[1].equals("lister") || args[1].equals("ls") ) {
    			commandeUi=new CommandLigne(new ListerNote());
    	        commandeUi.command();
    		}
    		else if (args[1].equals("search") || args[1].equals("s") ) {
    			commandeUi=new CommandLigne(new SearchNote(args[2]));
    	        commandeUi.command();
    		}
}
    
        String cmd = " ";
        while (!cmd.equals("exit")) {

        System.out.println("\nveuillez saisir une commande et quitter avec exit: ");
        sc = new Scanner(System.in);
        cmd = sc.nextLine();
     	String[] parts = cmd.split(" ");

        if (parts[0].equals("edit") || (parts[0].equals("e"))) {
        	if((parts.length>1)) {
			commandeUi=new CommandLigne(new EditNote(parts[1]));
        	commandeUi.command();
        }
        	
        }
        	  else if ((cmd.equals("lister")) || (cmd.equals("ls"))) {
        		commandeUi = new CommandLigne(new ListerNote());
        		commandeUi.command();
			
		} 
        		else if ((parts[0].equals("remove")) || (parts[0].equals("rm"))) {
        			if(parts.length>1){
        			commandeUi = new CommandLigne(new RemoveNote(parts[1]));
                    commandeUi.command();
        			}
        			
				}
        		else if (parts[0].equals("view") || (parts[0].equals("v"))) {
          			if(parts.length>1) {
          				commandeUi = new CommandLigne(new ViewNote(parts[1]));
          				commandeUi.command();
          			}                  
				}
        
        		else if (parts[0].equals("search") || (parts[0].equals("s"))) {
          			if(parts.length>1) {
        		    commandeUi = new CommandLigne(new SearchNote(parts[1]));
      				commandeUi.command();
          			}                  
				}
        
        		else if (cmd.equals("exit")) {
        			System.out.println("good-bye");
        	        Index.getIndexW().close();
				}
        			else {
						System.err.println("\n le system ne connait pas cette commande"
								+ "\n veuillez revoir les commandes d'utilisation "
								+ "\n d�crite dans le Manuel");
					}
       } //
           sc.close();
           Index.getIndexW().close();
 } //
} //
