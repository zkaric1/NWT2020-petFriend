package com.example.zivotinja.controller;

import com.example.zivotinja.repository.ZivotinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("zivotinja")
@RestController
public class ZivotinjaController {
    @Autowired
    private ZivotinjaRepository zivotinjaRepository;
}
