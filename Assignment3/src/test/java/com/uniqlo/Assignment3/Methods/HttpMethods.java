package com.uniqlo.Assignment3.Methods;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import util.Datum;


import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniqlo.Assignment3.PropertyReader;
public class HttpMethods  {

	    PropertyReader prop =new PropertyReader();
	    public  static Datum readAllData() throws IOException {
	        ObjectMapper mapper=new ObjectMapper();
	    	Datum obj=mapper.readValue(new File("V:\\uniqlo\\Assignment3\\src\\test\\java\\testData\\data.json"), Datum.class);
	    	 return obj;
	        }
	    
//reading propertyfile
	    String GetRequestAPI=prop.getProperty("GetRequestAPI");
	    String PostRequestAPI=prop.getProperty("PostRequestAPI");
	    String PutRequestAPI=prop.getProperty("PutRequestAPI");
	    String DeleteRequestAPI=prop.getProperty("DeleteRequestAPI");
//getRequest
	    @Step("Calling the get request api")
	     public  Response httpGet() throws IOException {
	    	 System.out.println(readAllData().getUsername());
	 		System.out.println(readAllData().getPassword());
	        Response res = null;
	        System.out.println("GetRequest API"+GetRequestAPI);
	        try {
	                res = given().auth().basic(readAllData().getUsername(), readAllData().getPassword()).
	                		queryParam("foo1","bar1").queryParam("foo2", "bar2").
	                        log().all().
	                        when().
	                        get(GetRequestAPI);
	            
	            return res;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return res;
	        }
	    }
	    @Step("Calling the post request api")
	     public  Response httpPost() throws IOException {
	         
	         Response res = given().auth().basic(readAllData().getUsername(), readAllData().getPassword()).
	        		 header("Content-Type", "application/json").log().all().
	                         when().
	                         post(PostRequestAPI);
	         
	         return res;
	     }
	    @Step("Calling the put request api")
public  Response httpPut() throws IOException {
	         
	         Response res = given().auth().basic(readAllData().getUsername(),readAllData().getPassword()).
	        		 header("Content-Type", "application/json").log().all().
	                         when().
	                         put(PutRequestAPI);
	         
	         return res;
	     }
	    @Step("Calling the delete request api")
public  Response httpDelete() throws IOException {
    
    Response res = given().auth().basic(readAllData().getUsername(), readAllData().getPassword()).
   		 header("Content-Type", "application/json").log().all().
                    when().
                    delete(DeleteRequestAPI);
    
    return res;
}



}
