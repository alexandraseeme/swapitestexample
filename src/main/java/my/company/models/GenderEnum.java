package my.company.models;

public enum GenderEnum {

    MALE("male"),
    FEMALE("female"),
    UNKNOWN("unknown"),
    NOT_AVAILABLE("n/a")
    ;

    private String paramValue;

    GenderEnum(String paramName) {
        this.paramValue = paramName;
    }

    public String getParamValue() {
        return this.paramValue;
    }

    @Override
    public String toString() {
        return paramValue;
    }
}
