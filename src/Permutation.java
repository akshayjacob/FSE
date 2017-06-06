import java.util.ArrayList;

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
			
			if(!(check == null)){
				System.out.println(permutations.get(i));
			}
			
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
		
		return "good";
	}
}