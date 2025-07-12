package userAuthenticationTest;

import org.testng.annotations.Test;

import basePackage.baseClass;
import userAuthentications.loginUser;

public class loginUserTest extends baseClass{

	public loginUserTest() {
		super();
	}
	
	loginUser loginusr;
	
	@Test
	public void loginUsers() {
		loginusr = new loginUser();
		loginusr.login();
	}
}
