class xor
{
    public String xor2(String pt,String k)
    {
        int len=pt.length();
        int l=k.length();
        
        String op="";
        
        if(len==l)
        {
            for(int i=0;i<len;i++)
            {
                char pt1=pt.charAt(i);
                char k1=k.charAt(i);
                
                if(pt1=='0' && k1=='0')
                op=op+""+'0';
                else if(pt1=='0' && k1=='1')
                op=op+""+'1';
                else if(pt1=='1' && k1=='0')
                op=op+""+'1';
                else
                op=op+""+'0';
            }
        }
        return op;
    }
}