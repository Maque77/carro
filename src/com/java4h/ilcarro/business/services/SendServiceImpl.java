package com.java4h.ilcarro.business.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java4h.ilcarro.business.dto.Comment;
import com.java4h.ilcarro.business.dto.Message;
import com.java4h.ilcarro.business.entities.CarCommentEntity;
import com.java4h.ilcarro.business.entities.MessageEntity;
import com.java4h.ilcarro.business.entities.UserCommentEntity;
import com.java4h.ilcarro.business.entities.UserEntity;
import com.java4h.ilcarro.business.repositories.CarCommentJpaRepository;
import com.java4h.ilcarro.business.repositories.CarJpaRepository;
import com.java4h.ilcarro.business.repositories.MessageJpaRepository;
import com.java4h.ilcarro.business.repositories.UserCommentJpaRepository;
import com.java4h.ilcarro.business.repositories.UserJpaRepository;
import com.java4h.ilcarro.business.utilites.ModelMapper;

@Service
public class SendServiceImpl implements SendService {
	
	@Autowired
	ModelMapper modelMapper;
	
    @Autowired
    UserJpaRepository userRepository;
    
    @Autowired
    CarJpaRepository carRepository;
    
    @Autowired
    MessageJpaRepository messageRepository;

    @Autowired
    CarCommentJpaRepository carCommentRepository;

    @Autowired
    UserCommentJpaRepository userCommentRepository;

    
	// CAR COMMENTS:
	
	@Override
	public Comment createCarComment(Comment comment, String userId) {
		return modelMapper.convertToDto(
				carCommentRepository.save(modelMapper.convertToEntity(comment, carRepository.findById(userId).get())));
	}

	@Override
	public Iterable<Comment> getAllCarComments(String carId) {
		return carCommentRepository.findByReceiver(carRepository.findById(carId).get()).stream()
				.map(commentEntity -> modelMapper.convertToDto(commentEntity))
				.collect(Collectors.toList());
	}

	@Override
	public Comment editCarComment(int commId) {
		return modelMapper.convertToDto(carCommentRepository.findById(commId).get());
	}

	@Override
	public boolean deleteCarComment(int commId) {
		carCommentRepository.deleteById(commId);
		return true;
	}

	// USER COMMENTS:
	
	@Override
	public Comment createUserComment(Comment comment, String userId) {
		return modelMapper.convertToDto(
				userCommentRepository.save(modelMapper.convertToEntity(comment, userRepository.findById(userId).get())));
	}

	@Override
	public Iterable<Comment> getAllUserComments(String userId) {
		return userCommentRepository.findByReceiver(userRepository.findById(userId).get()).stream()
				.map(commentEntity -> modelMapper.convertToDto(commentEntity))
				.collect(Collectors.toList());
	}

	@Override
	public Comment editUserComment(int commId) {
		return modelMapper.convertToDto(userCommentRepository.findById(commId).get());
	}

	@Override
	public boolean deleteUserComment(int commId) {
		userCommentRepository.deleteById(commId);
		return true;
	}
	
	// MESSAGING:

	@Override
	public Message createMessage(Message message, String receiver) {
		return modelMapper.convertToDto(
				messageRepository.save(modelMapper.convertToEntity(message, userRepository.findById(receiver).get())));
	}

	@Override
	public Iterable<String> generateChatsList(String userId) {
		HashMap<String,LocalDateTime> chatListById = new HashMap<>();
		for(MessageEntity message : messageRepository.findAllBySender(userId))
			chatListById.put(message.getReceiver().getEmail(), message.getDatetime());
		for(MessageEntity message : messageRepository.findAllByReceiver(userId))
			if(message.getDatetime().isAfter( chatListById.get(message.getSender()) ))
			chatListById.put(message.getSender(), message.getDatetime());
		
		HashMap<LocalDateTime,String> chatListByDate = new HashMap<>();
		for(Map.Entry<String,LocalDateTime> entry : chatListById.entrySet()) chatListByDate.put(entry.getValue(), entry.getKey());

		ArrayList<String> arrayIds = new ArrayList<>();
		for(Map.Entry<LocalDateTime,String> entry : chatListByDate.entrySet()) arrayIds.add(0, entry.getValue());

		return arrayIds;
	}

	@Override
	public Iterable<Message> getLastMessages(String sender, String receiver) {
		// ???
		return null;
	}

	@Override
	public Iterable<Message> getAllMessages(String sender, String receiver) {
		return messageRepository.findAll().stream()
				.map(commentEntity -> modelMapper.convertToDto(commentEntity))
				.collect(Collectors.toList());
	}

	@Override
	public boolean makeMessageInvisible(int messId, String userId) {
		MessageEntity messageEntity = messageRepository.findById(messId).get();
		if(messageEntity.getSender().equals(userId)) messageEntity.setInvisibleFor(1);
		else if(messageEntity.getReceiver().getEmail().equals(userId)) messageEntity.setInvisibleFor(2);
		else return false;
		return true;
	}

	@Override
	public boolean makeChatInvisible(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
