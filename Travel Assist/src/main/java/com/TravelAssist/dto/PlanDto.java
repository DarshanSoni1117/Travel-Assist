package com.TravelAssist.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlanDto {

	private String destinationCity;
	private String startCity;
	private String modeOfTransportation;
	private double budget;
	private LocalDate startDate;
	private LocalDate endDate;
	private int numberOfPeople;

}
