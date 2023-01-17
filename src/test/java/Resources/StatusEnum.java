package Resources;

public enum StatusEnum {

    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    final String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
