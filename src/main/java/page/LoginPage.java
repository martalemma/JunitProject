package page;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
//	webElement list
	@FindBy(how = How.CSS,using = "input[name='data']")WebElement Add_List_Box_Element;
	@FindBy(how = How.CSS,using = "input[value='Add']")WebElement Add_List_Button_Element;
	@FindBy(how = How.CSS,using = "input[name='allbox']")WebElement Toggle_All_Element;
	@FindBy(how = How.CSS,using = "input[name='todo[0]']")WebElement Single_CheckBox_Element;
	@FindBy(how = How.CSS,using = "input[value='Remove']")WebElement Remove_Button_Element;
	

//	Corresponding method
	public void addList() {
		clickToggleAllBox();
		clickRemoveButton();
		for(int i=1; i< 8; i++ ) {
			Add_List_Box_Element.sendKeys("test"+i);
			Add_List_Button_Element.click();
		}
	}
	public void clickToggleAllBox() {
		
		Toggle_All_Element.click();
	}
	
	public void validateAllCheckBoxAreChecked(){
		clickToggleAllBox();
		
	String firstX_path	= "//input[@name='todo[";
	String secondX_path = "]']";
		
		for(int i=1; i<7; i++) {
		WebElement chechBoxes = driver.findElement(By.xpath(firstX_path + i + secondX_path));
		
			if(chechBoxes.isSelected()){
                System.out.println("checkBox " + i + " is selected");
                
				}else {
					System.out.println("checkBox " + i + " is not selected");
				}
			}
	}
	
	public void validateSingleListItemIsRemoved() {
		int listItem = driver.findElements(By.xpath("//li[@style ='font-size: 16px']")).size();
		System.out.println("list Item Count Before remove "+ listItem);
		clickToggleAllBox();
		Single_CheckBox_Element.click();
		clickRemoveButton();
		int listItem2 = driver.findElements(By.xpath("//li[@style ='font-size: 16px']")).size();
		System.out.println("list Item Count After remove "+ listItem2);
		
	}
	public void validateAllListItemAreRemoved() {
		clickToggleAllBox();
		clickRemoveButton();
		
		int listItem = driver.findElements(By.xpath("//li[@style ='font-size: 16px']")).size();
		System.out.println("All List Item removed Count "+listItem);
		if(listItem >0) {
			System.out.println("List item is present");
		}else {
			System.out.println("List item is not present");
		}
	}
	public void clickRemoveButton() {
		
		Remove_Button_Element.click();
	}
}
