import java.io.*;
class Decryption_full
{
    public static void main(String args[])throws IOException
    {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        
        // Declaring the variables..
        String pt[]=new String[10];
        int mh[]=new int[10];
        String temppt[]=new String[10];
        //Initializing the variables..
        for(int i=0;i<10;i++)
        {
            pt[i]="";
            mh[i]=0;
        }
        
        //Entering the cipher code..
        int k,i1=0,i2=3;
        
        System.out.println("\n\n *****************Decryption******************\n");
        System.out.println("Enter the cipher code");
        String cc=r.readLine();
        
        System.out.println("Please enter ceaser cipher key between 0 to 26");
        String cs=r.readLine();
        
        System.out.println("Enter the 7 bit Initialization Vector");
        String iv=r.readLine();
        
        System.out.println("Enter the 7 bit key");
        String key=r.readLine();
        
        //creating objects..
        MHDecryption md=new MHDecryption();
        CBCDecryption cd=new CBCDecryption();
        binary_equivalent bin=new binary_equivalent();
        character_equivalent ce=new character_equivalent();
        
        k=cc.length()/3;
        
        for(int i=0;i<k;i++)
        {
            String ss=cc.substring(i1,i2);
            //System.out.println("----"+ss);
            mh[i]=Integer.parseInt(ss);
            i1+=3;i2+=3;
        }
        
        for(int i=0;i<k;i++)
        {
            if(i==0)
            {
                String tpt=md.MHTemppt(mh[i]);
                pt[i]=cd.Decrypt(tpt,key,iv);
                temppt[i]=tpt;
            }
            else
            {
                int temp=mh[i-1]%128;
                String key1=bin.binary(temp);
                //System.out.println("*******"+key1);
                String tpt=md.MHTemppt(mh[i]);
                temppt[i]=tpt;
                pt[i]=cd.Decrypt(tpt,key1,temppt[i-1]);
                //System.out.println("*******-->"+pt[i]);
            }
        }
        String plaintext="";
        for(int i=0;i<k;i++)
        plaintext+=""+ce.find(pt[i]);
        deCipher dc = new deCipher();
        String result = dc.decipherText(plaintext,cs);
        System.out.println("\n *****************\n");
        System.out.println("The plain text is...");
        System.out.println(result);
    }
}