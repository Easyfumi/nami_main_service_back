package ru.marinin.namiBackService.exception.notfound;

public class RoleNotFoundException extends ElementNotFoundException{
    public RoleNotFoundException(String value) {
        super("Role", value);
    }
}
