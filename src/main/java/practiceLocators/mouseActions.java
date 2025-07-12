package practiceLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.baseClass;

public class mouseActions extends baseClass {

	public mouseActions() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="textbox")
	WebElement forhower;
	
	@FindBy(id="dblclick")
	WebElement dblclick;
	
	@FindBy(id="rightclick")
	WebElement rightClick;
	
	@FindBy(id="draggableElement")
	WebElement dragElement;
	
	@FindBy(id="droppableElement")
	WebElement droppableElement;
	
	Actions act = new Actions(driver);
	
	public void mouseHower() {
		act.moveToElement(forhower).sendKeys("Ashu").perform();
		System.out.println("Mouse is hovered");
		
	}
	
	public void rightClick() {
		act.contextClick(rightClick).perform();
		System.out.println("Clicked right");
	}
	
	public void dragDrop() {
		act.dragAndDrop(dragElement, droppableElement).perform();
		System.out.println("Drag and drop performed");
	}
	
	public void doubliClick() {
		act.doubleClick(dblclick).perform();
		System.out.println("Performed Double click");
	}
	
	
}
