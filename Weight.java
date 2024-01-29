/*Written by Dayne John for CS2336.005, assignment 1, starting August 31, 2021.
 NetID: djj190000
 */

/*This program is used to convert different units of weight. 
  It can convert pounds to kilograms or kilograms to pounds.
  It also makes sure that the weight is positive and not negative. 
  This class, Weight, must be in the same directory as the Main class (CS2336Asg1).
 */
 
public class Weight 
{

	/* This method converts the user-provided weight from pounds to kilograms 
	   There is a validation check to make sure that the user-provided weight is not negative. 
	   In order to convert the weight from pounds to kilograms, you must divide by 2.205.
	 */
	public double convertWeightFromPoundsToKilograms(double pounds)
	{
		if (pounds < 0) //if the user inputs a negative weight in pounds
		{
			return -1; //error flag can't have negative weight
		} 
		return pounds / 2.2046; //otherwise if the weight in pounds is positive then convert to kilograms
	}

	/* This method converts the user-provided weight from kilograms to pounds 
	   There is a validation check to make sure that the user-provided weight is not negative. 
	   In order to convert the weight from kilograms to pounds, you must multiply by 2.205.
	 */
	public double convertWeightFromKilogramsToPounds(double kilograms)
	{
		if (kilograms < 0) //if the user inputs a negative weight in kilograms 
		{
			return -1; //error flag can't have negative weight 
		}
		return 2.2046 * kilograms; //otherwise if the weight in kilograms is positive then convert to pounds  
	}
}