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
    public class Search{

    public TrieNode t;

    public Search(TrieNode t){}

    public Search(Trie.Search search){

    }

    public boolean isWord(){
        return t.isWord;
    }

    public boolean continueWith(char letter){
        if(t.map.get(letter) != null)
            return true;
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
        String temp = "";
  

        if (isLeaf(t))
        { 
        return temp +='\0';  
        } 

        else {

        while ( t.map.containsKey( (char)(result + 'a') )==false)
            result = r.nextInt(high-low) + low;
        }

        return temp += (char)(result + 'a') + getRandomLargeWord(t.map.get((char)(result + 'a')) , s);
    } 

public static void insert(String word) 
{

    insert(word, root, 0);

}

private static TrieNode insert(String word, TrieNode x, int pos) 
{

    if(x == null) x = new TrieNode();

    if(pos == word.length()) {

    x.isWord=true;

    return x;

    }

    char c = word.charAt(pos);

    x.map.put(c, insert(word, x.map.get(c), pos+1));

    return x;

}



public Trie.Search startSearch(){
    Search s = new Search(root);
    return s;
}



} 

