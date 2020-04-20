// perceber Date, enums e como usar os get() nestes casos

package wwwordz.game;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import wwwordz.shared.Configs;
import wwwordz.shared.Puzzle;
import wwwordz.shared.Rank;

public class Round {

	static enum Relative{
		after, before;
	}
	
	static enum Stage{
		join, play, ranking, report;
	}
	
	Date end;
	static Date join = new Date(Configs.JOIN_STAGE_DURATION);
	static Date play = new Date(Configs.PLAY_STAGE_DURATION);
	Puzzle puzzle;
	static Date ranking = new Date(Configs.RANKING_STAGE_DURATION);
	static Date report = new Date(Configs.REPORT_STAGE_DURATION);
	Map<String, Player> roundPlayers;
	
	public Round(){
		this.end = null;
		this.puzzle = null;
		this.roundPlayers = null;
	}
	
	static long getJoinStageDuration() {
		return join.getTime();
	}
	
	static long getPlayStageDuration() {
		return play.getTime();
	}
	
	Puzzle getPuzzle() {
		return puzzle;
	}
	
	public List<Rank> getRanking(){
		List<Rank> ranks = new LinkedList<Rank>();
		for(Map.Entry<String, Player> entry : roundPlayers.entrySet()) {
			Player player = entry.getValue();
			ranks.add(new Rank(player.getNick(), player.getPoints(), player.getAccumulated()));
		}
		return ranks;
	}
	
	static long getRankingStageDuration() {
		return ranking.getTime();
	}
	
	static long getReportStageDuration() {
		return report.getTime();
	}
	
	static long getRoundDuration() {
		return getJoinStageDuration() + getPlayStageDuration() + getRankingStageDuration() + getReportStageDuration();
	}
	
	// long getTimeToNextPlay()
	
	long register(String nick, String password) {
		roundPlayers.put(nick, new Player(nick, password));
		return getJoinStageDuration(); // what to return?
	}
	
	static void setJoinStageDuration(long joinStageDuration) {
		join.setTime(joinStageDuration);
	}
	
	static void setPlayStageDuration(long playStageDuration) {
		play.setTime(playStageDuration);
	}
	
	void setPoints(String nick, int points){
		roundPlayers.get(nick).setPoints(points);
	}
	
	static void setRankingStageSuration(long rankingStageDuration) {
		ranking.setTime(rankingStageDuration);
	}
	
	static void setReportStageDuration(long reportStageDuration) {
		report.setTime(reportStageDuration);
	}
}
