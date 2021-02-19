public class GeometricDetection
{
    private String txt1;
    private String txt2;

    public GeometricDetection(String t1, String t2)
    {
        txt1 = t1;
        txt2 = t2;
    }

    public int textOneSize()
    {
        return txt1.length();
    }
    
    public int textTwoSize()
    {
        return txt2.length();
    }
}
