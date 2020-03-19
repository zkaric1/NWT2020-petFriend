package com.example.zivotinja.controller;

import com.example.zivotinja.repository.VeterinarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("veterinar")
@RestController
public class VeterinarController {
    @Autowired
    private VeterinarRepository veterinarRepository;
}
