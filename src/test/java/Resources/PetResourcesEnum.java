package Resources;

public enum PetResourcesEnum {
    PET_RESOURCE("/pet"),
    PET_BY_ID_RESOURCE("/pet/{petId}"),
    PET_IMAGE_RESOURCE("/pet/{petId}/uploadImage"),
    PETS_BY_STATUS("/pet/findByStatus");

    final String resourcePath;

    PetResourcesEnum(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getResourcePath() {
        return resourcePath;
    }


}
