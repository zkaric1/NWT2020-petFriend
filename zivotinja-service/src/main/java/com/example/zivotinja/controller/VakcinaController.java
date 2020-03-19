package com.example.zivotinja.controller;

import com.example.zivotinja.repository.VakcinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("vakcina")
@RestController
public class VakcinaController {
    @Autowired
    private VakcinaRepository vakcinaRepository;
}
