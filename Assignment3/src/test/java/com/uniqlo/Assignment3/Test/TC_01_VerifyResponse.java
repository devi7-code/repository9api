package com.uniqlo.Assignment3.Test;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.uniqlo.Assignment3.Methods.HttpMethods;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;


public class TC_01_VerifyResponse {
	HttpMethods method=new HttpMethods();	
	public static Logger logger=LogManager.getLogger(TC_01_VerifyResponse.class.getName());
	@BeforeMethod
	public void setUp() {
		BasicConfigurator.configure();
		logger.atLevel(Level.INFO);
		
	}
@Description("Verify the get response")	
@Step("Calling the get request api")
@Test(priority=1)
public void GetRequest() throws IOException {
	logger.info("Verifying Get Response");
	//calling http get request method
	Response res=method.httpGet();
	int statusCode=res.getStatusCode();
	//verifying status code
	Assert.assertEquals(200, statusCode);
	System.out.println("Response is:  "  +res.asString());
}
@Description("Verify the post response")
@Step("Calling the post request api")
@Test(priority=2)	
public void PostRequest() throws IOException {
	logger.info("Verifying Post Response");
	//calling http post request method
	Response res=method.httpPost();
	int statusCode=res.getStatusCode();
	//verifying status code
	Assert.assertEquals(200, statusCode);
	System.out.println("Response is:  "  +res.asString());
}
@Description("Verify the put response")	
@Step("Calling the put request api")
@Test(priority=3)	
public void PutRequest() throws IOException {
	logger.info("Verifying Put Response");
	//calling http put request method
	Response res=method.httpPut();
	int statusCode=res.getStatusCode();
	//verifying status code
	Assert.assertEquals(200, statusCode);
	System.out.println("Response is:  "  +res.asString());
}
@Description("Verify the delete response")	
@Step("Calling the delete request api")
@Test(priority=4)
public void DeleteRequest() throws IOException {
	logger.info("Verifying Delete Response");
	//calling http delete request method
	Response res=method.httpDelete();
	int statusCode=res.getStatusCode();
	//verifying status code
	Assert.assertEquals(200, statusCode);
	System.out.println("Response is:  "  +res.asString());
}

}
