
/*
 * La classe Library ha le seguenti funzionalità:

 * 
 * Un costruttore senza argomenti che crea una biblioteca vuota.
 * I metodi per aggiungere un libro/rivista alla biblioteca. Se il libro era già stato aggiunto, restituisce false.
 * I metodi per prendere in prestito un libro/rivista come argomento e lo dà in prestito, a patto che sia disponibile.
 * La risorsa potrebbe non essere disponibile perché già in prestito o perché non inserita nella biblioteca,
 * e la risposta del metodo deve essere diversa nei due casi.
 * I metodi per restituire un libro/rivista alla biblioteca. Se quel libro non era stato preso in prestito, viene lanciata un'eccezione.
 * Il metodo printLoans stampa la lista dei libri/riviste attualmente in prestito
 */


import java.util.ArrayList;

public class Library {

	private ArrayList<Resource> ResourceList;
	
	
	public Library () {
		
	}
	
	
	private boolean CheckRescource ( Resource input ) {
		
		for ( Resource x : ResourceList ) {
			if ( x.equal(input) ) {
				return true;
			}
		}
		
		return false;
	}
		
	public boolean AddBook ( Book input ) {
		
		if ( CheckRescource(input) == true ) {
			return false;
		}
		
		ResourceList.add(new Book(input));
		
		return true;
	}
	
	public boolean AddMagazine ( Magazine input ) {
		
		if ( CheckRescource(input) == true ) {
			return false;
		}
		
		ResourceList.add(new Magazine(input));
		
		return true;
	}
	
	public boolean RemoveRescorce ( Resource input ) {
		
		if ( CheckRescource(input) == false ) {
			throw new ExceptionResourceUnavailable();
			
		}
		
		ResourceList.remove(input);
		
		return true;
	}
	
	public void PrenotaResource ( Resource input ) {
		
		for ( int i = 0 ; i < ResourceList.size() ; i += 1 ) {
			if ( ResourceList.get(i).equal(input) ) {
				if ( ResourceList.get(i).getPrenotato_Flag() == false ) {
					ResourceList.get(i).setPrenotato_Flag(true);
					return ;
				}
				throw new ExceptionResourceUnavailable();
			}
		}
		
		throw new ExceptionUnknownResource();
		
		
		
	}
	
	public void RestituisciResource ( Resource input ) {
		
		for ( int i = 0 ; i < ResourceList.size() ; i += 1 ) {
			if ( ResourceList.get(i).equal(input) ) {
				if ( ResourceList.get(i).getPrenotato_Flag() == true) {
					ResourceList.get(i).setPrenotato_Flag(false);
					return ;
				}
				throw new ExceptionResourceUnavailable();
				
			}
		}
		throw new ExceptionUnknownResource();
		
		
	}
	
	
	public String getLoans () {
		
		String output = null;
		
		for ( Resource x : ResourceList ) {
			if ( x.getPrenotato_Flag() == true ) {
				output += x.getTitle();
				
			}
		}
		
		return output;
	}
	
	public int N_Resource () {
		return ResourceList.size();
	}
	
	public String getTitle ( int index ) {
		return ResourceList.get(index).getTitle();
	}
	
	public Resource getResource ( int index ) {
		return ResourceList.get(index);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
