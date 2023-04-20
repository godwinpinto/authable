package com.github.godwinpinto.authable.commons.constants;

public final class ApplicationConstants {

    private ApplicationConstants() {
    }

    public enum RecordStatus {
        ACTIVE("A"),
        DISABLED("D"),
        INACTIVE("N");

        private String value;

        RecordStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

    }

    public static final String JWT_ROLE_KEY = "role";

    public static final String JWT_SYSTEM_ID_KEY = "systemId";
    public static final String DB_PAD_CHAR = "-";

    public static final String SECRET_SEPARATOR = "|";

}
