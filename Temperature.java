/*Written by Dayne John for CS2336.005, assignment 1, starting August 31, 2021.
 NetID: djj190000
 */

/*This program is used to convert different units of temperature. 
  It can convert temperature from Fahrenheit to Celsius and Celsius to Fahrenheit.
  This class, Temperature, must be in the same directory as the Main class (CS2336Asg1).
 */

public class Temperature
{ 

	/*
	  This method converts the user-provided temperature from Fahrenheit to
	  Celsius. In order to convert the temperature from Fahrenheit to Celsius, you
	  must do (fahrenheit - 32) * (5.0/9). The result of that equation is equal to
	  the temperature in Celsius.
	 */
	public double convertFahrenheitToCelsius(double fahrenheit)
	{
		return (fahrenheit - 32) * (5.0 / 9); // Return the conversion result of temperature from Fahrenheit to Celsius
	}

	/*
	  This method converts the user-provided temperature from Celsius to
	  Fahrenheit. In order to convert the temperature from Celsius to Fahrenheit,
	  you must do (celsius * 9.0/5) + 32. The result of that equation is equal to
	  the temperature in Fahrenheit
	 */
	public double convertCelsiusToFahrenheit(double celsius)
	{
		return (celsius * 9.0 / 5) + 32; // Return the conversion result of temperature from Celsius to Fahrenheit
	}

}