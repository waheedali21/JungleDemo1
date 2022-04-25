/**
 * 
 */
package com.jungle.dataprovider;

import org.testng.annotations.DataProvider;

import com.jungle.utility.NewExcelLibrary;



/**
 * @author Waheed
 *
 */
public class DataProviders {

	//This class is available in *utility* package
	NewExcelLibrary obj = new NewExcelLibrary();

	
//Class --> LandingPageTest(email Sign-Up)

	@DataProvider(name = "emailSignUp")
	public Object[][] getEmailSignUpCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("SignUp");
		// Total Columns
		int column = obj.getColumnCount("SignUp");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("SignUp", j, i + 2);
			}
		}
		return data;
	}


}
