import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FSE {
	private int[] numbers;
    private int number;
	
    static PrintWriter output;
    
	public static void main(String[] args) throws IOException {
		Teacher[] teacherInfo = new Teacher[200];
		
		String fileInName 	= "input.dat";  											//Initializes String variable fileInName to input file
		String line 		= null; 														//Initializes String variable line to null value
		String fileOutName = "output.dat";
		
		int counter  = 0;																	//Initlializes integer variable called counter to 0
	
		output = new PrintWriter(new FileWriter(fileOutName));
		
		try { 																				//tries to read file in project... if cannot then goes to catch
			FileReader fileReader = new FileReader(fileInName); 							//Initializes file reader to open file
			BufferedReader bufferedReader = new BufferedReader(fileReader);					//Initializes buffered reader to read file
			
			while((line = bufferedReader.readLine()) != null){ 	  							//runs code underneith as long as the next line read isn't empty
					String[] temp = line.split(","); 										//splits the read line into to each element in temp array per comma splitting words in the line
					
					teacherInfo[counter] = new Teacher();									
					teacherInfo[counter].setName(temp[0]); 									
					teacherInfo[counter].setSenority(Integer.parseInt(temp[1]));									
					teacherInfo[counter].setHireDate(temp[2]);	
					
					if((temp[3].length() > 2) && (temp[3].length() < 6)){
						teacherInfo[counter].setCourses(temp[3]);
					}
														
					counter++; 																//increments counter variable by 1
			} 																				//closes while
	
			fileReader.close();	 															//closes buffered reader
			bufferedReader.close(); 														//closes file reader
		} catch (IOException ex) { 
			System.out.println("Error reading file: " + fileInName + " " + ex); 			//prints out error message when file cant be read or doesnt exist
		} 																					//closes catch
		
		quickSort(teacherInfo, 0, counter - 1);
		
		printToFile(teacherInfo, counter);
		
		
		
		output.close();
	}
	
	public static int partition(Teacher[] arr, int left, int right){
	      int i = left, j = right;
	      
	      Teacher tmp;
	      Teacher pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i].getSenority() < pivot.getSenority()){
	            	i++;
	            }
	            
	            while (arr[j].getSenority() > pivot.getSenority()){
	            	j--;
	            }
	            
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      }
	     
	      return i;
	}
	
	public static void quickSort(Teacher[] arr, int left, int right) {
	      if (left < right){
	    	  int index = partition(arr, left, right);
	    	  quickSort(arr, left, index - 1);
	          quickSort(arr, index, right);
	      }
	}
	
	public static void printToFile(Teacher[] arr, int counter){
		for(int i = 0; i < counter; i++){
			output.println(arr[i].getName() + " " + arr[i].getSenority());
			//+ " " + teacherInfo[i].getHireDate() + " " + teacherInfo[i].getCourses()
		}
	}
}

class Teacher{
	private String Name;  //Initlizes private string variable firstName
	private String HireDate;	//Initlizes private string variable lastName
	private String Courses;	//Initlizes private string variable gender
	private String[] permCourses;	//Initlizes private string variable gender
	private int Senority;	//Initlizes private integer variable id
	
//GETTERS***************************************************************************************	
	public String getName(){
		return Name;
	}
	public String getHireDate(){
		return HireDate;
	}
	public String getCourses(){
		return Courses;
	}
	public String[] getPermCourses(){
		return permCourses;
	}
	public int getSenority(){
		return Senority;
	}
	
//SETTERS***************************************************************************************	
	public void setName(String Name){
		this.Name = Name;
	}
	public void setHireDate(String HireDate){
		this.HireDate = HireDate;
	}
	public void setCourses(String Courses){
		this.Courses = Courses;
	}
	public void setPerCourses(String[] permCourses){
		this.permCourses = permCourses;
	}
	public void setSenority(int Senority){
		this.Senority = Senority;
	}
}