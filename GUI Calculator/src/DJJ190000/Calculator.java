/*Written by Dayne John for CS2336.005, assignment 6, starting November 22, 2021.
	 NetID: djj190000
*/

/* This program uses JavaFX to display a simple calculator. The simple calculator takes in
 * 2 numbers inputted by the user inside of 2 TextField and it will display the answer
 * perform the four basic operations (Addition, Subtraction, Multiplication, Division).
 * The result of the calculation will display under the Result label. There is also a clear button.
 * If the user presses the Clear button, both input fields will be cleared and the result will be reset to 0. 
 * 
 * If the user tries to divide by 0, there will be an error message displayed under the Result label.
 * If the user tries to enter in anything other than a number, there will be an error message displayed under the Result Label
 * 
 * This program only requires the Main class (Calculator). 
 * 
 * The methods that this class contains are start, evaluateExpression, handle, and the main method. 
 */



/* Note to Grader 
 * The Professor said we were allowed to do everything in one class.
 */


package DJJ190000; //NetID

import javafx.application.Application;  //for launch
import javafx.event.ActionEvent; //for setOnAction
import javafx.event.EventHandler; //for eventHandlers
import javafx.geometry.HPos; //for Halignment
import javafx.geometry.Insets; //for insets on padding
import javafx.geometry.Pos; //for setAlignment Pos
import javafx.stage.Stage; //for primaryStage
import javafx.scene.Scene; //for scene
import javafx.scene.text.Font; //for font size
import javafx.scene.control.*; //for buttons, TextFields, and labels
import javafx.scene.layout.*; //for GridPane


public class Calculator extends Application implements EventHandler<ActionEvent>
{

	TextField userInput, userInput2; //make the TextFields for the first number and second number
	Label resultLbl; //make the label to display the result
	Label errorLbl;  //make the label to display the error message

	/* This method is used as the main entry point for JavaFX and to set everything up.
	 */
	@Override
	public void start(Stage primaryStage)
	{
		resultLbl = new Label(""); // label for the result
		errorLbl = new Label(""); // label for the error

		Button addBtn = new Button("+"); // create the button for addition
		Button subBtn = new Button("-"); // create the button for subtraction
		Button multBtn = new Button("X"); // create the button for multiplication
		Button divBtn = new Button("÷"); // create the button for division
		Button clearBtn = new Button("Clear"); // create the button for clear
		
		addBtn.setFont(Font.font(16)); //change font size of addBtn
		subBtn.setFont(Font.font(18)); //change font size of subBtn
		multBtn.setFont(Font.font(16)); //change font size of multBtn
		divBtn.setFont(Font.font(16)); //change font size of divBtn
		clearBtn.setFont(Font.font(16)); //change font size of clearBtn

		Label userInputLbl = new Label("Enter the first number "); // create the label for the first number
		userInput = new TextField(""); // create the TextField for the first number

		Label userInputLbl2 = new Label("Enter the second number "); // create the label for the second number
		userInput2 = new TextField(""); // create the TextField for the second number

		Label userInputLbl3 = new Label("Result "); // create the label for the result
		userInputLbl3.setStyle("-fx-underline:true;"); // underline the result label
		userInputLbl3.setFont(Font.font(14)); //enlarge the size of the font
		
		
		
		GridPane gridpane = new GridPane(); // create the GridPane

		gridpane.setMaxSize(400, 200); //make the window max 400x200
		gridpane.setAlignment(Pos.TOP_LEFT); //set alignment
		gridpane.setPadding(new Insets(10, 10, 10, 10)); //set the padding
		gridpane.setHgap(2.5); // set horizontal gap
		gridpane.setVgap(5.5); // set vertical gap

		// Place nodes in the pane
		gridpane.add(userInputLbl, 0, 0); //add userInputLbl to gridpane
		gridpane.add(userInput, 1, 0); //add userInput TextField to gridpane
		gridpane.add(userInputLbl2, 0, 1); //add userInputLbl2 to gridpane
		gridpane.add(userInput2, 1, 1); //add userInput2 TextField to gridpane
		gridpane.add(userInputLbl3, 0, 3); //add userInputLbl3 to gridpane

		gridpane.add(addBtn, 0, 10); //add the addBtn to gridpane 
		gridpane.add(subBtn, 0, 11); //add the subBtn to grdipane
		gridpane.add(multBtn, 0, 12); //add the multBtn to gridpane
		gridpane.add(divBtn, 0, 13); //add the divBtn to gridpane
		gridpane.add(clearBtn, 1, 10); //add the clearBtn to gridpane
		gridpane.add(resultLbl, 0, 4); //add the resultLbl to gridpane
		gridpane.add(errorLbl, 0, 5); //add the errorLbl to gridpane

		GridPane.setHalignment(addBtn, HPos.LEFT); //put the buttons to the left

		Scene scene = new Scene(gridpane); 	// Create a scene and place it in the stage
		primaryStage.setTitle("Calculator"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		addBtn.setOnAction(this); //if the addBtn gets clicked then call the event handler
		subBtn.setOnAction(this); //if the subBtn gets clicked then call the event handler
		multBtn.setOnAction(this); //if the multBtn gets clicked then call the event handler
		divBtn.setOnAction(this); //if the divBtn gets clicked then call the event handler
		clearBtn.setOnAction(this); //if the clearBtn gets clicked then call the event handler
	}


	/*
	 * This method takes in the first number, second number, and the button name. It
	 * evaluates what operation action needs to be performed based on the name of
	 * the button for that operation (add, subtract... etc). Once the method gets
	 * the name of the button that was clicked, it returns the name of the button
	 * that was pressed.
	 */

	
	public String evaluateExpression(String firstNum, String secondNum, String buttonName)
	{
		float firstNumber, secondNumber; //create the floats for the first and second number.
		float result = 0; //create a variable to store the result of the operation and initialize it to 0.
		if (buttonName == "+") //if it is the add button
		{
			firstNumber = Float.parseFloat(firstNum); //parse firstNumber TextField and store the result in the string firstNum 
			secondNumber = Float.parseFloat(secondNum); //parse secondNumber TextField and store the result in the string secondNum
															

			result = firstNumber + secondNumber; //store the result of the addition inside of result

			errorLbl.setText(""); //clear the error label
			return String.valueOf(result); //return the result of the addition
		}

		else if (buttonName == "-") //if it is the subtract button
		{
			firstNumber = Float.parseFloat(firstNum); //parse firstNumber TextField and store the result in the string firstNum 
			secondNumber = Float.parseFloat(secondNum); //parse secondNumber TextField and store the result in the string secondNum
			
			result = firstNumber - secondNumber; //store the result of the subtraction inside of result

			errorLbl.setText(""); //clear the error label
			return String.valueOf(result); //return the result of the subtraction
		} 
		else if (buttonName == "X") //if it is the multiply button
		{
			firstNumber = Float.parseFloat(firstNum); //parse firstNumber TextField and store the result in the string firstNum 
			secondNumber = Float.parseFloat(secondNum); //parse secondNumber TextField and store the result in the string secondNum
			
			result = firstNumber * secondNumber; //store the result of the multiplication inside of result
			
			
			errorLbl.setText(""); //clear the error label
			return String.valueOf(result); //return the result of the multiplication

		}

		else if (buttonName == "÷") //if it is the divide button
		{

			firstNumber = Float.parseFloat(firstNum); //parse firstNumber TextField and store the result in the string firstNum 
			secondNumber = Float.parseFloat(secondNum); //parse secondNumber TextField and store the result in the string secondNum

			result = firstNumber / secondNumber; //store the result of the multiplication inside of result

			if (secondNumber == 0) //if the second number that we divide by is 0
			{
				errorLbl.setText("Can't divide by 0.") ; //then notify user of error 
			} 
			else
			{
				errorLbl.setText(""); //clear the error label
				return String.valueOf(result); //return the result of the devision
			}
		}
		
		return "Error!"; //notify user of error
	}

	
	/* Main method that will launch the program.
	 */
	public static void main(String[] args)
	{
		launch(args); //launch JavaFX
	}

	
	
	
	/* This eventHandler takes in the button that was clicked as an action event.
	 * It is then casted to a button and gets the text/name that is correlated to the button.
	 * Based on the button source, it will perform the appropriate operation. 
	 */
	
	@Override
	public void handle(ActionEvent mouseButton)
	{
		Button button = (Button) mouseButton.getSource(); //get the source of the event that occurred and cast it to a button
		String buttonName = button.getText(); //get the name of the button that was pressed

		try
		{
			switch(buttonName) //based on which button is pressed
			{
				case "Clear": //if the clear button is pressed
				resultLbl.setText("0"); //clear the result label
				userInput.setText(" "); //clear the userInput TextField
				userInput2.setText(" "); //clear the userInput2 TextField
				errorLbl.setText(""); //clear the error label
				break; //leave
			
				default: //if it's any other button
				resultLbl.setFont(Font.font(16)); //enlarge the font size
				resultLbl.setText(evaluateExpression(userInput.getText(), userInput2.getText(), buttonName)); //then evaluate the expression and perform the appropriate operation	
			}

		} 
		
		catch (Exception e) //if there is an error
		{
			
			resultLbl.setText("Error!"); //notify the user of the error
			errorLbl.setText("Enter only numbers."); //let user know they must input only numbers
		}
	}

}
