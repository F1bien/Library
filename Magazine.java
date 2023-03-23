
/*
 * mentre una rivista (magazine) ha un numero progressivo e data pubblicazione. 
 */

import java.time.LocalDate;

public class Magazine extends Resource {
	
	private LocalDate dataPublicazione;
	private int id;
	private static int ID = 0;
	
	public Magazine(
			String title,
			LocalDate date,
			boolean CheckLib,
			LocalDate dateP
			) {
		super(title, date, CheckLib);
		
		
		this.dataPublicazione = date;
		
		this.id = this.ID;
		this.ID += 1;
		
	}
	
	public Magazine(
			Magazine input
			) {
		super(input.getTitle(), input.getDataUscita(), input.getLibreria_Flag());
		
		
		this.dataPublicazione = input.getdataPublicazione();
		
		this.id = input.getId();
		
		
	}
	
	public LocalDate getdataPublicazione() {
		return this.dataPublicazione;
	}

	public int getId() {
		return this.id;
	}

	public boolean equal ( Resource input ) {
		
		if ( input.toString().equals(this.toString()) ) {
			return true;
		}
		return false;		
	}
	
	public String toString () {
		return super.toString() + dataPublicazione;
	}
	
	

}
