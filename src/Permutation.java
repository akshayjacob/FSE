import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
	
	static ArrayList<String> permutations = new ArrayList<String>();
	
	public static void main (String[] args){
		char[] perm = new char[6];
		permutation(perm, 0, "ax");
		
		String check = null;
		
		for(int i = 0; i < permutations.size(); i++){
			check = permutations.get(i);
			
			check = moveX(check);
			check = checkX(check);
			
			for(int j = 0; j < permutations.size() - 1; j++){
				check = checkDuplicates(permutations.get(i), permutations.get(j));
			}
			System.out.println(check);
//			if(!(check == null)){
//				System.out.println(permutations.get(i));
//			}
			
		}  
	}
	
	public static void permutation(char[] perm, int pos, String str) {
	    if (pos == perm.length) {
	    	permutations.add(new String(perm));
	    } else {
	        for (int i = 0 ; i < str.length() ; i++) {
	            perm[pos] = str.charAt(i);
	            permutation(perm, pos+1, str);
	        }
	    }
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
		
		return x;
	}
	
	public static String checkDuplicates(String string1, String string2){
		if((string1 == null) || (string2 == null)){
			return string1;
		}else{
			char[] chars1 = string1.toCharArray();
			char[] chars2 = string2.toCharArray();
			
			Arrays.sort(chars1);
			Arrays.sort(chars2);
			
			String sorted1 = new String(chars1);
			String sorted2 = new String(chars1);
			
			if(sorted1.equals(sorted2)){
				return null;
			}else{
				return string1;
			}
		}
	}
}
