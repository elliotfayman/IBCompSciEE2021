import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

public class TextVirusExtracter
{
    private String text = "";
    private String virus = ""; 
    
    public TextVirusExtracter(String path1, String path2)
    {
        File file1 = new File(path1);
        File file2 = new File(path2);
        Scanner scan1 = null;
        Scanner scan2 = null;
        try
        {
            scan1 = new Scanner(file1);
        }
        catch(Exception ex)
        {
            System.out.println("File with pathname " + path1 + " not found.");
            System.exit(1);
        }
        
        try
        {
            scan2 = new Scanner(file2);
        }
        catch(Exception ex)
        {
            System.out.println("File with pathname " + path2 + " not found.");
            System.exit(1);
        }
        
        while(scan1.hasNext())
        {
            text += scan1.nextLine();
        }
        
        while(scan2.hasNext())
        {
            virus += scan2.nextLine();
        }
    }
    
    public String getText()
    {
        System.out.println(text);
        return text;
    }
    
    public String getVirus()
    {
        System.out.println(virus);
        return virus;
    }
}
