import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Collections;
public class SmartScanning
{
    private String txt1;
    private String txt2;
    private ArrayList<String> words1 = new ArrayList<String>();
    private ArrayList<String> words2 = new ArrayList<String>();
    private int minfreq;
    private ArrayList<String> uwords1;
    private ArrayList<String> uwords2;
    private ArrayList<Integer> amtwords1 = new ArrayList<Integer>();
    private ArrayList<Integer> amtwords2 = new ArrayList<Integer>();

    public SmartScanning(String t1, String t2, int f)
    {
        txt1 = t1.toLowerCase();
        txt2 = t2.toLowerCase();;
        txt1 = txt1.replaceAll("\\p{Punct}", "");
        txt2 = txt2.replaceAll("\\p{Punct}", "");
        minfreq = f;
    }
    
    private void wordArrayMaker()
    {
        String[] word1 = txt1.split("[ ]+");
        String[] word2 = txt2.split("[ ]+");
        int num = 0;
        for(String s : word1)
        {
            words1.add(s);
            words2.add(word2[num]);
            num++;
        }
        uwords1 = new ArrayList<>(new LinkedHashSet<>(words1));
        uwords2 = new ArrayList<>(new LinkedHashSet<>(words2));
        
        num = 0;
        for(String s : uwords1)
        {
            amtwords1.add(Collections.frequency(words1, s));
            amtwords2.add(Collections.frequency(words2, uwords2.get(num)));
            num++;
        }
    }
    
    public void removeAbvFreq()
    {
        this.wordArrayMaker();
        int num = 0;
        for(Integer i : amtwords1)
        {
            if(i>minfreq)
            {
                txt1 = txt1.replaceAll(" " + words1.get(num) + " ", " ");
                txt1 = txt1.replaceAll(" " + words1.get(num) + ".", "");
                txt1 = txt1.replaceAll(" " + words1.get(num) + ",", "");
                txt1 = txt1.replaceAll(" " + words1.get(num) + "", "");
                txt1 = txt1.replaceAll("" + words1.get(num) + " ", "");
                txt1 = txt1.replaceAll("" + words1.get(num) + ",", "");
            }
            if(amtwords2.get(num)>minfreq)
            {
                txt2 = txt2.replaceAll(" " + words2.get(num) + " ", " ");
                txt2 = txt2.replaceAll(" " + words2.get(num) + ".", "");
                txt2 = txt2.replaceAll(" " + words2.get(num) + ",", "");
                txt2 = txt2.replaceAll(" " + words2.get(num) + "", "");
                txt2 = txt2.replaceAll("" + words2.get(num) + " ", "");
                txt2 = txt2.replaceAll("" + words2.get(num) + ",", "");
            }
            num++;
        }
        System.out.println(txt2);
    }
}
