package StepDefinitions;

import POJOs.Category;
import POJOs.Pet;
import Resources.DataUtils;
import Resources.PetResourcesEnum;
import Resources.Specifications;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStepDefs {

    static Pet pet;
    long petId;
    ValidatableResponse response;

    @When("{string} request with pet json is sent to {string} path")
    public void requestWithPetJsonIsSentToPath(String requestType, String resourcesPath) throws FileNotFoundException {
        pet = DataUtils.createPetObjectWithRandomData();
        String path = PetResourcesEnum.valueOf(resourcesPath).getResourcePath();
        RequestSpecification requestSpecification = Specifications.getRequestSpecificationForWriteOperations();

        RequestSpecification requestSpec = given().spec(requestSpecification).body(pet);
        switch (requestType) {
            case ("POST"):
                response = requestSpec.when().post(path).then();
                break;
            case ("PUT"):
                response = requestSpec.when().put(path).then();
                break;
            default:
                System.out.println("Request type wasn't recognized");
        }
    }

    @Then("Response code is {int}")
    public void responseCodeIs(int expectedResponseCode) {
        response.assertThat().statusCode(expectedResponseCode);
    }

    @And("Response body is a same pet json")
    public void responseBodyIsPetJson() {
        Pet petInResponse = response.extract().body().as(Pet.class);
        Assert.assertEquals(petInResponse, pet);
    }

    @And("{string} request is sent to PET_BY_ID_RESOURCE path")
    public void requestIsSentToPath(String method) throws FileNotFoundException {
        petId=pet.getId();
        String path = PetResourcesEnum.valueOf("PET_BY_ID_RESOURCE").getResourcePath();
        RequestSpecification requestSpecification = given().spec(Specifications.getBasicRequestSpecification())
                .pathParam("petId", petId);
        switch (method) {
            case ("GET"):
                response = requestSpecification.when().get(path).then();
                break;
            case ("DELETE"):
                response = requestSpecification.when().delete(path).then();
                break;
            default:
                System.out.println("Request type wasn't recognized");
        }
    }

    @And("{string} field in response equals to deleted petId")
    public void fieldInResponseEqualsToDeletedPetId(String fieldName) {
        response.body(fieldName, equalTo(""+petId));
    }

    @And("{string} field in response equals to {string}")
    public void fieldInResponseEqualsTo(String fieldName, String expectedValue) {
        response.body("message", equalTo(expectedValue));
    }
}
