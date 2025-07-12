package practiceLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.baseClass;

public class SiblingAncestorsFollowings extends baseClass {

	public SiblingAncestorsFollowings() {
		PageFactory.initElements(driver, this);
	}

	
	//Following sibling
	@FindBy(xpath="//label[@for='radio1']/following-sibling::label")
	WebElement followingSib;
	
	//preceeding sibling
	@FindBy(xpath="//label[@for='radio2']/preceding-sibling::label")
	WebElement precedingSibling;
	
	//ancestor
	@FindBy(xpath="//input[@id='name']/ancestor::fieldset[@class='pull-right']")
	WebElement ancestor1;
	
	//Following
	@FindBy(xpath="//label[@for='bmw']/following::label[1]")
	WebElement following1;
	
	//descendent
	@FindBy(xpath="//div[@id='radio-btn-example']/descendant::fieldset")
	WebElement descendent1;
	
	@FindBy(xpath="//div[@id='radio-btn-example']/child::fieldset")
	WebElement child1;
	
	public void sibkingGet() {
		
      
}

}
