package extra;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners_utility.ListImp.class)
public class Test1 {

	@Test
	public void createOrgTest() {
		Assert.assertTrue(false);
	}
}
