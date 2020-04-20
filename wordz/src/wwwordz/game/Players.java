// perceber mecânica entre player e Players e dos métodos getPlayer e posteriores

package wwwordz.game;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

import wwwordz.shared.WWWordzException;

public class Players implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Player> playersMap;
	private static Players single_instance = null;
	static File database = new File("database.txt");
	
	private Players() {
		playersMap = new HashMap<>();
	}
	
	static Players getInstance() {
		if (single_instance == null) {
			return single_instance = new Players();
		}
		return restore();
	}
	
	private void writeObject(ObjectOutputStream serializer) throws IOException {
	    serializer.defaultWriteObject();
	}
	  
	private void readObject(ObjectInputStream deserializer) throws IOException, ClassNotFoundException  {
	    deserializer.defaultReadObject();
	}
	
	private static Players restore() {
	     Players players = null;
	     if (getHome().canRead()) {
	    	 try(
	    		FileInputStream stream = new FileInputStream("database.ser");
	    		ObjectInputStream deserializer = new ObjectInputStream(stream);
	     ) 	{ 
	       players = (Players) deserializer.readObject();
	       } catch(IOException | ClassNotFoundException cause) {
	        cause.printStackTrace();
	      }
	    } else {
	       players = new Players();
	    }
	     return players;
	  } 
	
	private static void backup(Players players) {
	    try(
	        FileOutputStream stream = new FileOutputStream("database.ser");
	        ObjectOutputStream serializer = new ObjectOutputStream(stream);
	      ) { 
	        serializer.writeObject(players);
	    } catch(IOException cause) {
	      cause.printStackTrace();
	    }
	  }

	// ?
	void cleanup() throws WWWordzException, FileNotFoundException {
		PrintWriter pw = new PrintWriter("filepath.txt");
		pw.close();
	}
	
	static File getHome() {
		return database;
	}
	
	static void setHome(File home) {
		database = home;
	}
	
	Player getPlayer(String nick) throws WWWordzException {
		return playersMap.get(nick);
	}
	
	void addPoints(String nick, int points) throws WWWordzException {
		getPlayer(nick).points = getPlayer(nick).points + points;
	}
	
	void resetPoints(String nick) throws WWWordzException {
		getPlayer(nick).points = 0;
	}
	
	boolean verify(String nick, String password) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("database.ser"); 
        ObjectInputStream ois = new ObjectInputStream(fis); 
        
        Player p = (Player)ois.readObject(); 
        ois.close();
        if(password.equals(p.password))
        	return true;
		return false;
	}
	
	public static void main(String args[]) {
		System.out.println("ola");
		Players players = new Players();
	}
}

