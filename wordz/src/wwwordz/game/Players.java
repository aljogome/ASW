// perceber mecânica entre player e Players e dos métodos getPlayer e posteriores

package wwwordz.game;

import java.io.*;
import java.util.Scanner;

public class Players implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static File database;
	
	private static Players single_instance = null;
	
	static Players getInstance() {
		if (single_instance == null) {
			database = new File("database.txt");
			return single_instance = new Players();
		}
		database = restore();
		return single_instance;
	}
	
	private static File restore() {
		// TODO Auto-generated method stub
		return null;
	}

	void cleanup() throws FileNotFoundException {
		PrintWriter cln = new PrintWriter("database.txt");
	}
	
	static File getHome() {
		return database;
	}
	
	static void setHome(File home) {
		database = home;
	}
	
	Player getPlayer(String nick) throws FileNotFoundException {
		Scanner infile = new Scanner(getHome());
		String nickname = "";
		String password;
		String l;
		while((l=infile.nextLine()) != null) {
			if(l.equals(nick)) {
				nickname = nick;
				break;
			}
		}
		password = infile.nextLine();
		return new Player(nickname, password);
	}
	
	void addPoints(String nick, int points) throws FileNotFoundException {
		getPlayer(nick).points = getPlayer(nick).points + points;
	}
	
	void resetPoints(String nick) throws FileNotFoundException {
		getPlayer(nick).points = 0;
	}
	
	boolean verify(String nick, String password) throws FileNotFoundException {
		Player verif = getPlayer(nick);
		if(verif.nick.equals(nick) && verif.password.equals(password))
			return true;
		return false;
	}
}

