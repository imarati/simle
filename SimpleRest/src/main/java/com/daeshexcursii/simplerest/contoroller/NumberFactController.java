package com.daeshexcursii.simplerest.contoroller;

import jakarta.validation.constraints.Min;
import com.daeshexcursii.simplerest.dto.ViewNumberFactDTO;
import com.daeshexcursii.simplerest.service.NumberFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NumberFactController {

    @Autowired
    NumberFactService numberFactService;

    @GetMapping("/api/v1/numfact/{number}")
    public ResponseEntity<ViewNumberFactDTO> getNumFact(@PathVariable @Min(1) int number) {
        ViewNumberFactDTO viewNumberFactDTO = numberFactService.getNumberFact(number);
        return ResponseEntity.ok(viewNumberFactDTO);
    }
}
