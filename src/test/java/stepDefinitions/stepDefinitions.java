package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.location;
import pojo.addPlaceAPI;
import resources.testDataBuild;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
public class stepDefinitions {

    //RequestSpecification req;
    ResponseSpecification resSpec;
    Response response;
    RequestSpecification res;
    //String r;

    // Create an object for testDataBuild class to be able to access it
    testDataBuild data = new testDataBuild();


    @Given("^Add Place Payload is available$")
    public void add_place_payload_is_available() throws Throwable {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        // Save the request to a variable
        RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).build();
        // Generalise and separate the response check
        resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        res = given().spec(req).body(data.addPlacePayLoad());
        //System.out.println("hi" +res);

    }

    @When("^User calls AddPlaceAPI with Post http request$")
    public void user_calls_addplaceapi_with_post_http_request() throws Throwable {
        response = res.when().post("/maps/api/place/add/json")
                .then().spec(resSpec).extract().response();

        JsonPath js = new JsonPath(response.asString());
        System.out.println(js.get("place_Id"));
        //System.out.println(response.asString());

        //throw new PendingException();
    }

    @Then("^The API call is sucessful with status code (\\d+)$")
    public void the_api_call_is_sucessful_with_status_code_200(int arg0) throws Throwable {
        //assertEquals(response.getStatusCode(),200);
        //throw new PendingException();
    }


    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void inResponseBodyIs(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //String resp = response.asString();
        //System.out.println(resp);
       // JsonPath js = new JsonPath(resp);
      // String status = js.get("status");
       // System.out.println(status);
       // assertEquals(status, arg1);
        //assertEquals(js.getString(arg0), arg1);
        //throw new PendingException();
    }
}