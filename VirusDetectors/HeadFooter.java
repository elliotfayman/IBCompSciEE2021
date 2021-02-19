import java.util.ArrayList;
public class HeadFooter
{
    private int header;
    private int footer;
    private String txt1;
    private String txt2;
    public HeadFooter(int h, int f, String t1, String t2)
    {
       header = h;
       footer = f;
       txt1 = t1; 
       txt2 = t2;
    }

    public String headerText1()
    {
        String Str = "";
        ArrayList<String> Sentences = new ArrayList<String>();
        Sentences = this.sentenceParser(txt1);
        for(int x = 0; x<header; x++)
        {
            Str += Sentences.get(x) + ".";
        }
        return Str;
    }
    
    public String headerText2()
    {
        String Str = "";
        ArrayList<String> Sentences = new ArrayList<String>();
        Sentences = this.sentenceParser(txt2);
        for(int x = 0; x<header; x++)
        {
            Str += Sentences.get(x) + ".";
        }
        return Str;
    }
    
    public String footerText1()
    {
        String Str = "";
        ArrayList<String> Sentences = new ArrayList<String>();
        Sentences = this.sentenceParser(txt1);
        for(int x = Sentences.size() - footer; x<Sentences.size(); x++)
        {
            Str += Sentences.get(x) + ".";
        }
        return Str;
    }
    
    public String footerText2()
    {
        String Str = "";
        ArrayList<String> Sentences = new ArrayList<String>();
        Sentences = this.sentenceParser(txt2);
        for(int x = Sentences.size() - footer; x<Sentences.size(); x++)
        {
            Str += Sentences.get(x) + ".";
        }
        return Str;
    }
    
    private ArrayList<String> sentenceParser(String str)
    {
        ArrayList<String> sentences = new ArrayList<String>();
        String del = "[.]";
        String[] sentence = str.split(del);
        for (String s : sentence)
        {
            sentences.add(s);
        }
        return sentences;
    }
}
