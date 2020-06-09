package com.java4h.ilcarro.business.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@Builder

public class Comment {
	
	private Integer id;
	private LocalDateTime datetime;
	private String sender;
//	private String receiver;
	private String text;

}
