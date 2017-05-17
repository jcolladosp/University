
public class PRGString
{
   public static boolean isPrefix( String a, String b ){
       //trival case
       if(a.length() == 0)return true;
       else if(a.length() > b.length()) return false;
       //general case
       else if(a.charAt(0) == b.charAt(0)) return isPrefix(a.substring(1),b.substring(1));
       else return false;
    }
   public static boolean isSubstring( String a, String b ){
     //trival case
       if(a.length() == 0)return true;
       else if(a.length() > b.length()) return false;
       else if(isPrefix(a,b) == true) return true;
     //general case  
       else return isSubstring(a,b.substring(1)); 
    
    } 
  public static boolean isPalindrome( String a ){
       //trivial case
       if (a.length() == 0 || a.length() == 1) return true;
       else if (Character.isLetter(a.charAt(0)) == false && Character.isLetter(a.charAt(a.length()-1)) == true) return isPalindrome(a.substring(1));
       else if (Character.isLetter(a.charAt(0)) == true && Character.isLetter(a.charAt(a.length()-1)) == false) return isPalindrome(a.substring(0,a.length()-1));
       //general case
       else{
           if (a.substring(0,1).toUpperCase().equals((a.substring(a.length()-1).toUpperCase()))) return isPalindrome((a.substring(1,a.length()-1)).toUpperCase());
           else return false;}
    } 
}
