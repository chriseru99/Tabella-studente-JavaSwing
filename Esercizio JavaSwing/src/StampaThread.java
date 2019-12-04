
public class StampaThread extends Thread{
	Esame e = new Esame();
public StampaThread(Esame es) {
	this.e=es;
}
public void run() {
	System.out.println("Codice: " + e.codice );
	System.out.println("Descrizione "+ e.descrizione);
	System.out.println("Voto: "+ e.voto);
}
}
