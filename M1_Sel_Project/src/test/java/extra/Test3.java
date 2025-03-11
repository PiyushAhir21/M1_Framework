package extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;

public class Test3 extends BaseClass {

	@Test
	public void test3() {
		Reporter.log("Test script", true);
	}

}
