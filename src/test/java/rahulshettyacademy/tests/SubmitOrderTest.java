package rahulshettyacademy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageObjects.CartPage;
import rahulshettyacademy.pageObjects.CheckOutPage;
import rahulshettyacademy.pageObjects.LandingPage;
import rahulshettyacademy.pageObjects.OrderPage;
import rahulshettyacademy.pageObjects.ProductCatalog;
import rahulshettyacademy.pageObjects.confirmationPage;
import java.util.HashMap;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubmitOrderTest extends BaseTest {
	// String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {

		ProductCatalog productCatalog = landingpage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(input.get("productName"));
		CartPage cartpage = productCatalog.goTOCartPage();

		Boolean match = cartpage.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.goToCheckOut();
		checkoutpage.selectCountry("india");
		confirmationPage confirmationpage = checkoutpage.submitOrder();
		String confirmMessage = confirmationpage.getConfirmMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	// to verify Zara Coat 3 is displaying in orders page
	/*
	 * @Test(dependsOnMethods= {"submitOrder"}) public void orderHistoryTest() {
	 * ProductCatalog productCatalog =
	 * landingpage.loginApplication("pinky2bastia@gmail.com", "Spidergirl@12");
	 * OrderPage orderPage = productCatalog.goToOrdersPage();
	 * Assert.assertTrue(orderPage.VerifyOrderDisplay(productName)); }
	 */
	

	@DataProvider
	public Object[][] getData() throws IOException {

		/*
		 * List<HashMap<String, String>> data = getJsonDataToMap(
		 * System.getProperty("user.dir") +
		 * "//src//test//java//rahulshettyacademy//data//PurchaseOrder.json"); return
		 * new Object[][] { { data.get(0) }, { data.get(1) } };
		 */

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "pinky2bastia@gmail.com");
		map.put("password", "Spidergirl@12");
		map.put("productName", "ZARA COAT 3");

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "Nihar2samant@gmail.com");
		map1.put("password", "Spidergirl@123");
		map1.put("productName", "IPHONE 13 PRO");

		return new Object[][] { { map }, { map1 } };
	}

	/*
	 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
	 * "pinky2bastia@gmail.com"); map.put("password", "Spidergirl@12");
	 * map.put("productName", "ZARA COAT 3");
	 * 
	 * HashMap<String, String> map1 = new HashMap<String, String>();
	 * map1.put("email", "Nihar2samant@gmail.com"); map1.put("password",
	 * "Spidergirl@123"); map1.put("productName", "IPHONE 13 PRO");
	 * 
	 * return new Object[][] { {map}, {map1} };
	 */

}
