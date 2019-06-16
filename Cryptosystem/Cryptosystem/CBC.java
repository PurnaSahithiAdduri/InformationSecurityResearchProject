class CBC
{
    public String generate(String pt,String IV,String key)
    {
        xor x=new xor();        
        String op1=x.xor2(IV,pt);
        op1=x.xor2(op1,key);        
        return op1;
    }
}