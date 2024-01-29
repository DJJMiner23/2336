/*Written by Dayne John for CS2336.005, assignment 1, starting August 31, 2021.
 NetID: djj190000
 */

/* This program performs unit conversions for measurements of temperature, weight, and distance.
The user is prompted with a menu and they can choose from a menu to convert temperature, (fahrenheit to celsius and celsisus to fahrenheit)
weight (pounds to kilograms and kilograms to pounds), distance (miles to kilometers and kilometers to miles). Once the user selects a chooses 
a menu option, the proper conversion will occur and the user will see the result of their desired conversion. 

This program requires 3 classes, Temperature, Weight, and Distance. All 3 classes must be in the same directory as the Main class (CS2336Asg1).
Each class contains the conversion method for that specific class. For example, Temperature contains the method that converts temperatures
between Fahrenheit and Celsius and so on and so forth for the Weight and Distance classes. 


*/

import java.util.*; //used for scanner
import java.text.DecimalFormat; //used to format conversion result
 
public class CS2336Asg1   
{

	public static void main(String[] args) 
	{
		DecimalFormat df = new DecimalFormat("0.00"); // create decimal formatter to put all doubles to 2 decimals

		// Instantiate each class exactly once
		Temperature temperature = new Temperature();
		Weight weight = new Weight();
		Distance distance = new Distance();

		
		int choice = 0; //set choice
		Scanner scan = new Scanner(System.in); // create scanner object

		System.out.println("Welcome to the Unit Conversion Program!"); //Greeting for the User

		System.out.println("\nUNIT CONVERSION MENU"); // Display menu
		System.out.println("-------------------------------------");
		
		while (choice != 7) // As long as the user doesn't enter 7 which exits the program, then allow the
							// user to choose from the menu.
		{
			//Menu Options
			System.out.println("Please enter a value from 1-7 to choose from the menu options below. "); 
			System.out.println("1. Convert Fahrenheit to Celsius");
			System.out.println("2. Convert Celsius to Fahrenheit");
			System.out.println("3. Convert pounds to kilograms");
			System.out.println("4. Convert kilograms to pounds");
			System.out.println("5. Convert miles to kilometers");
			System.out.println("6. Convert kilometers to miles");
			System.out.println("7. Exit the program. "); 
			System.out.println("-------------------------------------\n");
			
			System.out.print("Please enter your menu option: ");
			
			try //The try catch block is used to verify that the user-provided value is an integer and not anything else. 
			{
				choice = Integer.parseInt(scan.nextLine()); // store user choice
			}
			catch(NumberFormatException exc) // make sure the value is an integer
			{
				System.out.println("\nInvalid option! \nYou must enter a value from 1-7 to choose from the menu options below.\n"); //Notifies the user to input a valid integer from 1-7. 
				continue; //goes back to the beginning of the loop
			}
			
			switch (choice) // based on the user's choice from the menu, make the appropriate conversions
			{
			case 1: // Choice 1 - Fahrenheit to Celsius
				System.out.print("\nEnter your temperature in Fahrenheit: "); //prompt user for temperature in fahrenheit
				double fahrenheit = Double.parseDouble(scan.nextLine()); //store user's input in the variable fahrenheit
				System.out.println("You entered a temperature of " + fahrenheit + " degrees Fahrenheit.");
				System.out.println("This temperature is equivalent to " + df.format(temperature.convertFahrenheitToCelsius(fahrenheit)) + " degrees Celsius."); //Output/print the converted temperature in Celsius
				break;
				
			case 2: // Choice 2 - Celsius to Fahrenheit
				System.out.print("\nEnter your temperature in Celsius: "); //prompt user for temperature in celsius
				double celsius = Double.parseDouble(scan.nextLine()); //store user's input in the variable celsius
				System.out.println("You entered a temperature of " + celsius + " degrees Celsius."); 
				System.out.println("This temperature is equivalent to " + df.format(temperature.convertCelsiusToFahrenheit(celsius)) + " degrees Fahrenheit."); //Output/Print the converted temperature in Fahrenheit
				break;
				
			case 3: // Choice 3 - Pounds to Kilograms
				System.out.print("\nEnter your weight in pounds: "); //prompt user for weight in pounds
				double pounds = Double.parseDouble(scan.nextLine()); //store user's input in the variable pounds
				double kilograms = weight.convertWeightFromPoundsToKilograms(pounds); //Convert weight from pounds to kilograms and store it in the variable kilograms
				while(kilograms == -1) //if kilograms is negative
				{
					System.out.println("\nInvalid weight. Weight cannot be negative. \n"); //Output/print error message since weight can't be negative
					System.out.print("Enter your weight in pounds: "); //re-prompt the user for a valid weight
					pounds = Double.parseDouble(scan.nextLine()); //store user's input in the variable pounds
					kilograms = weight.convertWeightFromPoundsToKilograms(pounds); //Convert weight from pounds to kilograms and store it in the variable kilograms
				} 

				System.out.println("You entered a weight of " + pounds + " pounds. ");
				System.out.println("This weight is equivalent to " + df.format(kilograms) + " kilograms."); //Output/print weight in kilograms.
				break;
				
			case 4: // Choice 4 - Kilograms to Pounds
				System.out.print("\nEnter your weight in kilograms: "); //prompt user for weight in kilograms
				kilograms = Double.parseDouble(scan.nextLine());  //store user's input in the variable kilograms
				pounds = weight.convertWeightFromKilogramsToPounds(kilograms); //Convert weight from pounds to kilograms and store it in the variable kilograms
				while(pounds == -1)  //if pounds is negative
				{ 
					System.out.println("\nInvalid weight. Weight cannot be negative. \n"); //Output/print error message since weight can't be negative
					System.out.print("Enter your weight in kilograms: "); //re-prompt the user for a valid weight
					kilograms = Double.parseDouble(scan.nextLine()); //store user's input in the variable kilograms
					pounds = weight.convertWeightFromPoundsToKilograms(kilograms); //Convert weight from kilograms to pounds and store it in the variable pounds
				} 
				
				System.out.println("You entered a weight of " + kilograms + " kilograms. ");  
				System.out.println("This weight is equivalent to " + df.format(pounds) + " pounds."); //Output/print weight in pounds
				break;
				
			case 5: // Choice 5 - Miles to Kilometers
				System.out.print("\nEnter your distance in miles: "); //prompt user for distance in miles
				double miles = Double.parseDouble(scan.nextLine()); //re-prompt the user for a valid distance
				double kilometers = distance.convertDistanceFromMilesToKilometers(miles); //store user's input in the variable kilometers
				while(kilometers == -1) //if kilometers is negative
				{
					System.out.println("\nInvalid distance. Distance cannot be negative. \n"); //Output/print error message since distance can't be negative
					System.out.print("Enter your distance in miles: "); //re-prompt the user for a valid distance
					miles = Double.parseDouble(scan.nextLine()); //store user's input in the variable miles
					kilometers = distance.convertDistanceFromMilesToKilometers(miles); //Convert distance from miles to kilometers and store it in the variable kilometers
				}
				
				System.out.println("You entered a distance of " + miles + " miles."); 
				System.out.println("This distance is equivalent to " + df.format(kilometers) + " kilometers."); //Output/print distance in kilometers 
				break;
				
			case 6: // Kilometers to Miles
				System.out.print("\nEnter your distance in kilometers: "); //prompt user for distance in kilometers 
				kilometers = Double.parseDouble(scan.nextLine()); //re-prompt the user for a valid distance
				miles = distance.convertDistanceFromKilometersToMiles(kilometers); //store user's input in the variable miles
				while (miles == -1) //if miles is negative
				{
					System.out.println("Invalid distance. Distance cannot be negative. \n"); //Output/print error message since distance can't be negative
					System.out.print("Enter your distance in kilometers: "); //re-prompt the user for a valid distance
					kilometers = Double.parseDouble(scan.nextLine()); //store user's input in the variable miles
					miles = distance.convertDistanceFromMilesToKilometers(kilometers); //Convert distance from kilometers to miles and store it in the variable miles					
				}
				System.out.println("You entered a distance of " + kilometers + " kilometers.");
				System.out.println("This distance is equivalent to " + df.format(miles) + " miles."); //Output/print distance in kilometers 
				break;
				
			case 7: // Exit the program
				System.out.print("\nExiting the program!");
				break;
				
			default: // Re-prompt the user if they don't enter valid input 
				System.out.print("\nInvalid option! \nPlease enter a value from 1-7 to choose from the menu options below.");
				break;
			}
			
			//whitespace
			System.out.println("\n");
		}

		System.out.println("\nThank you for using the Unit Conversion Program! Goodbye! \n"); //Exit
	}

}