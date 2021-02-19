import java.util.ArrayList;
public class SubSequenceCompare
{
    private String txt1;
    private String txt2;
    private ArrayList<Integer> m = new ArrayList<Integer>();
    private ArrayList<Integer> n = new ArrayList<Integer>();
    private ArrayList<String> z = new ArrayList<String>();
    private boolean first = true;
    private int pLength1 = 0;
    private int pLength2 = 0;
    public SubSequenceCompare(String a, String b)
    {
        txt1 = a;
        txt2 = b;
    }
   
    public void arrayMaker(int amt, int index1, int index2)
    {
        String sentence1 = "";
        String sentence2 = "";
        int Lindex1 = index1;
        int Lindex2 = index2;
        int temp1 = 0;
        int temp2 = 0;
        if(first)
        {
            index1 = 0;
            index2 = 0;
            first = false;
        }
        else
        {
            Lindex1++;
            Lindex2++;
        }
        while(temp1 < amt || temp2 < amt)
        {

            if(index1<txt1.length() && txt1.substring(index1, index1+1).compareTo(".")==0)
            {
                sentence1 = txt1.substring(Lindex1 ,index1);
                temp1++;
                index1++;
            }
            else if (index1>txt1.length())
            {
                temp1++;
            }
            if(temp1 < amt)
            {
                index1++;
            }

            if(index2<txt2.length() && txt2.substring(index2, index2+1).compareTo(".")==0 )
            {
                sentence2 = txt2.substring(Lindex2 ,index2);
                temp2++;
                index2++;
            }
            else if(index2>txt2.length())
            {
                temp2++;
            }
            if(temp2 < amt)
            {
                index2++;
            }
        }
        System.out.println(sentence1);
        this.comparer(sentence1, sentence2);
        pLength1+= sentence1.length()+2;
        pLength2+= sentence2.length()+2;
        System.out.println(pLength2);
        //System.out.println(pLength1);
        if(index1>txt1.length()-1 || index2>txt2.length()-1)
        {
            return ; 
        }
        else
        {
            this.arrayMaker(amt, index1, index2);
        }
    }
    
    private void comparer(String sentence1, String sentence2)
    {
        String word1 = "";
        String word2 = "";
        int start1 = 0;
        int start2 = 0;
        boolean wordfound = false;
        for(int x = 0; x<sentence1.length()-1; x++)
        {
            if(sentence1.substring(x, x+1).compareTo(" ")==0 || ((sentence1.substring(x, x+1).compareTo(".")==0) && (sentence1.substring(x+1, x+2).compareTo(" ")==0)))
            {
                word1 = sentence1.substring(start1, x);
                wordfound = true;
                x++;
                //System.out.println(start1);
            }
            
            for(int y = 0; y<sentence2.length()-1 && wordfound; y++)
            {
                if(sentence2.substring(y, y+1).compareTo(" ")==0 || ((sentence2.substring(y, y+1).compareTo(".")==0) && (sentence2.substring(y+1, y+2).compareTo(" ")==0)))
                {
                    word2 = sentence2.substring(start2, y);
                   // System.out.println("2" + pLength2);
                    //System.out.println("1" + pLength1);
                    y++;
                    if(word1.equalsIgnoreCase(word2))
                    {
                        m.add(start1+pLength1);
                        n.add(start2+pLength2);
                        z.add(word1);
                        start2 = y;
                    }
                    else
                    {
                        start2 = y;
                    }
                }
                
                word2 = "";
                if(sentence2.substring(y, y+1).compareTo(" ")==0)
                {
                    y++;
                    start2++;
                }
            }   
            if(wordfound)
            {
                start1 = x;
            }
            wordfound = false;
            start2 = 0;
            if(sentence1.substring(x, x+1).compareTo(" ")==0)
            {
                x++;
                start1++;
            }
        }
    }
    
    public void returnArray()
    {
        String str = "";
        int num = 0;
        while(num<m.size())
        {
            str = num+1 + ": (" + m.get(num) + ", " + n.get(num) + ") " + z.get(num);
            System.out.println(str);
            num++;
        }
    }
    
    public void returnArrayData()
    {
        
        String str = "";
        int num = 0;
        
        while(num<m.size())
        {
            str = m.get(num) + "";
            System.out.println(str);
            num++;
        }
        
        System.out.println("***********************************");
        num = 0;
        while(num<n.size())
        {
            str = n.get(num) + "";
            System.out.println(str);
            num++;
        }
        
    }
}
