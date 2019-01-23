package string.decompression;

/**
 *
 * @author Cas
 */
public class StringDecompression {

    static String decompress(String input, int repeats) {
        String output = "";
        String temp = "";
        int count = 0;
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                output += input.charAt(i);
            }
            
            else {
                while (Character.isDigit(input.charAt(i))) {
                    count = count * 10 + Character.getNumericValue(input.charAt(i));
                    i++;
                }
                
                i++;
                while (i < input.length() && input.charAt(i) != ']') {
                    temp += input.charAt(i);
                    i++;
                }
                
                output += decompress(temp, count);
                
                count = 0;
                temp = "";
            }
        }
        
        temp = output;
        for(int i = 1; i < repeats; i++) output += temp;
        return output;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String input = "10[2[d]]2[cat]bean";        
        System.out.println(decompress(input, 1));
        
    }    
}
