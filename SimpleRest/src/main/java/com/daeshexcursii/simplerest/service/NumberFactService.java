package com.daeshexcursii.simplerest.service;

import com.daeshexcursii.simplerest.dto.ViewNumberFactDTO;

public interface NumberFactService {
    public ViewNumberFactDTO getNumberFact(int number);
}
