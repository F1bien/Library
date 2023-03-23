import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
	
	private static Library Biblioteca;
	
	public static void main ( String[] args ) {
		
		Scanner input = new Scanner(System.in);
		
		int option;
		boolean exit = false;
		
		do {
			
			System.out.println("Inserire opzione\n"
							 + "0) aggiungere una risorsa"+"\n"
							 + "1) remuovere una risosrsa"+"\n"
							 + "2) prendere in prestito una risosrsa"+"\n"
							 + "3) restituire una risosrsa"+"\n"
							 + "4) stampa prestiti"+"\n"
							 + "5) exit"+"\n");

			option = input.nextInt();
			while ( option >= 0 && option <= 5 ) {
				System.out.println("\n\topzione non disponobile, riprova");
				option = input.nextInt();
			}
			
			
			
			switch (option) {
			
			case 0: // new resource
					
					System.out.println("voui inserire un libro o una rivista\n"
							+ "0) libro" + "\n"
							+ "1) rivista");
					option = input.nextInt();
					while ( !(option == 0 || option == 1) ) {
						System.out.println("\n\topzione non disponobile, riprova");
						option = input.nextInt();
						
					}
					if ( option == 0 ) {	
						if (Biblioteca.AddBook(InputBook())) {
							System.out.println("Risorsa aggiunta");
						}
					}
					if ( option == 1 ) {	
						if (Biblioteca.AddMagazine(InputMagazine())) {
							System.out.println("Risorsa aggiunta");
						}
					}
					
				break;
				
			case 1: // remove resource
					
					
					try {
						Biblioteca.RemoveRescorce(SelectResuorce());
						
					} catch ( ExceptionResourceUnavailable e ) {
						System.out.println(e.getMessage());
					}
				
					
				break;
				
			case 2: // loan resource
				
					try {
						Biblioteca.PrenotaResource(SelectResuorce());
						
					} catch ( Exception e ) {
						System.out.println(e.getMessage());
					}
					
				break;
				
			case 3: // return resource
					
					try  {
						Biblioteca.RestituisciResource(SelectResuorce());
						
					} catch ( Exception e ) {
						System.out.println(e.getMessage());
					}
			
				break;
				
			case 4: // print loans
				
				System.out.println(Biblioteca.getLoans());
				
			break;
			
			case 5: // exit for program
				exit = true;
				break;
			

				
				
				
			}
			
			
			
		}
		while( exit );
		
		
		input.close();
		
	}
	
	private static Book InputBook () {
		Scanner input = new Scanner(System.in);
		
		String Str1;
		LocalDate Date1;
		Boolean bool1;
		String Str2;
		String Str3;

		boolean exit = true;
		Book output = null;
		do {
			
			System.out.println("inserire titolo\n");
			Str1 = input.next();
			System.out.println("inserire data uscita\n");
			Date1 = dateInput(input.next());
			bool1 = true;
			System.out.println("inserire autore\n");
			Str2 = input.next();
			System.out.println("inserire ISBN\n");
			Str3 = input.next();

			 try { 
				output = new Book(
								Str1,
								Date1,
								bool1,
								Str2,
								Str3);
				
			 } catch ( InvalidISBNException e ) {
				 System.out.println(e.getMessage());
				 exit = false;
			 }
			 
			}while ( !exit );
		
		input.close();
		
		return output;
		
	}
	
	private static Magazine InputMagazine () {
		Scanner input = new Scanner(System.in);
		
		String Str1;
		LocalDate Date1;
		LocalDate Date2;
		Boolean bool1;

		Magazine output = null;
		
		System.out.println("inserire titolo\n");
		Str1 = input.next();
		System.out.println("inserire data uscita\n");
		Date1 = dateInput(input.next());
		bool1 = true;
		System.out.println("inserire data publicazione\n");
		Date2 = dateInput(input.next());

		output = new Magazine(
							Str1,
							Date1,
							bool1,
							Date2);
	
		input.close();
	
		return output;
	}
		
	private static Resource SelectResuorce () {
		Scanner input = new Scanner(System.in);
		
		int option;
		
		System.out.println("voui inserire un libro o una rivista\n"
				+ "0) libro" + "\n"
				+ "1) rivista");
		for ( int i = 0 ; i < Biblioteca.N_Resource() ; i += 1 ) {
			System.out.println(i + ") " + Biblioteca.getTitle(i));
		}
		
		option = input.nextInt();
		
		while ( option >= 0 && option < Biblioteca.N_Resource() ) {
			System.out.println("\n\tlibro non disponobile, riprova");
			option = input.nextInt();
			
		}
		
		
		input.close();
		
		return Biblioteca.getResource(option);
	}
	
	
	
	
	public static LocalDate dateInput(String userInput) {

	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate date = LocalDate.parse(userInput, dateFormat);


	    //System.out.println(date);
	    return date ;
	}
	
	
	
}
