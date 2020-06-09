package com.java4h.ilcarro.business.services;

import org.springframework.stereotype.Service;

import com.java4h.ilcarro.business.dto.Comment;
import com.java4h.ilcarro.business.dto.Message;
import com.java4h.ilcarro.business.entities.CarCommentEntity;
import com.java4h.ilcarro.business.entities.MessageEntity;
import com.java4h.ilcarro.business.entities.UserCommentEntity;

@Service
public interface SendService {

	// Car comments:
	Comment createCarComment(Comment comment, String userId);
	Iterable<Comment> getAllCarComments(String carId);
	Comment editCarComment(int commId);
	boolean deleteCarComment(int commId);

	// User comments:
	Comment createUserComment(Comment comment, String userId);
	Iterable<Comment> getAllUserComments(String userId);
	Comment editUserComment(int commId);
	boolean deleteUserComment(int commId);

	// Messages:
	Message createMessage(Message message, String receiver);
	Iterable<String> generateChatsList(String userId);
	Iterable<Message> getLastMessages(String sender, String receiver);
	Iterable<Message> getAllMessages(String sender, String receiver);
//	Iterable<Message> getMessagesByKeyword(String sender, String receiver, String keyword);
//	Iterable<Message> getMessagesByKeyword(String sender, String keyword);
	boolean makeMessageInvisible(int messId, String userId);
	boolean makeChatInvisible(String userId);

}
