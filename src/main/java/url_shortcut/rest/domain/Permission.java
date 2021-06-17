package url_shortcut.rest.domain;

public enum Permission {
    STATISTIC_READ("statistic:read"),
    URL_WRITE("url:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
