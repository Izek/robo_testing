package com.LookHin.StackCalculator.test;

import com.LookHin.StackCalculator.StackCalculator;
import com.jayway.android.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

public class StackCalculatorTestLaunchBB extends
		ActivityInstrumentationTestCase2<StackCalculator> {

	private static final String TAG_APP = "---StackCalc-00---";
	private Solo solo;

	public StackCalculatorTestLaunchBB() {
		super("com.LookHin.StackCalculator", StackCalculator.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		// solo.finishOpenedActivities();
	}

	public void testAssertingProperActivity() {
		solo.assertCurrentActivity("Check proper activity",
				StackCalculator.class);
	}

	public void testAddTwoNumbersBBox() {

		solo.clickOnButton("2");
		solo.clickOnButton("+");
		solo.clickOnButton("2");

		solo.clickOnButton("=");

		assertEquals(solo.getEditText(1).getText().toString(), "4.0");
		// Log.v(TAG_APP, "Result is: " +
		// solo.getEditText(1).getText().toString());

		// solo.sleep(200);

		if (solo.getEditText(1).getText().toString().equals("4.0")) {
			Log.v(TAG_APP, "Success for testAddTwoNumbersBBox()");
		} else {
			Log.d(TAG_APP, "Fail!.. Result is "
					+ solo.getEditText(1).getText().toString());
			fail();
		}
	}

	public void testSubstractTwoNumbersBB() {

		solo.clickOnButton("5");
		solo.clickOnButton("-");
		solo.clickOnButton("2");

		solo.clickOnButton("=");

		assertEquals(solo.getEditText(1).getText().toString(), "3.0");

		if (solo.getEditText(1).getText().toString().equals("3" + ".0")) {
			Log.v(TAG_APP, "Success for testSubstractTwoNumbersBB()");
		} else {
			Log.d(TAG_APP, "Fail!.. Result is "
					+ solo.getEditText(1).getText().toString());
			fail();
		}
	}

	public void testMultiplyTwoNumbersBB() {

		solo.clickOnButton("3");
		solo.clickOnButton("*");
		solo.clickOnButton("2");

		solo.clickOnButton("=");

		assertEquals(solo.getEditText(1).getText().toString(), "6.0");

		if (solo.getEditText(1).getText().toString().equals("6.0")) {
			Log.v(TAG_APP, "Success for testMultiplyTwoNumbersBB()");
		} else {
			Log.d(TAG_APP, "Fail!.. Result is "
					+ solo.getEditText(1).getText().toString());
			fail();
		}
	}

	public void testDivideTwoNumbersBB() {

		solo.clickOnButton("5");
		solo.clickOnButton("/");
		solo.clickOnButton("2");

		solo.clickOnButton("=");

		assertEquals(solo.getEditText(1).getText().toString(), "2.5");

		if (solo.getEditText(1).getText().toString().equals("2.5")) {
			Log.v(TAG_APP, "Success for testDivideTwoNumbersBB()");
		} else {
			Log.d(TAG_APP, "Fail!.. Result is "
					+ solo.getEditText(1).getText().toString());
			fail();
		}
	}
}
