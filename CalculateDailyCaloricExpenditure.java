import java.util.Scanner;

public class CalculateDailyCaloricExpenditure {
	public static void main(String[] srgs){
		
		// Used to get user input
		Scanner scanner = new Scanner(System.in);
		
		// Declare variables for conversion of units
		double kilogram = 2.2;
		double centimeters = 2.54;
		
		// Activity Level Factor values
		double sedentary = 1.2;
		double lightlyActive = 1.375;
		double moderatelyActive = 1.55;
		double veryActive = 1.725;
		double extremelyActive = 1.9;
		
		/* Get user input for weight. 
		Weight is automatically calculated for kilos. Could request input in kilos.
		*/
		System.out.print("Enter your weight in pounds > ");
		double currentWeightInPounds = scanner.nextFloat();
		
		System.out.println("Your weight in pounds is " + currentWeightInPounds);
		
		//System.out.println();
		
		double currentWeightInKilos = currentWeightInPounds / kilogram;
		System.out.printf("Your weight in kilos is %.2f ", currentWeightInKilos); 
		
		System.out.println();
		
		// Get user input for height in feet
		
		System.out.print("Enter your height in feet > ");
		double currentHeightInFeet = scanner.nextFloat();
		
		// Get user input for height in inches
		
		System.out.print("Enter your height in inches > ");
		double currentHeightInInches = scanner.nextFloat();
		
		// Total height in inches is calculated
		
		double totalHeightInInches = (currentHeightInFeet * 12) + currentHeightInInches; 
		
		System.out.printf("Your height in inches is %.1f ", totalHeightInInches); 
		
		System.out.println();
		
		// Total height in centimeters is calculated automatically. If using the metric system, system could be set up to get user input in metric units.
		
		double totalHeightInCm = (totalHeightInInches *  centimeters); 
		
		System.out.printf("Your height in centimeters is %.1f ", totalHeightInCm); 
		
		System.out.println();
		
		// Get user input for age
		System.out.print("Enter your age in years only > ");
		int currentAge = scanner.nextInt(); 
		System.out.println("Your age is: " + currentAge);
		
		System.out.println();
		
		// Harris-Benedict equation for basal metabolic rate only allows for two options
		System.out.print("Enter your gender. Male (1) or Female (2) > ");
		int currentGender = scanner.nextInt(); 
		
		switch(currentGender){
			case 1:
				System.out.println("You selected: Male");
				break;
			case 2:
				System.out.println("You selected: Female");
				break;
			default:
				System.out.println("You must select either (1) for Male or (2) for Female");
				break;
			
		} 
		
		System.out.println();
		
		// use an ENUM
		// Get user input to get user's activity level
		System.out.print("Select your activity level. Your choices are: Sedentary(1), Lightly active(2), Moderately active(3), Very active(4), Extremely active(5)  > ");
		int currentALF = scanner.nextInt();
		
		switch(currentALF){
			case 1:
				System.out.printf("You selected: Sedentary %.1f ", sedentary);
				break;
			case 2:
				System.out.printf("You selected: Lightly active %.3f ", lightlyActive);
				break;
			case 3:
				System.out.printf("You selected: Moderately active %.2f ", moderatelyActive);
				break;
			case 4:
				System.out.printf("You selected: Very active %.3f ", veryActive);
				break;
			case 5:
				System.out.printf("You selected: Extremely active %.1f ", extremelyActive);
				break;
			default:
				System.out.println("You must type either 1, 2, 3, 4, or 5");
				break;
			
		}
		
		System.out.println();
		
		// Calculations for Daily Caloric Expenditure
		
		// Daily Caloric Expenditure for male
		double convertDCEMetricMale = currentALF * ((13.75 * currentWeightInKilos) + (5 * totalHeightInCm) - (6.76 * currentAge) + 66);
		
		double convertDCEImperialMale = currentALF * ((6.25 * currentWeightInPounds) + (12.7 * totalHeightInInches) - (6.76 * currentAge) + 66);
		
		// Daily Caloric Expenditure for female
		double convertDCEMetricFemale = currentALF * ((9.5 * currentWeightInKilos) + (1.85 * totalHeightInCm) - (4.68 * currentAge) + 655);
		
		double convertDCEImperialFemale = currentALF * ((4.35 * currentWeightInPounds) + (4.7 * totalHeightInInches) - (4.68 * currentAge) + 655);
		
		// Display results in imperial units
		System.out.printf("Your daily caloric expenditure for a male in imperial units is: %.2f ", convertDCEImperialMale);
		
		System.out.println();
		
		System.out.printf("Your daily caloric expenditure for a female in imperial units is: %.2f ", convertDCEImperialFemale);
		
		System.out.println();
		
		// Display results in metric units
		System.out.printf("Your daily caloric expenditure for a male in metric units is: %.2f ", convertDCEMetricMale);
		
		System.out.println();
		
		System.out.printf("Your daily caloric expenditure for a female in metric units is: %.2f ", convertDCEMetricFemale);
		
		scanner.close();
		
	}
}