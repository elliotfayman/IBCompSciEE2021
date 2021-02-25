public class ECHF
{
    private String virusTextH = "";
    private String virusTextF = "";
    private String text = "";
    private String virus = "";

    public ECHF(String path1, String path2)
    {
        TextVirusExtracter tve = new TextVirusExtracter(path1, path2);
        text = tve.getText();
        virus = tve.getVirus();
        virusTextH += virus + text;
        virusTextF += text + virus;
    }
    
    public String getH()
    {
        System.out.println(virusTextH);
        return virusTextH;
    }
    
    public String getF()
    {
        System.out.println(virusTextF);
        return virusTextF;
    }
}
