//Lukas Paolo Toshisuke Cortes Alfaro 22.108.123-4 ICCI
//Cristian Harold Wilson Andreu 21.887.896-2 ICCI
package logica;

public class Main {

	public static void main(String[] args) {
		
		int opcionMenu = 0;
		
		do {
			System.out.println("Menu de ingreso:");
			System.out.println("1) Admin.");
			System.out.println("2) Usuario.");
			System.out.println("3) Salir.");
			switch(opcionMenu) {
			case 1:
				System.out.println("Ingresó como admin.");
				break;
			case 2:
				System.out.println("Ingresó como Usuario");
			case 3:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Ingresó una opción invalida, ingrese de nuevo...");
				break;
			}
				
		}while(opcionMenu != 3);
		
	}

}
