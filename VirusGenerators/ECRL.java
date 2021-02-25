import java.util.Random;
public class ECRL
{
    private String virusText = "";
    private String text = "";
    private String virus = "";
    private int num;
    public ECRL(String path1, String path2, int n)
    {
        TextVirusExtracter tve = new TextVirusExtracter(path1, path2);
        text = tve.getText();
        virus = tve.getVirus();
        num = n;
        String[] sentences = text.split("\\.");
        if(num<sentences.length)
        {
            for(int x = 0; x<sentences.length; x++)
            {
                if(x == num)
                {
                    virusText += virus;
                }
                virusText += sentences[x] + ".";
            }
        }
        else
        {
            System.out.print("Text is not big enough." + sentences.length);
            virusText = null;
        }
    }
    
    public String getVirusText()
    {
        System.out.println(virusText);
        return virusText;
    }
}
