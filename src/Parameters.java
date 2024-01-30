import java.util.Random;

public class Parameters {

	Random rand =new Random();
	
	
	String [] firstNames= {"amal","ahmad","abod","bayan"};
	String [] lastNames= {"mohammad","khaled","qais","majd"};
	String commonPassword="Bb123@@##";

	int randomEmailId= rand.nextInt(9999);
	int randomFirstNames= rand.nextInt(firstNames.length);
	int randomLastNames= rand.nextInt(lastNames.length);
	String emailId=firstNames[randomFirstNames]+lastNames[randomLastNames]+randomEmailId+"@"+"gmail.com";
}
