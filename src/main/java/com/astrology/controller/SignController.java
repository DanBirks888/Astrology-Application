package com.astrology.controller;

import com.astrology.model.Sign;
import com.astrology.repo.SignRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/signs")
public class SignController {

    private SignRepository signRepository;

    public SignController(SignRepository signRepository) {
        this.signRepository = signRepository;
    }

    @GetMapping("/all")
    public List<Sign> getAll() {
        return this.signRepository.findAll();
    }

    @GetMapping("/zodiac/{zodiac}")
    public Sign getSignByZodiac(@PathVariable("zodiac") String zodiac) {
        return this.signRepository.findById(zodiac).orElseThrow();
    }

    @GetMapping("/element/{element}")
    public List<Sign> getSignByElement(@PathVariable("element") String element) {
        return this.signRepository.findByElement(element);
    }





}