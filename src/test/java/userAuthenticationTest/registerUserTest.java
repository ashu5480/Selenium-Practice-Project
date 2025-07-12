package userAuthenticationTest;

import org.testng.annotations.Test;

import basePackage.baseClass;
import userAuthentications.registerUser;

public class registerUserTest extends baseClass {

	public registerUserTest() {
		super();
	}
	
	registerUser registeruser;
	
	@Test
	public void signUP() {
		registeruser = new registerUser();
		registeruser.signUpUser();
	}
}
