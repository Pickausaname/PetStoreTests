Feature: Pet endpoint provides CRUD functionality for pets

  @All
  Scenario: Add pet and check that it is present in the system
    When "POST" request with pet json is sent to "PET_RESOURCE" path
    Then Response code is 200
    And Response body is a same pet json
    When "GET" request is sent to PET_BY_ID_RESOURCE path
    Then Response code is 200
    And Response body is a same pet json

  @All @DeletePet @NeedsPet
  Scenario: Delete existing pet from application
    When "DELETE" request is sent to PET_BY_ID_RESOURCE path
    Then Response code is 200
    And "message" field in response equals to deleted petId
    When "GET" request is sent to PET_BY_ID_RESOURCE path
    Then Response code is 404
    And "message" field in response equals to "Pet not found"