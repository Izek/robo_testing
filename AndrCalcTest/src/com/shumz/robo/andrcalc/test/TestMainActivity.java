package com.shumz.robo.andrcalc.test;

import com.jayway.android.robotium.solo.Solo;
import com.shumz.robo.andrcalc.MainActivity;
import com.shumz.robo.andrcalc.R;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class TestMainActivity extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;

	public TestMainActivity() {
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testDisplayBlackBox() {

		// Enter10infirtsedit-field
		solo.enterText(0, "10");
		// Enter20infirtsedit-field
		solo.enterText(1, "20");
		// ClickonMultipylbutton
		solo.clickOnButton("Multiply");
		// Verifythatreslutantof10x20
		assertTrue(solo.searchText("200"));

	}

	public void testDsiplayWhiteBox() {
		// Defining our own values to multiply
		float firstNumber = 10;
		float secondNumber = 20;
		float resutl = firstNumber * secondNumber;

		// Access First value(edit-filed)andputtingfirstNubmervalueinit
		EditText FirstEditText = (EditText) solo.getView(R.id.EditText01);
		solo.enterText(FirstEditText, String.valueOf(firstNumber));

		// Access Second value(edit-filed)andputtingSeconduNmbervalueinit
		EditText SecondEditText = (EditText) solo.getView(R.id.EditText02);
		solo.enterText(SecondEditText, String.valueOf(secondNumber));

		// Click on Multiply button
		solo.clickOnButton("Multiply");
		assertTrue(solo.searchText(String.valueOf(resutl)));
		TextView outputField = (TextView) solo.getView(R.id.TextView01);

		// Assert to verify result with visible value
		assertEquals(String.valueOf(resutl), outputField.getText().toString());
	}

	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	// Trying to add custom methods....

	public void testInputDoubledDigitsBB() {

		solo.enterText(0, "5.3");
		solo.enterText(1, "6.2");
		solo.clickOnButton("Multiply");
		assertTrue(solo.searchText("32.86"));

	}

	public void testInputCorruptedDoubledDigitsBB() {

		// solo.enterText(0, "5.3.8");

		solo.enterText(0, "05.38");
		solo.enterText(1, "6.200000000000");
		solo.clickOnButton("Multiply");
		assertTrue(solo.searchText("33.356"));

	}

	public void testNoInputBB() throws Exception {

		try {
		
		} catch (Exception e) {
			solo.clickOnButton("Multiply"); Log.e("^__^", e.getMessage());
			e.printStackTrace();
			
		}

	}

	public void testZerosMultBB() {

		solo.enterText(0, "0");
		solo.enterText(1, "0");
		solo.clickOnButton("Multiply");

		assertTrue(solo.searchText("0.0"));
	}

	public void testInputRestictedSymbolsBB() {

		try {
			solo.enterText(0, "/+-*/#%!@#$%^&*()_cjgvsdksdv0");
			solo.enterText(1, "VEDFE KEbf kvhrvb76t67250464.dvd");
		} catch (Exception e) {

			solo.clickOnButton("Multiply");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testNoInputForFieldOneBB() {

		try {
			solo.enterText(0, "0");

			solo.clickOnButton("Multiply");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testNoInputForFieldTwoBB() {

		solo.enterText(1, "0");

		solo.clickOnButton("Multiply");

	}
}
