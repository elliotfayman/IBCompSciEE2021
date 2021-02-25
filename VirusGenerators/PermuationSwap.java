import java.util.Random;

public class PermuationSwap
{
    private String virus = "";
    private String encVirus = "";
    public PermuationSwap(String path1, String path2)
    {
        TextVirusExtracter tve = new TextVirusExtracter(path1, path2);
        virus = tve.getVirus();
        String[] words = virus.split(" ");
        String temp;
        int num1;
        int num2;
        Random ran = new Random();
        for(int x = 0; x<10000; x++)
        {
            num1 = ran.nextInt(words.length);
            num2 = ran.nextInt(words.length);
            temp = words[num1];
            words[num1] = words[num2];
            words[num2] = temp;
        }
        for(String s : words)
        {
            encVirus += s + " ";
        }
        encVirus = encVirus.replaceAll("  ", " ");
    }
}
