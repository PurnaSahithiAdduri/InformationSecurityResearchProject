class CBCDecryption
{
    public String Decrypt(String tpt,String IV,String key)
    {
        xor xx=new xor();
        String op=xx.xor2(tpt,key);
        op=xx.xor2(op,IV);
        return op;
    }
}