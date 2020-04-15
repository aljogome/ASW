// perceber Date, enums e como usar os get() nestes casos

package wwwordz.game;

import java.util.Date;
import java.util.Map;

import wwwordz.shared.Config;
import wwwordz.shared.Puzzle;

public class Round {

	static enum Relative{
		after, before;
	}
	
	static enum Stage{
		join, play, ranking, report;
	}
	
	Date end;
	static Date join;
	Date play;
	Puzzle puzzle;
	Date ranking;
	Date report;
	Map<String, Player> roundPlayers;
	
	Round(){
		this.end = null;
		this.join = new Date(Config.JOIN_STAGE_DURATION);
		this.play = new Date(Config.PLAY_STAGE_DURATION);
		this.puzzle = null;
		this.ranking = null;
		this.report = null;
		this.roundPlayers = null;
	}
	
	static long getJoinStageDuration() {
		return join.getTime();
	}
	
	static long getPlayStageDuration() {
		return Config.
	}
}
