package com.qualityhouse.serenity.page_objects.utils;

public enum ExtrasEnum {
    AIR_CONDITIONER("[for='filterItem-checkbox-amenities-5']"),
    HOT_TUB("[for='filterItem-checkbox-amenities-25']");

    private String value;

    ExtrasEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
