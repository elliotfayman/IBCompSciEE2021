import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class SignatureMatch
{
    private String txt1;
    private String txt2;
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<String> punct = new ArrayList<String>();

    public SignatureMatch(String t1, String t2)
    {
        txt1 = t1.toLowerCase();
        txt2 = t2.toLowerCase();;
        txt1 = txt1.replaceAll("\\p{Punct}", "");
        txt2 = txt2.replaceAll("\\p{Punct}", "");
        File file = new File("CommonWords.txt");
        Scanner scan = null;
        try
        {
            scan = new Scanner(file);
        }
        catch(Exception ex)
        {
            System.out.println("File not found");
            System.exit(1);
        }
        
        while(scan.hasNext())
        {
            words.add(scan.nextLine());
        }
        
        for(int x = 0; x<words.size(); x++)
        {
            txt1 = txt1.replaceAll(words.get(x), " ");
            txt2 = txt2.replaceAll(words.get(x), " ");
        }
        
    }
    
    public String getFirstText()
    {
        return txt1;
    }
    
    public String getSecondText()
    {
        return txt2;
    }
}
