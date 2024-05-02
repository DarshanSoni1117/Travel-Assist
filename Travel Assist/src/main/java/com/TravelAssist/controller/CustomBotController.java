package com.TravelAssist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.TravelAssist.dto.ChatGPTRequest;
import com.TravelAssist.dto.ChatGptResponse;
import com.TravelAssist.dto.PlanDto;

@RestController
public class CustomBotController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/plan-detail")
    public String chat(@RequestBody PlanDto plan){


    	String plan1="I am Planning for trip ,provide all the details as if you are an travel assistant "+"My desired location vacation is "+plan.getDestinationCity()
    	+"I am currently at "+plan.getStartCity()+" my perfered mode of transportation is "+plan.getModeOfTransportation()+" my start date and enddate are "+plan.getStartDate()+plan.getEndDate()
    	+" respectively , the number of people are "+ plan.getNumberOfPeople() +" my budget for this trip is in indian rupees "+plan.getBudget()+"plan provide me plan that will included the description of the places that the main tourist attraction , with little discription about them and the distance from the destinationn city in kilometers also the list of hotels avaiable in my budget, and also check if my budget realistic and if not than show the message about increasing my budget and how it will beneficial for me, "
    			+ "and also suggest what should be my realistic budget if the provided budget is not realistic, also provide the list of transportation available based my requested transportation ,always provide the name of hotel , and provide the details in json format and if flight is selected than provide flight details of vistara only";

    	ChatGPTRequest request=new ChatGPTRequest(model, plan1);
        ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }
}
