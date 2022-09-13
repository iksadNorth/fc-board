package me.iksadnorth.board.type;

import lombok.Getter;

public enum RoleType {
    USER("ROLE_USER");

    @Getter
    private final String name;

    RoleType(String name) {
        this.name = name;
    }

    public static Boolean isContained(String name) {
        for (RoleType type : RoleType.values()) {
            if (type.name().equals(name)) return true;
        } return false;
    }
}
