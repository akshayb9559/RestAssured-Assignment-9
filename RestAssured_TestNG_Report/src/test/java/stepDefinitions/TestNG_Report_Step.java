package stepDefinitions;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestNG_Report_Step {

	Response response;
	
	@org.testng.annotations.DataProvider(name="Date")
	public Object[][] provider(){
		
		Object[][] data =new Object[2][3];
		
		data[0][0]="2025";
		data[0][1]="06";
		data[0][2]="13";
		
		data[1][0]="1999";
		data[1][1]="08";
		data[1][2]="08";
		return data;
	}
	
	@Test
	@Given("API for foreign exchange")
	public void api_for_foreign_exchange() {
		RestAssured.baseURI = "https://api.ratesapi.io";
	}

	@Test(dataProvider="Date")
	@When("posted with correct information")
	public void posted_with_correct_information(String year, String mon, String day) {
		response=RestAssured.get("/api/"+year+"-"+mon+"-"+day);
	}

	@Test
	@Then("validate positive response code received")
	public void validate_positive_response_code_received() {	
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		
		Assert.assertTrue(statusCode==200);
		Assert.assertFalse(statusCode!=200);
		
		String statusLine = response.getStatusLine();
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);	
	}

}
