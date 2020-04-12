package com.etf.korisnik_service.dto;

import java.util.HashMap;

public class MessageDto {
    String message;

    public MessageDto(String message) {
        this.message = message;
    }

    public HashMap<String,String> getHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", message);
        return map;
    }
}
