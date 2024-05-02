package com.TravelAssist.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
	private String destinationCity;

	private String startCity;

	private double budget;


	private LocalDate startDate;


	private LocalDate endDate;

	private String modeOfTransport;

	private int numberOfPeoples;

	private List<String> attractions;

	private List<String> hotels;

	private List<String> transportation;
}
