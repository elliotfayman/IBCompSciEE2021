import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class GCI
{
    private String virus = "";
    private String encVirus = "";
    public GCI(String path1, String path2)
    {
        TextVirusExtracter tve = new TextVirusExtracter(path1, path2);
        virus = tve.getVirus();
        String[] words = virus.split(" ");
        String[] garbageTxt = {"Garbage", "Trash", "Litter", "rubbish", "refuse", "waste"};
        ArrayList<String> wordList1 = new ArrayList<String>();
        ArrayList<String> wordList2 = new ArrayList<String>();
        for(String s : words)
        {
            wordList1.add(s);
        }
        Random ran = new Random();
        int ranInt = ran.nextInt(words.length);
        int amt;
        int ranIndex = 0;
        int totalAdded = 0;
        String temp = "";
        String gtxt = "";
        for(int x = 0; x<ranInt; x++)
        {
            amt = ran.nextInt(garbageTxt.length+1);
            ranIndex = ran.nextInt(wordList1.size());
            for(int y = 0; y<amt; y++)
            {
                gtxt+= garbageTxt[ran.nextInt(garbageTxt.length)];
            }
            for(int z = 0; z<wordList1.size(); z++)
            {
                wordList2.add(wordList1.get(z));
                if(z==ranIndex)
                {
                    wordList2.add(gtxt);
                }
            }
            wordList1 = (ArrayList<String>) wordList2.clone();
            wordList2.clear();
            gtxt = "";
        }
        for(String s: wordList1)
        {
            encVirus += s + " ";
        }
        encVirus = encVirus.replaceAll("  ", " ");
        System.out.println(encVirus);
    }
    
    
}
