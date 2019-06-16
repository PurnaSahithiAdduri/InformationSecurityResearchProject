import java.io.*;
class MHEncryption
{
    static int s[]={3,5,15,25,54,110,225};    
    static int p[]=new int[7];
    static int a=439,r=10;
    static int k=-1;  
    static int M=0;
    
    public static void initialize()
    {
        for(int i=0;i<7;i++)
        {            
            p[i]=0;
        }        
    }  
    
    public static void generatep()
    {
        for(int i=0;i<7;i++)
        {
            p[i]=(s[i]*r)% a;
            //System.out.println("-->"+p[i]);
        }
    }
    public int generateM(String b)
    {   
        Integer M=0;
        for(int j=0;j<7;j++)
        {
            //int a=Interger.parseInt(b);
            
            String b1=""+b.charAt(j);
            
            int c=Integer.parseInt(b1);
            M+=p[j]*c;
            
            
        }
        
        
        return M;
    }
    public String Cipher(String op1)
    {
        initialize();        
        generatep();
        String p;
        int msg=generateM(op1);  
        //System.out.println(msg);
        if(msg<100){
                 p = String.format("%03d",msg);
        }else{
             p= String.valueOf(msg);
        }
        return p;
    }
}
        
    