import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
public class EncryptVirusConstant
{
    private String virus = "";
    private String encVirus = "";
    public EncryptVirusConstant(String path1, String path2)
    {
      TextVirusExtracter tve = new TextVirusExtracter(path1, path2);
      virus = tve.getVirus();
      virus += " ";
      String[] alph = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
      String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
      String[] words = virus.split(" ");
      List<String> wordsList = Arrays.asList(words);
      ArrayList<String> uniqueWordsList = new ArrayList<String>();
      int index1 = 0;
      int index2 = 0;
      
      for(int x = 0; x<wordsList.size(); x++)
      {
          if(!(uniqueWordsList.contains(wordsList.get(x))))
          {
            uniqueWordsList.add(wordsList.get(x));
            System.out.println(wordsList.get(x));
          }
      }
      
      for(int x = 0; x<uniqueWordsList.size(); x++)
      {
          if(alph.length<index1)
          {
              index1 = 0;
          }
          
          if(nums.length<index2)
          {
              index2 = 0;
          }
          
          String temp = alph[index1] + nums[index2] + x;
          virus = virus.replaceAll(" " + uniqueWordsList.get(x) + " ", " "+ temp + " ");
      }
    }
}
