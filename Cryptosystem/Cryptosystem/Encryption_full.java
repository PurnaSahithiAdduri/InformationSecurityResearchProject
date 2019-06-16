import java.io.*;
class Encryption_full
{
    public static void main(String args[])throws IOException
    {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        
        //variable declaraton...
        String pt[]=new String[10];
        String Mh[]=new String[10];
        String tc[]=new String[10];
        //initializing..
        for(int i=0;i<10;i++)
        {
            Mh[i]="";
            pt[i]="";
            tc[i]="";
        }
        System.out.println("\n *****************Encryption******************\n");
        //taking inputs..
        System.out.println("Enter the plain text without spaces and special chracters");        
        String plaintext1=r.readLine();
        
        System.out.println("Please enter ceaser cipher key between 0 to 25");
        String cs=r.readLine();
          
        System.out.println("Enter the 7 bit Initialization Vector");
        String iv=r.readLine();
        
        System.out.println("Enter the 7 bit key");
        String key=r.readLine();
        
                
        //forming blocks of plain text..
        
        
        //creating objects....
        askey_equivalent ask=new askey_equivalent();
        binary_equivalent bin=new binary_equivalent();
        shiftCipher sc = new shiftCipher();
        String plaintext = sc.getShiftCipher(plaintext1,cs);
        int len=plaintext.length();
        CBC cipher1=new CBC();
        MHEncryption Mhc=new MHEncryption();
        
        for(int i=0;i<len;i++)
        {
            char m1=plaintext.charAt(i);
            int d=ask.askey(m1);
            pt[i]=bin.binary(d);    
          
            if(i==0)
            {
                tc[i]=cipher1.generate(pt[i],iv,key);
                Mh[i]=Mhc.Cipher(tc[i]);
                //System.out.println(Mh[i]);
            }             
            else
            {                
                int temp=Integer.valueOf(Mh[i-1])%128;                
                String key1=bin.binary(temp);
                tc[i]=cipher1.generate(pt[i],tc[i-1],key1);
                Mh[i]=Mhc.Cipher(tc[i]);
                //System.out.println(Mh[i]);
            }            
        }
        
        //Displaying...
        System.out.println("\n *****************\n");
        System.out.println("The cipher text is..");
        for(int i=0;i<len;i++)
        System.out.print(Mh[i]);    
    }
}
        