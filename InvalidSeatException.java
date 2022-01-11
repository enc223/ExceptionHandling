/*
 * Class to model the entitiy Airplane
 * @author Emma Chiusano
 * @verson 0.1
 * Date of Creation: 8 September, 2021
 * Last Date Modified: 10 September, 2021
 * */
public class InvalidSeatException extends Exception{
	//constructors
	/*default constructor
	no parameters
	initializes the seat exception */
	public InvalidSeatException() {
		super();
	}
	/*default constructor
	@param String messge
	returns the message of our exception */
	public InvalidSeatException(String message) {
		super(message);
	}
}
