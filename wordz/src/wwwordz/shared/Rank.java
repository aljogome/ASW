package wwwordz.shared;

import java.io.Serializable;

public class Rank implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int accumulated;
	String nick;
	int points;
	
	public Rank(){
		nick = null;
	}
	
	public Rank(String nickname, int pts, int accum){
		this.accumulated = accum;
		this.points = pts;
		this.nick = nickname;
	}
	
	int getAccumulated() {
		return this.accumulated;
	}
	
	void setAccumulated(int accum) {
		this.accumulated = accum;
	}
	
	String getNick() {
		return this.nick;
	}
	
	void setNick(String nickname) {
		this.nick = nickname;
	}

	int getPoints() {
		return this.points;
	}
	
	void setPoints(int pts) {
		this.points = pts;
	}
}
