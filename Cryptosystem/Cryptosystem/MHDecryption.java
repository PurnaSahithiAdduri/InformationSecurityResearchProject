class MHDecryption
{
    static int s[]={3,5,15,25,54,110,225,0};
    static int a=439,r=10,f;   
    static int pos;
    static String b="";
    static int pt[]=new int[7];
    static int d[]={64,32,16,8,4,2,1};
    
    public String MHTemppt(int mh)
    {         
            modinvr md=new modinvr();
            f=md.modInverse(r,a);
            //System.out.println(f);
            extreme();
            check(mh);
            decrypt();
            
            String tpt="";
            for(int i=0;i<7;i++)
            tpt+=""+pt[i];
            //System.out.println("MH=================="+tpt);
            return tpt;
        
    }
    public static void extreme()
    {
        int s1=0;
        for(int i=0;i<7;i++)
        {
            s1+=s[i];
        }
        s[7]=s1;
        //Initializing the array..
        for(int j=0;j<7;j++)
        {
            pt[j]=0;
        }
    }
            
    public static void check(int m1)
    {                
        b="";
        int r=( m1 * f )% a;
        //System.out.println("MH=================="+r);
        pos=0;
        
        while(r>=0)
        {
            for(int i=0;i<7;i++)
            {
                if(r>=s[i] && r<s[i+1])
                {
                    pos=i;                    
                    break;
                }
            }
            r=r-s[pos];
            b=pos+""+b;           
        }
    }
    public static void decrypt()
    {
        for(int i=0;i<b.length();i++)
        {
            int b1=Integer.parseInt(""+b.charAt(i));            
            pt[b1]=1;            
        }           
     }     
 }
        