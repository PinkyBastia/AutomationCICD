package rahulshettyacademy.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageObjects.CartPage;
import rahulshettyacademy.pageObjects.CheckOutPage;
import rahulshettyacademy.pageObjects.ProductCatalog;
import rahulshettyacademy.pageObjects.confirmationPage;

public class ErrorValidationsTest extends BaseTest {
	@Test(groups= {"ErrorHandling"})

	public void LoginErrorValidation() throws InterruptedException, IOException {

		String productName = "ZARA COAT 3";
		landingpage.loginApplication("pinky2bastia@gmail.com", "Spidergirl@1");
		AssertJUnit.assertEquals("Incorrect email or password.", landingpage.errorMessage());

	}

	@Test

	public void ProductErrorValidation() throws InterruptedException, IOException {

		String productName = "ZARA COAT 3";
		ProductCatalog productCatalog = landingpage.loginApplication("Nihar2samant@gmail.com", "Spidergirl@123");
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		CartPage cartpage = productCatalog.goTOCartPage();

		Boolean match = cartpage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}

}
