package com.java4h.ilcarro.common;

public class API_commentsMessages {

	// Car commenting:
	public static final String CREATE_CAR_COMMENT = "/createCarComment";
	public static final String GET_ALL_CAR_COMMENTS = "/getAllCarComments";
	public static final String EDIT_CAR_COMMENT = "/editCarComment";
	public static final String DELETE_CAR_COMMENT = "/deleteCarComment";

	// User commenting:
	public static final String CREATE_USER_COMMENT = "/createUserComment";
	public static final String GET_ALL_USER_COMMENTS = "/getAllUserComments";
	public static final String EDIT_USER_COMMENT = "/editUserComment";
	public static final String DELETE_USER_COMMENT = "/deleteUserComment";

	// Messaging:
	public static final String CREATE_MESSAGE = "/createMessage";
	public static final String GENERATE_CHATS_LIST = "/generateChatsList";
	public static final String GET_LAST_MESSAGES = "/getLastMessages";
	public static final String GET_ALL_MESSAGES = "/getAllMessages";
	public static final String GET_MESSAGES_BY_KEYWORD = "/getMessagesByKeyword";  // to do over the front-end?
	public static final String MAKE_MESSAGE_INVISIBLE = "/makeMessageInvisible";   // delete specified message
	public static final String MAKE_CHAT_INVISIBLE = "/makeChatInvisible";         // delete chat with user

}
