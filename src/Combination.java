import java.util.ArrayList;
import java.util.Arrays;

public class Combination {
	static ArrayList<String> permutations = new ArrayList<String>();
	
	public static void main (String[] args){
		String original = "edcba";
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        System.out.println(sorted);
	}
	
	public static String moveX(String lineln){
		if(lineln == null || lineln.length() <= 1){
			return lineln;
		}
    
		if(lineln.charAt(0) == 'x'){
			return moveX(lineln.substring(1)) + lineln.charAt(0);
		}
		
		return lineln.charAt(0) + moveX(lineln.substring(1));
		
	}
	
	public static String checkX(String x){
		if(x.substring(0, 1).equals("x") || x.substring(1, 2).equals("x") || x.substring(2, 3).equals("x") || x.substring(3, 4).equals("x")){
			return null;
		}
		
		return "good";
	}
}
