import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/*
 * Class to model the entitiy Airplane
 * @author Emma Chiusano
 * @verson 0.1
 * Date of Creation: 8 September, 2021
 * Last Date Modified: 10 September, 2021
 * */
public class Airplane {
	//data members
	private char[][] seatMap;
	//constructors
	/*default constructor
	no parameters
	initializes seatMap */
	public Airplane() {
		seatMap=new char[9][8];
		for (int i=0; i<seatMap.length; i++) {
			for (int j=0; j<seatMap[i].length; j++) {
				seatMap[i][j]='.';
			}
		}
	}

	/*default constructor
	 *@param String filename
	 initializes seatMap array*/
	public Airplane (String filename) {
		seatMap=new char[9][8];
		readMap(filename);
	}
	/*Method to read the current seat map, if there is one
	 * @param String fileName, takes in the filename from seatReservation
	 * @return exception if the file is not found*/
	private void readMap(String fileName) {
		File file=new File(fileName);
		try {
			Scanner readFile=new Scanner(file);
			for (int i=0; i<seatMap.length; i++) {
				for (int j=0; j<seatMap[i].length; j++) {
					seatMap[i][j]=readFile.next().charAt(0);
				}
			}
			readFile.close();
		}
		catch (FileNotFoundException e) {
			for (int i=0; i<seatMap.length; i++) {
				for (int j=0; j<seatMap[i].length; j++) {
					seatMap[i][j]='.';
				}
			}
		}
	}
	/*Method to check if teh seat entered exists
	 * @param String seat
	 * @return true if the seat exists, otherwise throw an exception*/
	private boolean checkSeat (String seat)throws InvalidSeatException{
		if (seat.matches("[1-9][A-H]")) {
			return true;
		}
		throw new InvalidSeatException("Invalid Seat Number. Must be [1-9][A-H]");
	}
	/*Method to reserve a seat
	 * @param String seat
	 * @return true if the seat is reserved, otherwise throw exception adn return false*/
	public boolean reserveSeat(String seat) throws InvalidSeatException{
		if(checkSeat(seat)) {
			int row=seat.charAt(0)-'1';
			int col=seat.charAt(1)-'A';
			if (seatMap[row][col]=='.') {//seat is free
				seatMap[row][col]='X';
				return true;
			}
		}
		return false;
	}
	/*Method to free a seat
	 * @param String seat
	 * @return true if the seat is freed, otherwise throw exception adn return false*/
	public boolean freeSeat(String seat) throws InvalidSeatException{
		if(checkSeat(seat)) {
			int row=seat.charAt(0)-'1';
			int col=seat.charAt(1)-'A';
			if (seatMap[row][col]=='X') {//seat is occupied
				seatMap[row][col]='.';
				return true;
			}
		}
		return false;
	}
	/*Method to save the seatmap
	 * @param String filename
	 * @return saved seatmap to the file*/
	public void saveMap(String filename) {
		File file=new File(filename);
		try {
			PrintWriter writeFile=new PrintWriter(file);
			for (int i=0; i<seatMap.length; i++) {
				for (int j=0; j<seatMap[i].length; j++) {
					writeFile.print(seatMap[i][j]+" ");
				}
				writeFile.println();
			}
			writeFile.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Cannot write to "+filename);
		}
	}
	/*Method to print the map to string
	 * @param none
	 * @return the map*/
	public String toString() {
		String s = "\tA\tB\tC\tD\tE\tF\tG\tH\n";
		for(int i=0; i<seatMap.length; i++) {
			s+=(i+1)+"\t";
			for(int j=0; j<seatMap[i].length; j++) {
				s+=(seatMap[i][j]+"\t");
			}
			s+="\n";
		}
		return s;
	}
}
