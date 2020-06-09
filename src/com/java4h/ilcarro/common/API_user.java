package com.java4h.ilcarro.common;

public class API_user {

    //UserAPI
    public static final String USER = "/user";


    //unregistering user

    //registration
    public static final String SING_UP = "/SingUp"; //POST request for registration
    public static final String SING_IN = "/SingIn"; //POST request for enter to account



    //unregistering user and registered user

    //search
    public static final String GET_ALL_USERS = "/getAllUsers";
    public static final String GET_USERS_BY_FORM = "/getUsersByForm"; //Multiple filter TODO
    public static final String GET_ALL_CARS = "/getAllCars";
    public static final String GET_CARS_BY_FORM = "/getCarsByForm"; //Multiple filter TODO

    //view user
    public static final String GET_USER_BY_EMAIL= "/getUserByEmail";
    public static final String GET_CARS_BY_USER = "/getCarsByEmail";

    //view car
    public static final String GET_CAR_BY_REGISTRATION_NUMBER = "/getCarByRegistrationNumber";



    //only registering user

    //basic operations
    public static final String SING_OUT = "/singOutByEmail";
    public static final String EDIT_ACCOUNT = "/editAccountByEmail";
    public static final String DELETE_ACCOUNT = "/deleteAccountByEmail";
    public static final String CHANGE_PASSWORD = "/editPasswordByEmail";
    public static final String CHANGE_STATUS_ACCOUNT = "/changeStatusAccountByEmail";

    //car operations
    public static final String ADD_ACCOUNT_CAR = "/addCarByEmail";
    public static final String GET_ACCOUNT_CARS = "/getAllCarsByEmail";
    public static final String GET_ACCOUNT_CAR = "/getCarByRegistrationNumber";
    public static final String EDIT_ACCOUNT_CAR = "/editCarByRegistrationNumber";
    public static final String DELETE_ACCOUNT_CAR = "/deleteCarByRegistrationNumber";

    //message operations
    public static final String GET_ACCOUNT_CHATS = "/getChatsByEmail";
    public static final String GET_MESSAGES_BY_CHAT = "/getMessagesByChatId";
    public static final String DELETE_CHAT = "/deleteChatByChatId";
    public static final String DELETE_MESSAGE = "/deleteMessageByMessageId";

    //rent operations
    public static final String CHANGE_STATUS_CAR = "/changeStatusCarByRegistrationNumber";
    public static final String GET_ACCOUNT_RENT_CARS = "/getRentCarsByEmail";

    //basket operations
    public static final String GET_BASKET_ACCOUNT = "/getBasketByEmail";
    public static final String ADD_CAR_TO_BASKET = "/addCarToBasketByBasketID";
    public static final String DELETE_CAR_IN_BASKET = "/DeleteCarInBasketId";

    //comment operations
    public static final String GET_COMMENTS_ACCOUNT = "/getCommentsAccountByEmail";
    public static final String GET_COMMENTS_CAR = "/getCommentsCarByRegistrationNumber";
    public static final String GET_COMMENT = "/getCommentByCommentId";
    public static final String EDIT_COMMENT = "/editCommentByCommentId";
    public static final String ADD_COMMENT_USER = "/addCommentUserByEmail";
    public static final String ADD_COMMENT_CAR = "/addCommentCarByRegistrationNumber";
    public static final String DELETE_COMMENT = "/deleteCommentId";
    public static final String GET_NEWS_ACCOUNT = "/getAllCommentsByEmail";

}
