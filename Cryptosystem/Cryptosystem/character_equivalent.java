class character_equivalent
{
    public char find(String a)
    {
        int d[]={64,32,16,8,4,2,1};
        int pt[]=new int[7];
        
        for(int i=0;i<7;i++)
        {
            String temp=""+a.charAt(i);
            pt[i]=Integer.parseInt(temp);
        }
        int s1=0;
        for(int i=0;i<7;i++)
        {
            s1+=pt[i]*d[i];                          
        }        
        char temp=(char)(s1);
        return temp;
     }
}