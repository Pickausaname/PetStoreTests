package StepDefinitions;

import io.cucumber.java.Before;

import java.io.FileNotFoundException;


public class Hooks {

    @Before("@NeedsPet")
    public void createPetIfNull() throws FileNotFoundException {
        if (PetStepDefs.pet==null) {
            PetStepDefs petStepDefs = new PetStepDefs();
            petStepDefs.requestWithPetJsonIsSentToPath("POST","PET_RESOURCE");
        }
    }
}
