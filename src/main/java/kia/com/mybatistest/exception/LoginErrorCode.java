package kia.com.mybatistest.exception;

public enum LoginErrorCode {

    NotAuthroized(6000, "not authorized"),
    DuplicateIdFound(6001, "Duplicate Id"),
    unrecognizedRole(6010, "unrecognized Role");
    private int code;
    private String description;

    private LoginErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
