package com.daeshexcursii.simplerest.dto;

import com.daeshexcursii.simplerest.model.NumberFact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewNumberFactDTO {
    private int number;
    private String fact;

    public static ViewNumberFactDTO from(NumberFact numberFact) {
        return ViewNumberFactDTO.builder()
                .number(numberFact.getNumber())
                .fact(numberFact.getFact())
                .build();
    }

    public static List<ViewNumberFactDTO> from(List<NumberFact> numberFacts) {
        return numberFacts.stream()
                .map(ViewNumberFactDTO::from)
                .collect(Collectors.toList());
    }
}
