import java.util.Scanner;
/*
 * Class to model the entitiy Airplane
 * @author Emma Chiusano
 * @verson 0.1
 * Date of Creation: 8 September, 2021
 * Last Date Modified: 10 September, 2021
 * */
public class SeatReservation {
	/*Main method*/
	public static void main(String[]args) {
		//data members
		Airplane myAirplane=new Airplane("seatsmap.txt");//creates a new instance of airplane
		Scanner keyboard=new Scanner(System.in);//inputs the scanner
		int operation=0;//initializes the operation to 0 to be used in our do while statement
		String seat; //initializes the string seat
		do {
			try {
				System.out.println(myAirplane.toString());//prints the airplane grid
			printMenu();//calls hte printmenu method
			operation= keyboard.nextInt();
			switch(operation) {
			case 1://reserve a seat
				System.out.println("Enter a seat number:");
				seat =keyboard.next();
				if(myAirplane.reserveSeat(seat)) {
					System.out.println("Seat "+seat+" successfully reserved.");
				}else {
					System.out.println("Seat "+seat+" already reserved.");
				}
				break;
			case 2://free a seat
				System.out.println("Enter a seat number:");
				seat =keyboard.next();
				if(myAirplane.freeSeat(seat)) {
					System.out.println("Seat "+seat+" successfully freed.");
				}else {
					System.out.println("Seat "+seat+" already free.");
				}
				break;
			case 3://saves the seat map
				myAirplane.saveMap("seatsmap.txt");
				System.out.println("Thank you for using my airplane program.");
				break;
			default:
				System.out.println("Invalid operation. Must be from 1-3.");
			 }
			}
			catch(InvalidSeatException e) {
				System.out.println(e.getMessage());
			}
		}while (operation!=3);
	}
	/*Method to print the main menu
	 * @param none
	 * @return main menu*/
	public static void printMenu() {
		System.out.println("Select an Operation");
		System.out.println("1: Reserve Seat");
		System.out.println("2: Free a Seat");
		System.out.println("3: Quit");
	}
}
