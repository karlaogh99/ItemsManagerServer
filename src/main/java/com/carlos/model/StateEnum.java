package com.carlos.model;

public enum StateEnum {
    Active(1, "Active"),
    Discontinued(2, "Discontinued");
    Integer val;
    String valStr;

    StateEnum(Integer iVal, String valStr) {
        val = iVal;
        this.valStr = valStr;
    }
    public String getStringRep() {
        return valStr;
    }

    public Integer asInteger() {
        return val;
    }
    public static StateEnum get(Integer id) {
        for(StateEnum e : values()) {
            if(e.val.equals(id))
                return e;
        }
        return null;
    }
}
