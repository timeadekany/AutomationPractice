package timeadekany.pet;

import io.restassured.RestAssured;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PetTests {
    private static Pet createdPet;
    private static String baseUrl = "https://petstore.swagger.io/v2/pet/";

    @Before
    public void setUp() {
        String file = "src/test/resources/pet/postPet.json";
        String json = readFileAsString(file);
        createdPet = postMethod(json);
    }

    @SneakyThrows
    public void convertJsonContentToJavaObjectTest() {
        ObjectMapper mapper = new ObjectMapper();
        Pet pet = mapper.readValue(new File("src/test/resources/pet/pet.json"), Pet.class);
    }

    @Test
    public void postTest() {
        getMethod(baseUrl + createdPet.getId(),200);
    }

    @Test
    public void putTest() {
        Pet givenPet = getMethod(baseUrl + createdPet.getId(), 200);

        String name = "testMentoring2020_" + System.currentTimeMillis();
        givenPet.setName(name);

        Pet updatedPet = RestAssured.
                given().
                body(givenPet).
                contentType("application/json; charset=UTF-8").
                when().
                put(baseUrl).
                then().
                log().ifError().
                assertThat().statusCode(200).
                extract().body().as(Pet.class);

        getMethod(baseUrl + updatedPet.getId(),200);
    }

    @Test
    public void deleteTest() {
        String deletedPetId = RestAssured.
                given().
                when().
                delete(baseUrl + createdPet.getId()).
                then().
                log().ifError().
                assertThat().statusCode(200).
                extract().body().jsonPath().getString("message");

        Assertions.assertEquals(createdPet.getId().toString(), deletedPetId);
        getMethod(baseUrl + createdPet.getId());
    }

    @SneakyThrows
    private static String readFileAsString(String file) {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    private Pet getMethod(String url, int responseCode) {
        return RestAssured.
                given().
                when().
                get(url).
                then().
                log().ifError().
                assertThat().statusCode(responseCode).
                extract().body().as(Pet.class);
    }

    private void getMethod(String url) {
        RestAssured.
                given().
                when().
                get(url).
                then().
                log().ifError().
                assertThat().statusCode(404);
    }

    private static Pet postMethod(String json) {
        return RestAssured.
                given().
                body(json).
                contentType("application/json; charset=UTF-8").
                when().
                post(baseUrl).
                then().
                log().ifError().
                assertThat().statusCode(200).
                extract().body().as(Pet.class);
    }
}

