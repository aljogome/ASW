package wwwordz.puzzle;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Random; 


class TrieNode {

boolean isWord;

HashMap<Character, TrieNode> map = new HashMap<Character, TrieNode>();



public TrieNode() {}

}


public class Trie 
{
    public static class Search{

    TrieNode t;

    public Search(TrieNode t){
    this.t=t;
    }


    public  boolean isWord(){

        return t.isWord;
    }

    public  boolean continueWith(char letter){
        if(t.map.get(letter) != null){
            t=t.map.get(letter);
            return true;
        }
        return false;
    }

}

    static private TrieNode root;
    static Random r = new Random(); 

    public Trie() {

    root = new TrieNode();

}

public static boolean isLeaf(TrieNode t)
{
    if (t.map.isEmpty())
        return true;
    return false;

}

public static String getRandomLargeWord()
    {               
    String s = "";
                     
    return getRandomLargeWord(root, s);
    }


private static String getRandomLargeWord(TrieNode t, String s) 
    {
        int low = 0;
        int high = 26;
        int result = r.nextInt(high-low) + low;

        if (isLeaf(t) && s.length()>=3) {
        	return s;
        }

        else if(isLeaf(t)){
        	System.out.println("ola");
        	s = "";
        	t = root;
        }
        
        while ( t.map.containsKey( (char)(result + 'a') )==false)
            result = r.nextInt(high-low) + low;
        
        s += (char)(result + 'a');
        return getRandomLargeWord(t.map.get((char)(result + 'a')) , s);
    } 

public void put(String word) 
{

    put(word, root, 0);

}

private TrieNode put(String word, TrieNode x, int pos) 
{

    if(x == null) x = new TrieNode();

    if(pos == word.length()) {

    x.isWord=true;

    return x;

    }

    char c = word.charAt(pos);

    x.map.put(c, put(word, x.map.get(c), pos+1));

    return x;

}



public static Trie.Search startSearch(){
    Search s = new Search(root);
    return s;
}
} 