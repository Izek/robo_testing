package com.LookHin.StackCalculator.test.APK;

import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class StackCalculatorTestAPK extends ActivityInstrumentationTestCase2 {

	private static final String TARGET_PACKAGE_ID = "com.LookHin.StackCalculator";
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.LookHin.StackCalculator.StackCalculator";

	private static Class<?> launcherActivityClass;
	static {
		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public StackCalculatorTestAPK() throws ClassNotFoundException {
		super(TARGET_PACKAGE_ID, launcherActivityClass);
	}

	private Solo solo;

	@Override
	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testActivityAppears() {
		solo.assertCurrentActivity("Correct activity did not appear.",
				launcherActivityClass);
	}

	public void testSummarizingOneAndOne() {

		solo.clickOnButton("1");

		solo.clickOnButton("+");

		solo.clickOnButton("1");

		solo.clickOnButton("=");
		solo.sleep(5000);

	}
}
