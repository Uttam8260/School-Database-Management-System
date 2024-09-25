package com.example.demo.utility;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {

	private int statusCode;
	private String msg;
	private T data;
	private LocalDateTime time;
}
