//No spaces at end or beginning. No double or + spaces.
import java.util.ArrayList;
public class DirectCompare
{
    private String txt1;
    private String txt2;

    public DirectCompare(String s1, String s2)
    {
        txt1 = s1;
        txt2 = s2;
    }

    
    public void compare()
    {
        ArrayList<String> words1 = new ArrayList<String>();
        ArrayList<String> words2 = new ArrayList<String>();
        int start = 0;
        boolean isEqual = true;
        double total = 0.0;
        System.out.println(txt1.length());
        for(int x = 0; x<txt1.length()-1; x++)
        {
            System.out.println(txt1.length()-2);
            System.out.println(x==txt1.length()-2);
            System.out.println(x);
            if(txt1.substring(x, x+1).compareTo(" ")==0)
            {
                words1.add(txt1.substring(start, x));
                System.out.println(txt1.substring(start, x));
                start = x+1;
            }
            else if (x==txt1.length()-2 && txt1.substring(x, x+1).compareTo(" ")!=0)
            {
                words1.add(txt1.substring(start, x+2));
                System.out.println(txt1.substring(start, x));
          
                start = x+1;
            }
        }
        start = 0;
        
        for(int x = 0; x<txt2.length()-1; x++)
        {
            if(txt2.substring(x, x+1).compareTo(" ")==0)
            {
                words2.add(txt2.substring(start, x));
                start = x+1;
            }
            else if (x==txt2.length()-2 && txt2.substring(x, x+1).compareTo(" ")!=0)
            {
                words2.add(txt2.substring(start, x+2));
          
                start = x+1;
            }
        }
        
        int num = 0;
        if(words1.size()>words2.size())
        {
            for(String str : words2)
            {
                System.out.println(str);
                if(str.compareTo(words1.get(num))==0)
                {
                    total++;
                }
                else
                {
                    isEqual = false;
                }
                num++;
            }
        }
        else
        {
            for(String str : words1)
            {
                System.out.println(words2.get(num));
                System.out.println(str);
                if(str.compareTo(words2.get(num))==0)
                {
                    total++;
                }
                else
                {
                    isEqual = false;
                }
                num++;
            }
        }
        
        
        System.out.println("Percentage: " + total/num);
        System.out.println("Equal?: " + isEqual);
    }
}
