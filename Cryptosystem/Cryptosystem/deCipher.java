
/**
 * Write a description of class deCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.Map;

public class deCipher
{
     public static Object getKeyFromValue(Map hm, Object value) {
    for (Object o : hm.keySet()) {
      if (hm.get(o).equals(value)) {
        return o;
      }
    }
    return null;
  }
  
   public static boolean contains(String[] arr, String item) {
      for (String n : arr) {
         if (item.equals(n)) {
            return true;
         }
      }
      return false;
   }
  
    public String decipherText(String y,String cs)
    {
       
         String cipherString="";
         String mss = "";
        Map<String, Integer> alphabetMapping = new HashMap<>();
        Map<String, Integer> alphabetMapping2 = new HashMap<>();
        Integer key = Integer.valueOf(cs);
        
        
        String[] alphabetArr = new String[]{"a","b","c","d","e","f","g","h",
            "i","j","k","l","m","n","o","p","q","s","t","u","v","w","x","y","z"};
             String[] alphabetArr1 = new String[]{"A","B","C","D","C","F","G","H","I","J",
            "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
            int[] myArray = { 0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
 
        // Adding key-value pairs to a HashMap
     for(int i=0;i<25;i++){
        alphabetMapping.put(alphabetArr[i], i);
         alphabetMapping2.put(alphabetArr1[i], i);
    }
        
        for(int k=0;k<y.length();k++){
      
             char m1=y.charAt(k);
            String s=Character.toString(m1);
            if(contains(alphabetArr, s)){
                int val = alphabetMapping.get(s);
                  val = (val-key)%26;
                  if(val < 0){
                      val = 26+val;
                    }
                 Object s1= getKeyFromValue(alphabetMapping,val);
                 mss=s1.toString();
            }else{
                int val = alphabetMapping2.get(s);
                 val = (val-key)%26;
                 if(val < 0){
                      val = 26+val;
                    }
                 Object s1= getKeyFromValue(alphabetMapping2,val);
                 mss=s1.toString();
            }
             cipherString = cipherString+mss;
          
        }
        return cipherString;
    }
}
