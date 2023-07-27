package com.douzon.smartlogistics.domain.entity.constant;

public enum State {

    WAIT("WAIT"),
    ING("ING"),
    CMP("CMP");

    private final String code;

    State(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static State find(String code) {
        for (State customerType : State.values()) {
            if (customerType.code.equals(code)) {
                return customerType;
            }
        }
        return null;
    }
}
