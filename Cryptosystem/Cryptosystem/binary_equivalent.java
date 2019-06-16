class binary_equivalent    
{
    public String binary(int d)
    {               
        int m=d;
        String op="";
        while(m>0)
        {
            int r1=m%2;
            op=r1+""+op;
            m/=2;
        }
        int len=op.length();
        String temp="";
        if(len<=7)
        {
            int l=7-len;
            for(int i=1;i<=l;i++)
            temp+="0";
            op=temp+op;
            return op;
        }
        else
        return op;
    }
}