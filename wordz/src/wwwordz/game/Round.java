// perceber Date, enums e como usar os get() nestes casos

package wwwordz.game;

import java.util.Date;
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
	
	// List<Rank> getRanking()
	
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
	
	// long register()
	
	static void setJoinStageDuration(long joinStageDuration) {
		join.setTime(joinStageDuration);
	}
	
	static void setPlayDuration(long playStageDuration) {
		play.setTime(playStageDuration);
	}
	
	// void setPoints()
	
	static void setRankingStageDuration(long rankingStageDuration) {
		ranking.setTime(rankingStageDuration);
	}
	
	static void setReportStageDuration(long reportStageDuration) {
		report.setTime(reportStageDuration);
	}
}
