package com.LookHin.StackCalculator.test;

import com.LookHin.StackCalculator.StackCalculator;
import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;


public class StackCalculatorTestLaunch extends ActivityInstrumentationTestCase2<StackCalculator> {

	private Solo solo;
	
	public StackCalculatorTestLaunch() {
		super("com.LookHin.StackCalculator", StackCalculator.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
//		solo.finishOpenedActivities();
	}

	
	public void testAssertingProperActivity()
	{
		solo.assertCurrentActivity("Check proper activity", StackCalculator.class);
	}
	
	public void testAddTwoNumbersBBox() {
		solo.typeText(0, "2");
		solo.clickOnButton("+");
		solo.typeText(0, "2");
		solo.clickOnButton("=");
		
		
		if (solo.getText(1).toString() == "4.0") {
			fail();
		} else {
			
		}
	}
	
}
