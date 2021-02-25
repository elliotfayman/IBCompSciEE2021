import java.util.Random;
public class NECRL
{
    private String virusText = "";
    private String text = "";
    private String virus = "";
    private int num;
    public NECRL(String path1, String path2)
    {
        TextVirusExtracter tve = new TextVirusExtracter(path1, path2);
        text = tve.getText();
        virus = tve.getVirus();
        Random ran = new Random();
        String[] sentences = text.split("\\.");
        num = ran.nextInt(sentences.length);
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
            System.out.print("Text is not big enough.");
            virusText = null;
        }
    }
    
    public String getVirusText()
    {
        System.out.println(virusText);
        return virusText;
    }
}
