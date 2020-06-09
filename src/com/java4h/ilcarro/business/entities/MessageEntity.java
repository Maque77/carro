package com.java4h.ilcarro.business.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@Builder
@Entity
@Table(name="messages")
public class MessageEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private LocalDateTime datetime;
	private String sender;
	@ManyToOne
	private UserEntity receiver;
	@Column(columnDefinition = "TEXT")
	private String text;
	private boolean readed = false;
	private int invisibleFor = 0;   // 0: visible for all; 1: invisible for sender; 2: invisible for receiver; 3: invisible for all.

}
