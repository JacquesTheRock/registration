package me.jbreaux.register;

import me.jbreaux.register.Validation;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;


public class ValidationTest {
	@Test
	public void ZipCodeTest() {
		String usRegex = "[0-9]{5}([- ][0-9]{4})?";
		String goodZips[] = {"12345","12345-6789","12345 6789"};
		String badZips[] = {"1234","abc45","12345_6789","12345-"};
		Validation v = new Validation();
		v.setZipRegex(usRegex);//Set the test regex to US
		for(int i = 0; i < goodZips.length; i++) {
			assertTrue("Valid Zip (" + goodZips[i] + ") evaluated as invalid", v.isValidZip(goodZips[i]));
		}
		for(int i = 0; i < badZips.length; i++) {
			assertFalse("Invalid Zip (" + badZips[i]+ ") evaluated as valid", v.isValidZip(badZips[i]));
		}

	}
}