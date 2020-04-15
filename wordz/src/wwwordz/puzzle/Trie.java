import java.util.Random; 

public class Trie { 
      
    
    static final int ALPHABET_SIZE = 26; 
      

    static class TrieNode 
    { 
        TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
       
        
        boolean isEndOfWord; 
          
        TrieNode(){ 
            isEndOfWord = false; 
            for (int i = 0; i < ALPHABET_SIZE; i++) 
                children[i] = null; 
        } 
    }; 
       
    static TrieNode root; 
    static Random r = new Random(); 
      
 
    public static void put(java.lang.String word)
    { 
        int level; 
        int length = word.length(); 
        int index; 
       
        TrieNode s = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = word.charAt(level) - 'a'; 
            if (s.children[index] == null) 
                s.children[index] = new TrieNode(); 
       
            s = s.children[index]; 
        } 
       
         
        s.isEndOfWord = true; 
    } 

    static boolean isWord(TrieNode t) 
    { 
    return t.isEndOfWord;
    }

    static boolean isLeaf(TrieNode t){

     for (int i=0; i < ALPHABET_SIZE; i++) 
        { 
            if (t.children[i]!=null)
                return false; 
       
            
        } 

        return true;
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

        while ( t.children[result] == null)
            result = r.nextInt(high-low) + low;
        }

        return temp += (char)(result + 'a') + getRandomLargeWord(t.children[result], s);
    } 


    static boolean search(String word) 
    { 
        int level; 
        int length = word.length(); 
        int index; 
        TrieNode s = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = word.charAt(level) - 'a'; 
       
            if (s.children[index] == null) 
                return false; 
       
            s = s.children[index]; 
        } 
       
        return (s != null && s.isEndOfWord); 
    } 

    public static void iterator(){
        int i = 0;
        char[] s= new char[1000];

        iterator(root, s, i);
    }


    private static void iterator(TrieNode t, char[] s, int level) 
{ 
    

    if (isWord(t))  
    { 
        s[level] = '\0'; 
        System.out.println(s);
    } 
  
    int i; 
    for (i = 0; i < ALPHABET_SIZE; i++)  
    { 
       
        if (t.children[i]!=null)  
        { 
            s[level] = (char)(i + 'a'); 
            iterator(t.children[i], s, level + 1); 
        } 
    } 
} 
       
    
    public static void main(String args[]) 
    { 
         
       
       
       
        root = new TrieNode(); 
        
       
        //aqui o keys vai ser o array com as palavras
         
        int i; 
        Object keys;
		for (i = 0; i < keys.length ; i++) 
            put(keys[i]); 
       
    
        
    } 




