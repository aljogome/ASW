// ver melhor iterator, perceber como funciona

package wwwordz.shared;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Table implements Serializable, Iterable<Table.Cell> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Table.Cell[][] table = new Table.Cell[Config.MAX_TABLE_SIZE][Config.MAX_TABLE_SIZE];
	
	Table(){
		for(int i=0; i<Config.MAX_TABLE_SIZE; i++) 
			for(int j=0; j<Config.MAX_TABLE_SIZE; j++) 
				table[i][j] = new Table.Cell();
	}
	
	Table(String[] data){
	}
	
	/*List<Table.Cell> getEmptyCells(){
		List<Table.Cell> emptycells = new LinkedList<Table.Cell>();
	}*/
	
	char getLetter(int row, int column) {
		return table[row][column].letter;
	}
	
	void setLetter(int row, int column, char letter) {
		table[row][column].setLetter(letter);
	}
	
	public String toString(){
		String tblstring = "";
		iterator();
		return tblstring;
	}
	
	public Table.Cell getCell(int row, int column){
		return table[row][column];
	}
	
	public List<Table.Cell> getNeighbors(Table.Cell cell){
		List<Table.Cell> neighborcells = new LinkedList<Table.Cell>();
		int row = cell.row;
		int column = cell.column;
		
		// vizinhos do canto superior esquerdo
		if(row == 1 && column == 1) {
			neighborcells.add(getCell(row, column+1));
			neighborcells.add(getCell(row+1, column));
			neighborcells.add(getCell(row+1, column+1));
		}
		
		// vizinhos da primeira linha excepto cantos
		else if( (row == 1) && (column != 1) && (column != Config.MAX_BOARD_SIZE) ) {
			neighborcells.add(getCell(row, column-1));
			neighborcells.add(getCell(row, column+1));
			neighborcells.add(getCell(row+1, column-1));
			neighborcells.add(getCell(row+1, column));
			neighborcells.add(getCell(row+1, column+1));
		}
		
		// vizinhos do canto superior direito
		else if( (row == 1) && (column == Config.MAX_BOARD_SIZE) ) {
			neighborcells.add(getCell(row, column-1));
			neighborcells.add(getCell(row+1, column-1));
			neighborcells.add(getCell(row+1, column));
		}
		
		// vizinhos da ultima coluna excepto cantos
		else if( (row != 1) && (row != Config.MAX_BOARD_SIZE) && (column == Config.MAX_BOARD_SIZE) ) {
			neighborcells.add(getCell(row-1, column));
			neighborcells.add(getCell(row-1, column-1));
			neighborcells.add(getCell(row, column-1));
			neighborcells.add(getCell(row+1, column-1));
			neighborcells.add(getCell(row+1, column));
		}
		
		// vizinhos do canto inferior direito
		else if( (row == Config.MAX_BOARD_SIZE) && (column == Config.MAX_BOARD_SIZE) ) {
			neighborcells.add(getCell(row-1, column));
			neighborcells.add(getCell(row-1, column-1));
			neighborcells.add(getCell(row, column-1));
		}
		
		// vizinhos da ultima linha excepto cantos
		else if( (row == Config.MAX_BOARD_SIZE) && (column != 1) && (column != Config.MAX_BOARD_SIZE) ) {
			neighborcells.add(getCell(row, column-1));
			neighborcells.add(getCell(row-1, column-1));
			neighborcells.add(getCell(row-1, column));
			neighborcells.add(getCell(row-1, column+1));
			neighborcells.add(getCell(row, column+1));
		}
		
		// vizinhos do canto inferior esquerdo
		else if( (row == Config.MAX_BOARD_SIZE) && (column == 1) ) {
			neighborcells.add(getCell(row-1, column));
			neighborcells.add(getCell(row-1, column+1));
			neighborcells.add(getCell(row, column+1));
		}
		
		// vizinhos da primeira coluna excepto cantos
		else if( (row != 1) && (row != Config.MAX_BOARD_SIZE) && (column == 1) ) {
			neighborcells.add(getCell(row-1, column));
			neighborcells.add(getCell(row-1, column+1));
			neighborcells.add(getCell(row, column+1));
			neighborcells.add(getCell(row+1, column+1));
			neighborcells.add(getCell(row+1, column));
		}
		
		// vizinhos do meio
		else {
			neighborcells.add(getCell(row-1, column-1));
			neighborcells.add(getCell(row-1, column));
			neighborcells.add(getCell(row-1, column+1));
			neighborcells.add(getCell(row, column-1));
			neighborcells.add(getCell(row, column+1));
			neighborcells.add(getCell(row+1, column-1));
			neighborcells.add(getCell(row+1, column));
			neighborcells.add(getCell(row+1, column+1));
		}
		
		return neighborcells;
	}
	
	static class Cell implements Serializable {
		
		// falta os métodos equals() e hashCode() 

		private static final long serialVersionUID = 1L;
		
		int row;
		int column;
		char letter;
		
		Cell(){
			this.row = (Integer) null;
			this.column = (Integer) null;
			this.letter = 0;
		}
		
		Cell(int row, int column){
			this.row = row;
			this.column = column;
			this.letter = 0;
		}
		
		Cell(int row, int column, char letter){
			this.row = row;
			this.column = column;
			this.letter = letter;
		}
		
		public boolean isEmpty() {
			if(this.letter == 0)
				return true;
			return false;
		}
		
		public String toString() {
			String letra = String.valueOf(this.letter);
			return letra;
		}
		
		public void setLetter(char letter) {
			this.letter = letter;
		}
		
		public char getletter() {
			return this.letter;
		}
	}
	
	class CellIterator implements Iterator<Table.Cell>{
		int column;
		int row;
		Table.Cell data = getCell(row, column);
		
		CellIterator(){
			row=1;
			column=1;
		}
		
		@Override
		public Table.Cell next() {
			if(column == Config.MAX_BOARD_SIZE) {
				row = row+1;
				column = 1;
			}
			else 
				column = column+1;
			return data;
		}

		@Override
		public boolean hasNext() {
			return data != null;
		}
	}

	@Override
	public Iterator<Cell> iterator() {
		CellIterator it = new CellIterator();
		while(it.hasNext()){
			it.next();
		}
		return it;
	}
}
