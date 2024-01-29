/*Written by Dayne John for CS2336.005, assignment 1, starting August 31, 2021.
 NetID: djj190000
 */

/*This program is used to convert different units of distance. 
  It can convert distance from miles to kilometers and kilometers to miles.
  It also makes sure that the distance is positive and not negative. 
  This class, Distance, must be in the same directory as the Main class (CS2336Asg1).
 */

public class Distance  
{
   
	/* This method converts the user-provided distance from miles to kilometers 
	   There is a validation check to make sure that the user-provided distance is not negative. 
	   In order to convert the distance from miles to kilometers, you must multiply by 1.609.
	 */
    public double convertDistanceFromMilesToKilometers (double miles)
    {
        if(miles < 0) //if the user inputs a negative distance in miles
        {
            return -1; //error flag can't have negative distance
        }
        return 1.609344 * miles; //otherwise if the distance in miles is positive then convert to kilometers
    }
   

	/* This method converts the user-provided distance from kilometers to miles 
	   There is a validation check to make sure that the user-provided distance is not negative. 
	   In order to convert the distance from kilometers to miles, you must divide by 1.609.
	 */
    public double convertDistanceFromKilometersToMiles (double kilometers)
    {
        if(kilometers < 0) //if the user inputs a negative distance in miles
        {
            return -1; //error flag can't have negative distance
        }
        return kilometers/1.609344; //otherwise if the distance in kilometers is positive then convert to miles
    }
   
}
