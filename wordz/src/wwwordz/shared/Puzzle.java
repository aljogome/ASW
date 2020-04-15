package wwwordz.shared;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Puzzle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Puzzle.Solution> solutions = new LinkedList<Puzzle.Solution>();
	Table table = new Table();
	
	Puzzle(){
		this.solutions = null;
		this.table = null;
	}
	
	List<Puzzle.Solution> getSolution(){
		return solutions;
	}
	
	void setSolutions(List<Puzzle.Solution> solutions) {
		this.solutions = solutions;
	}
	
	void setTable(Table table) {
		this.table = table;
	}
	
	static class Solution implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		List<Table.Cell> cells = new LinkedList<Table.Cell>();
		String word;
		
		Solution(){
			this.cells = null;
			this.word = null;
		}
		
		Solution(String word, List<Table.Cell> cells){
			this.word = word;
			this.cells = cells;
		}
		
		List<Table.Cell> getCells(){
			return this.cells;
		}
		
		String getWord() {
			return this.word;
		}
		
		int getPoints() {
			return calcScore(this.word.length());
		}
		
		int calcScore(int i) {
			if(i==3)
				return 1;
			else
				return (calcScore(i-1)*2 + 1);
		}
	}
}
