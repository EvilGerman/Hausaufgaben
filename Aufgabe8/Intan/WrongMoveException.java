/**
 * Sollte geworfen werden, wenn eine Zahl in das freie Feld geschoben werden
 * soll, die nicht an dieses angrenzt.
 * 
 * @author Intan
 *
 */

public class WrongMoveException extends RuntimeException {

	public WrongMoveException() {
		super("Zug ist nicht moeglich");
	}

}
