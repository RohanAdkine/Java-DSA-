
    import java.util.*;
    //Reverse a String using a Stack
    
    public class Reverse_a_String_using_a_Stack{
        public static void main(String args[]) {
            String str = "HelloWorld";
    
            Stack<Character> s = new Stack<>();
            
            int i=0;
            while(i<str.length()) {
                s.push(str.charAt(i));
                i++;
            }
    
            StringBuilder result = new StringBuilder("");
            while(!s.isEmpty()) {
                result.append(s.pop());
            }
            str = result.toString();
            System.out.println(str);
        }
    }
