package wwwordz.puzzle;

import java.util.Random;
import wwwordz.shared.*;
import wwwordz.shared.Table.Cell;
import java.util.LinkedList;
import java.util.List;

class Generator{

	
	public Generator(){}

	static Random r = new Random();

	public Cell getRandom(List<Table.Cell> list) 
    { 
        Random rand = new Random(); 
        return list.get(rand.nextInt(list.size())); 
    } 

    public Puzzle generate(){
		List<Cell> visited = new LinkedList<Cell>();
    	Puzzle e = new Puzzle();
    	Table t = new Table();
    	Cell c = new Cell();
    	int max;
    	
    	while(t.getEmptyCells().size() > 0){
    		String s = Trie.getRandomLargeWord();
    		c=getRandom(t.getEmptyCells());
    		int i=0;
        	c.setLetter(s.charAt(i));
        	visited.add(c);
        	i++;
        	while(i<=s.length()) {
        		c=getRandom(Table.getNeighbors(c));
        		if(visited.contains(c)) {
        			max=0;
        			while(visited.contains(c)) {
        				c=getRandom(Table.getNeighbors(c));
        				max++;
        				if(max==8) {
        					break;
        				}
        			}
        		}
        		if(c.isEmpty()) {
        			c.setLetter(s.charAt(i));
        			i++;
        			visited.add(c);
        		}
        		else if(c.isEmpty() == false) {
        			if(c.getLetter() == s.charAt(i)) {
        				i++;
        				visited.add(c);
        			}
        		}
        	}
    	e.setTable(t);
    	}
    	return e;
    }

	public Puzzle random(){
    	Table t = new Table();
    	Puzzle e = new Puzzle();
    	List<Table.Cell> list=new LinkedList<Table.Cell>();
    	list = t.getEmptyCells();
    	int low = 0;
        int high = 26;
        int result = r.nextInt(high-low) + low;

    	for(int i = 0; i<list.size(); i++){
    		result = r.nextInt(high-low) + low;
    		list.get(i).setLetter((char)(result));
    	}


    	e.setTable(t);
    	return e;
    }
	
	static String search(Cell cell, String word, Trie t) {
		List<Cell> neighbors = Table.getNeighbors(cell);
		for(Cell cell2 : neighbors) {
			if(Trie.Search.continueWith(cell2.getLetter()))
		}
		return null;
	}
	
	public List<Puzzle.Solution> getSolutions(Table table){
		List<Puzzle.Solution> solution = new LinkedList<Puzzle.Solution>();
		Trie t = new Trie();
		Dictionary d = Dictionary.getInstance();
		for(int i=0; i<43879; i++)
			t.put(d.words[i]);
		for(Cell cell : table) {
			Trie.startSearch();
			search(cell, "", t);
		}
		return null;
	}
}