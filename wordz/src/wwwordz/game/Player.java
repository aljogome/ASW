package wwwordz.game;

import java.io.Serializable;

import wwwordz.shared.Table;

public class Player implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int accumulated;
	String nick;
	String password;
	int points;
	
	Player(String nick, String password){
		this.nick = nick;
		this.password = password;
		this.points = 0;
		this.accumulated = 0;
	}
	
	 @Override
	 public String toString() { 
		 return nick+"\t"+password+"\t"+points+"\t"+accumulated; 
	 }

	 @Override
	 public boolean equals(Object obj) {
		Player other = (Player) obj;
		if(nick.equals(other.nick) && password.equals(other.password) && points == other.points && accumulated == other.accumulated)
			return true;
		return false;
	 }
	
	int getAccumulated() {
		return accumulated;
	}
	
	String getNick() {
		return nick;
	}
	
	String getPassword() {
		return password;
	}
	
	int getPoints() {
		return points;
	}
	
	void setAccumulated(int accumulated) {
		this.accumulated = accumulated;
	}
	
	void setNick(String nick) {
		this.nick = nick;
	}
	
	void setPassword(String password) {
		this.password = password;
	}
	
	void setPoints(int points) {
		this.points = points;
		this.accumulated = this.accumulated + points;
	}
}
