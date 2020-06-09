package com.java4h.ilcarro.business.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java4h.ilcarro.business.entities.MessageEntity;

public interface MessageJpaRepository extends JpaRepository<MessageEntity, Integer> {

	List<MessageEntity> findAllBySender(String sender);
	List<MessageEntity> findAllByReceiver(String receiver);

}
