// métodos a fazer: getInstance(), startSearch(), getRandomLargeWord();
// feitos: getInstance(), getRandomLargeWord()

package wwwordz.puzzle;

import java.io.*;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Locale;

public class Dictionary {
		
		private static Dictionary single_instance = null;
		public InputStream dict;
		public String[] words = new String[43879];
		
		private Dictionary() {
			
			try {
				dict = Dictionary.class.getResourceAsStream("pt-PT-AO.dic");
				BufferedReader r = new BufferedReader(new InputStreamReader(dict, "UTF-8"));
				
		         // reads each line
		         String l;
		         r.readLine();
		         int i = 0;
		         while((l = r.readLine()) != null) {
		        	 words[i] = Normalizer.normalize(l.split("/|\\s")[0].toUpperCase(Locale.ENGLISH),Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		        	 System.out.println(words[i]);
		        	 i++;
		         } 
		         r.close();
			} catch(Exception e) {
				System.out.println(e);
			}
			
			int i=0;
			while(i<43879) {
				i++;
			}
		}
		
		public static Dictionary getInstance() {
			if (single_instance == null)
				single_instance = new Dictionary();
			
			return single_instance;
		}
		
		/*public Trie.Search startSearch(){
			
		}*/
		
		public String getRandomLargeWord() {
			int min = 0;
			int max = (int) Math.floor(43879);
			int i = (int) (Math.floor(Math.random() * (max - min + 1)) + min);
			return words[i];
		}
}