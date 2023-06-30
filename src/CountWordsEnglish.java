import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;

public class CountWordsEnglish
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/usr/share/dict/cracklib-small"), StandardCharsets.US_ASCII));

        TreeMap<Character, Integer> occurences = new TreeMap<Character, Integer>();

        String s = null;
        int counter = 0;
        while((s = reader.readLine())!= null){
            for(int i = 0; i < s.length(); i++){
                Character curr = (Character) Character.toLowerCase(s.charAt(i));
                if(Character.isAlphabetic(curr)) {
                    counter++;
                    if (occurences.get(curr) == null) {
                        occurences.put(curr, new Integer(1));
                    } else {
                        occurences.put(curr, occurences.get(curr).intValue() + 1);
                    }
                }
            }
        }

        for(Character ch : occurences.keySet()){
            System.out.print((occurences.get(ch).intValue()/(double)counter) + ",");
        }
    }

}
