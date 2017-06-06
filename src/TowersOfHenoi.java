import java.util.ArrayList;
import java.util.Scanner;

public class TowersOfHenoi {
	
	static ArrayList<String> movements = new ArrayList<String>();
	//http://www.javawithus.com/programs/towers-of-hanoi
	public static void main(String[] args) {
		int towerHeight = 0;
		
		System.out.print("What is the height of the original tower: ");
		
		Scanner scanner = new Scanner(System.in);
		towerHeight = scanner.nextInt();
		
		moveTower(towerHeight, "1", "2", "3");
		
		printArrayList();
	}

	public static void moveTower(int towerHeight, String one, String two, String three) {
		if(towerHeight == 1){
			movements.add(one + " to " + three);
		}else{
			moveTower(towerHeight - 1, one, three, two);
			movements.add(one + " to " + three);
			moveTower(towerHeight - 1, two, one, three);
		}
	}
	
	public static void printArrayList(){
		for(int i = 0; i < movements.size(); i++){
			System.out.println(movements.get(i));
		}
	}
}
