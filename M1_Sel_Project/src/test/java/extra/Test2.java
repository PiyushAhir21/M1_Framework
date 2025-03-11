package extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;

public class Test2 extends BaseClass {

	@Test
	public void test2() {
		Reporter.log("Test script 2", true);
	}
}
