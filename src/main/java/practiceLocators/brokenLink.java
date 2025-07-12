package practiceLocators;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basePackage.baseClass;

public class brokenLink extends baseClass {

	public brokenLink() {
		PageFactory.initElements(driver, this);
	}
	
	public void brokenLinkTest() throws IOException {
		List<WebElement> listLink = driver.findElements(By.tagName("a"));
		for(WebElement lists : listLink) {
			String URL = lists.getAttribute("href");
			verifyLink(URL);
		}
	}
	
	public void brokenLinkImage() throws IOException {
		List<WebElement> listImageLink = driver.findElements(By.tagName("img"));
		for(WebElement listImange : listImageLink) {
			String URl = listImange.getAttribute("src");
			verifyLink(URl);
		}
	}
	
	public void verifyLink(String URL) throws IOException {
		try {
			URL link = new URL(URL);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();
			
			if(httpURLConnection.getResponseCode() == 200) {
				System.out.println(URL+" : "+httpURLConnection.getResponseMessage());
			}
			else {
				System.out.println("Broken URL : "+URL+"-"+httpURLConnection.getResponseMessage());
			}
			
		} catch (MalformedURLException e) {
			System.out.println(URL+"-"+" Broken links");
		}
	}
}
