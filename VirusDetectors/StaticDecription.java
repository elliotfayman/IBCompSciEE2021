//Shorter string is txt1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Collections;
public class StaticDecription
{
    private String txt1;
    private String txt2;
    private ArrayList<String> words1 = new ArrayList<String>();
    private ArrayList<String> words2 = new ArrayList<String>();
    private ArrayList<String> uwords1;
    private ArrayList<String> uwords2;
    private ArrayList<Integer> amtwords1 = new ArrayList<Integer>();
    private ArrayList<Integer> amtwords2 = new ArrayList<Integer>();
    private int minfreq;
    private int maxfreq;
    public StaticDecription(String t1, String t2, int fmin, int fmax)
    {
        txt1 = t1.toLowerCase();
        txt2 = t2.toLowerCase();;
        txt1 = txt1.replaceAll("\\p{Punct}", "");
        txt2 = txt2.replaceAll("\\p{Punct}", "");
        minfreq = fmin;
        maxfreq = fmax;
    }

    private void wordArrayMaker()
    {
        String[] word1 = txt1.split("[ ]+");
        String[] word2 = txt2.split("[ ]+");
        int num = 0;
        for(String s : word1)
        {
            words1.add(s);
        }
        for(String s : word2)
        {
            words2.add(s);
        }
        uwords1 = new ArrayList<>(new LinkedHashSet<>(words1));
        uwords2 = new ArrayList<>(new LinkedHashSet<>(words2));
        
        num = 0;
        for(String s : uwords1)
        {
            amtwords1.add(Collections.frequency(words1, s));
        }
        for(String s : uwords2)
        {
            amtwords2.add(Collections.frequency(words2, s));
        }
        
        for(int x = 0; x < amtwords1.size()-1; x++)
        {
            if(amtwords1.get(x).intValue()>amtwords1.get(x+1).intValue())
            {
                int temp1 = amtwords1.get(x);
                amtwords1.set(x, amtwords1.get(x+1));
                amtwords1.set(x+1, temp1); 
                String temp2 = uwords1.get(x);
                uwords1.set(x, uwords1.get(x+1));
                uwords1.set(x+1, temp2); 
                x = -1;
            }
        }
        
        for(int x = 0; x < amtwords2.size()-1; x++)
        {
            if(amtwords2.get(x).intValue()>amtwords2.get(x+1).intValue())
            {
                int temp1 = amtwords2.get(x);
                amtwords2.set(x, amtwords2.get(x+1));
                amtwords2.set(x+1, temp1); 
                String temp2 = uwords2.get(x);
                uwords2.set(x, uwords2.get(x+1));
                uwords2.set(x+1, temp2); 
                x = -1;
            }
        }
    }
    //"a a b b b b c a"
    //"c c j k p j b c a j j"
    public void replaceBetFreq()
    {
        this.wordArrayMaker();
        int num = 0;
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        System.out.println(txt1);
        System.out.println(txt2);
        
        for(int i = 0; i<amtwords1.size(); i++)
        {
            for(int j = i; j<amtwords2.size(); j++)
            {
                if(amtwords1.get(i)>minfreq && amtwords2.get(j)>minfreq && amtwords1.get(i)<maxfreq && amtwords2.get(j)<maxfreq)
                    if(amtwords1.get(i).intValue()==amtwords2.get(j).intValue())
                    {
                        txt2 = txt2.replaceAll(" " + uwords2.get(j) + " ", " " + uwords1.get(i) + " ");
                        txt2 = txt2.replaceAll("" + uwords2.get(j) + " ", "" + uwords1.get(i) + " ");
                        txt2 = txt2.replaceAll(" " + uwords2.get(j) + "", " " + uwords1.get(i) + "");
                        j = amtwords2.size();
                    }
            }
        }
        System.out.print(txt2);
    }
}
