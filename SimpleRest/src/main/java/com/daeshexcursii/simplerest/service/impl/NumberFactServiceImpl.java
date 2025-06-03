package com.daeshexcursii.simplerest.service.impl;

import com.daeshexcursii.simplerest.dto.ViewNumberFactDTO;
import com.daeshexcursii.simplerest.model.NumberFact;
import com.daeshexcursii.simplerest.repository.NumberFactRepository;
import com.daeshexcursii.simplerest.service.NumberFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class NumberFactServiceImpl implements NumberFactService {

    @Autowired
    NumberFactRepository numberFActRepository;

    @Override
    public ViewNumberFactDTO getNumberFact(int number) {
        Optional<NumberFact> numberFactOpt = numberFActRepository.findByNumber(number);

        if (!numberFactOpt.isPresent()) {
            String fact = getNumberFactFromAPI(number).block();

            NumberFact numberFact = NumberFact.builder()
                    .number(number)
                    .fact(fact)
                    .build();

            numberFActRepository.save(numberFact);

            return ViewNumberFactDTO.from(numberFact);
        }

        NumberFact numberFact = numberFactOpt.get();

        return ViewNumberFactDTO.from(numberFact);
    }



    public Mono<String> getNumberFactFromAPI(int number) {
        WebClient client = WebClient.create();
        return client.get()
                .uri("http://numbersapi.com/" + number)
                .retrieve()
                .bodyToMono(String.class);
    }
}
