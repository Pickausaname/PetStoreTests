package Resources;

public enum StoreResourcesEnum {
    STORE_RESOURCE("/store/order"),
    ORDER_BY_ID_RESOURCE("/store/order/{orderId}"),
    INVENTORY_RESOURCE("/store/inventory");

    final String resourcePath;

    StoreResourcesEnum(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getResourcePath() {
        return resourcePath;
    }


}
