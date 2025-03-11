package extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;

public class Test1 extends BaseClass {

	@Test
	public void test1() {
		Reporter.log("Test script", true);
	}

}
