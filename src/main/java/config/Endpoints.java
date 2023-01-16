package config;

public class Endpoints extends Hostname {

    public static final String GET_USERS = hostname("users");
    public static final String GET_USER = hostname("users/");
    public static final String CREATE_USER = hostname("users");
    public static final String UPDATE_USER = hostname("users/");
    public static final String DELETE_USER = hostname("users/");
    public static final String LOGIN = hostname("login");
    public static final String LOGOUT = hostname("logout");
    public static final String REGISTER_USER = hostname("register");
}
