import java.time.LocalDate;

/*
 *	Un libro (book) ha anche un codice ISBN (stringa di 13 cifre) e autore , 
 */


public class Book extends Resource {

	private String  ISBN ;
	private String autore;
	
	public Book(
			String title,
			LocalDate date,
			boolean CheckLib,
			String autore,
			String ISBN
			) {
		super(title, date, CheckLib);
		
		
		this.autore = autore;
		
		setISBN(ISBN);
		
	}
	
	public Book(
			Book input
			) {
		super(input.getTitle(), input.getDataUscita(), input.getLibreria_Flag());
		
		
		this.autore = input.getAutore();
		
		setISBN(input.getISBN());
		
	}
	
	
	
	public String getAutore() {
		return this.autore;
	}
	
	public String getISBN() {
		return this.ISBN;
	}

	public void  setISBN( String input ) {
		
		if ( input.length() == 13 ) {
			this.ISBN = input;			
		}
		else {
			this.ISBN = null;
			throw new InvalidISBNException();
		}
		
	}
	
	
	public boolean equal ( Resource input ) {
		
		if ( input.toString().equals(this.toString()) ) {
			return true;
		}
		return false;		
	}

	
	public String toString () {
		return super.toString() + ISBN + autore;
	}
	
	

}
