package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AvailabilityTestPage {
	WebDriver driver;

	public AvailabilityTestPage(WebDriver driver) {
		this.driver = driver;
	}

	// Library of Elements

	@FindBy(how = How.XPATH, using = "//span[@class='sc-32axb7-1 Mgpyg']/descendant::a[@data-test='quick-links-availability-link']")
	WebElement ViewAvailabilityLink;

	public void clickOnViewAvailabilityLink() {
		ViewAvailabilityLink.click();
	}

	public List<String> getColumnDataFor(String columnHeader) {
		List<String> list = new ArrayList<String>();
		int index = getColumnHeaderFor(columnHeader);
		List<WebElement> columnDataElements = driver.findElements(
				By.xpath("//div[@class='unsyox-1 jWvYsE']/descendant::div[@class='cuhhzo-2 dYUqPl'][" + index + "]"));
		for (int i = 0; i < columnDataElements.size(); i++) {
			list.add(i, columnDataElements.get(i).getText());
		}
		return list;
	}

	private int getColumnHeaderFor(String columnHeader) {
		String xpath = "//div[@class='unsyox-1 jWvYsE']/descendant::div[@class='cuhhzo-0 fyKuoz']";
		List<WebElement> columnHeaderElements = driver.findElements(By.xpath(xpath));
		for (int i = 0; i < columnHeaderElements.size(); i++) {
			if (columnHeaderElements.get(i).getText().equalsIgnoreCase(columnHeader)) {
				return i + 1;
			}
		}
		return 0;
	}

}
