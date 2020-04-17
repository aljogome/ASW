package wwwordz.game;

import java.io.Serializable;

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
