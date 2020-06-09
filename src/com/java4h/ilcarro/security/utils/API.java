package com.java4h.ilcarro.security.utils;

public class API { // TODO combine to common package?
	
	// Basic
	
	public static final String SECURITY = "/security";
		
	public static final String ADD_USER = "/addUser";
	public static final String ADD_ACCOUNT = "/addAccount";
	public static final String CREATE_ROLE = "/createRole";
	public static final String GRANT_ROLE = "/grantRole";
	public static final String DEPRIVE_ROLE = "/depriveRole";
	public static final String GET_ALL_ACCOUNTS = "/getAllAccounts";
	public static final String GET_ACCOUNTS_BY_ROLE = "/depriveRole";
	public static final String GET_ALL_ROLES = "/getAllRoles";
	public static final String GET_ROLES_BY_LOGIN = "/getRolesByLogin";
	public static final String REMOVE_ACCOUNT = "/removeAccount";
	public static final String REMOVE_USER = "/removeUser";

	//User
	public static final String USER = "/user";

	public static final String GET_USER_BY_LOGIN = "/getUserByLogin";
	public static final String UPDATE_USER_BY_LOGIN = "/updateUserByLogin";
	public static final String GET_CARS_BY_LOGIN = "/getCarsByUser"; //te, chto sdaet v arendu
	public static final String SELECTED_TO_RENT_BY_LOGIN = "/getSelectedCarsByUser";//te, chto otobral v korzinu
	public static final String GET_COMMENTS_BY_LOGIN = "/getCommentsByLogin";
	public static final String SEND_MESSAGE_BY_LOGIN = "/sendMessageByLogin";;
	
	
	// JWT
	
	public static final String JWT = "/jwt";
	
	public static final String AUTHENTICATE = "/authenticate";
			
	// Business
	
	public static final String BUSINESS = "/business";
	
	public static final String ADD_CAR = "/addCar";
	public static final String GET_ALL_CARS = "/getAllCars";
	
}
