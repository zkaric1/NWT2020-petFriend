package com.example.zivotinja.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.zivotinja.repository.BolestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("bolest")
@RestController
public class BolestController {
    @Autowired
    private BolestRepository bolestRepository;
}

