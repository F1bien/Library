
/*
 * si implementi una classe Resource, che rappresenta una pubblicazione.
 * Ciascuna pubblicazione ha un titolo e una data di uscita.
 * Implementare le sottoclassi Book e Magazine.
 */

import java.time.LocalDate;


public abstract class Resource {

	
	protected String title;
	protected LocalDate dataUscita;
	private boolean prestito;
	private boolean libreria_Flag;
	
	public Resource ( 
			String title,
			LocalDate date,
			boolean CheckLib
			) {
		this.title = title;
		this.dataUscita = date;
		this.libreria_Flag = CheckLib;
		this.prestito = false;
	}
	
	public LocalDate getDataUscita() {
		return this.dataUscita;
	}

	public String getTitle() {
		return this.title;
	}
	
	public boolean getLibreria_Flag() {
		return this.libreria_Flag;
	}
	
	public boolean getPrenotato_Flag() {
		return this.prestito;
	}
	
	public void setPrenotato_Flag( boolean input ) {
		this.prestito = input;
	}
	
	
	
	public boolean equal ( Resource input ) {
		
		if ( input.toString().equals(this.toString()) ) {
			return true;
		}
		return false;		
	}
	
	
	public String toString () {
		return title + dataUscita;
	}
	
	
	
	
	
}
