package wwwordz.shared;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Table implements Serializable, Iterable<Table.Cell> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static Table.Cell[][] table = new Table.Cell[Configs.MAX_TABLE_SIZE][Configs.MAX_TABLE_SIZE];
	int maxsize = Configs.MAX_TABLE_SIZE;
	int boardsize = Configs.MAX_BOARD_SIZE;
	
	public Table(){
		for(int i=0; i<Configs.MAX_TABLE_SIZE; i++) 
			for(int j=0; j<Configs.MAX_TABLE_SIZE; j++)
				table[i][j] = new Cell(i, j);
	}
	
	// ?
	public Table(String[] data){
		for(int i=1; i<=boardsize; i++)
			for(int j=1; j<=boardsize; j++) {
				table[i][j] = new Cell(i, j, data[i-1].charAt(j-1));
			}
	}
	
	// ?
	public int hashCode() {
		return Objects.hash(table, maxsize, boardsize);
	}
	
	@Override
	public boolean equals(Object obj) {
		Table other = (Table) obj;
		for(int i=1; i<=boardsize; i++)
			for(int j=1; j<=boardsize; j++)
				if(!table[i][j].equals(other.table[i][j])) 
					return false;
		return true;
	}
	
	char getLetter(int row, int column) {
		return table[row][column].letter;
	}
	
	void setLetter(int row, int column, char letter) {
		table[row][column].setLetter(letter);
	}
	
	public String toString(){
		String tablestr = "";
		for(int i=1; i<=boardsize; i++)
			for(int j=1; j<=boardsize; j++) 
				tablestr = tablestr + table[i][j].getLetter();
		return tablestr;
	}
	
	public List<Table.Cell> getEmptyCells(){
		List<Table.Cell> emptycells = new LinkedList<Table.Cell>();
		for(int i=1; i<boardsize; i++)
			for(int j=1; j<boardsize; j++) 
				if(table[i][j].isEmpty())
					emptycells.add(table[i][j]);
		return emptycells;
	}
	
	public static Table.Cell getCell(int row, int column){
		return table[row][column];
	}
	
	public static List<Table.Cell> getNeighbors(Table.Cell cell){
		List<Table.Cell> neighborcells = new LinkedList<Table.Cell>();
		int row = cell.row;
		int column = cell.column;
	
		if(row == 0 || column == 0 || row > Configs.MAX_BOARD_SIZE || column > Configs.MAX_BOARD_SIZE)
			return neighborcells;
		
		// vizinhos do canto superior esquerdo
		if(row == 1 && column == 1) {
			neighborcells.add(getCell(row, column+1));
			neighborcells.add(getCell(row+1, column));
			neighborcells.add(getCell(row+1, column+1));
		}
		
		// vizinhos da primeira linha excepto cantos
		else if( (row == 1) && (column > 1) && (column < Configs.MAX_BOARD_SIZE) ) {
			neighborcells.add(getCell(row, column-1));
			neighborcells.add(getCell(row, column+1));
			neighborcells.add(getCell(row+1, column-1));
			neighborcells.add(getCell(row+1, column));
			neighborcells.add(getCell(row+1, column+1));
		}
		
		// vizinhos do canto superior direito
		else if( (row == 1) && (column == Configs.MAX_BOARD_SIZE) ) {
			neighborcells.add(getCell(row, column-1));
			neighborcells.add(getCell(row+1, column-1));
			neighborcells.add(getCell(row+1, column));
		}
		
		// vizinhos da ultima coluna excepto cantos
		else if( (row > 1) && (row < Configs.MAX_BOARD_SIZE) && (column == Configs.MAX_BOARD_SIZE) ) {
			neighborcells.add(getCell(row-1, column));
			neighborcells.add(getCell(row-1, column-1));
			neighborcells.add(getCell(row, column-1));
			neighborcells.add(getCell(row+1, column-1));
			neighborcells.add(getCell(row+1, column));
		}
		
		// vizinhos do canto inferior direito
		else if( (row == Configs.MAX_BOARD_SIZE) && (column == Configs.MAX_BOARD_SIZE) ) {
			neighborcells.add(getCell(row-1, column));
			neighborcells.add(getCell(row-1, column-1));
			neighborcells.add(getCell(row, column-1));
		}
		
		// vizinhos da ultima linha excepto cantos
		else if( (row == Configs.MAX_BOARD_SIZE) && (column > 1) && (column < Configs.MAX_BOARD_SIZE) ) {
			neighborcells.add(getCell(row, column-1));
			neighborcells.add(getCell(row-1, column-1));
			neighborcells.add(getCell(row-1, column));
			neighborcells.add(getCell(row-1, column+1));
			neighborcells.add(getCell(row, column+1));
		}
		
		// vizinhos do canto inferior esquerdo
		else if( (row == Configs.MAX_BOARD_SIZE) && (column == 1) ) {
			neighborcells.add(getCell(row-1, column));
			neighborcells.add(getCell(row-1, column+1));
			neighborcells.add(getCell(row, column+1));
		}
		
		// vizinhos da primeira coluna excepto cantos
		else if( (row > 1) && (row < Configs.MAX_BOARD_SIZE) && (column == 1) ) {
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
	
	public static class Cell implements Serializable {
		
		// falta os métodos equals() e hashCode() 

		private static final long serialVersionUID = 1L;
		
		int row;
		int column;
		char letter;
		
		public Cell(){
			this.row = 0;
			this.column = 0;
			this.letter = 0;
		}
		
		public Cell(int row, int column){
			this.row = row;
			this.column = column;
			this.letter = 0;
		}
		
		public Cell(int row, int column, char letter){
			this.row = row;
			this.column = column;
			this.letter = letter;
		}
		
		@Override
		public boolean equals(Object cell) {
			if (this == cell)
				return true;
			if(cell == null)
				return true;
			if(getClass() != cell.getClass())
				return false;
			Cell other = (Cell) cell;
			if (row != other.row || column != other.column || letter != other.letter)
		        return false;
			return true;
		}
		
		public int hashCode() {
			return Objects.hash(row, column, letter);
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
		
		public char getLetter() {
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
		public boolean hasNext() {
			if(row > Configs.MAX_BOARD_SIZE) 
				return false;
			return true;
		}
		
		@Override
		public Table.Cell next() {
			if(column == Configs.MAX_BOARD_SIZE) {
				row++;
				column = 1;
			}
			else 
				column++;
			return data;
		}

	}

	@Override
	public Iterator<Cell> iterator() {
		return new CellIterator();
	}
}
