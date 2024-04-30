package com.bms.simauth.controller;

import com.bms.simauth.domain.MessageDTO;
import com.bms.simauth.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class SimauthCore {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<Integer> saveMessage(@RequestBody MessageDTO messageDTO) {
        return ResponseEntity.ok(messageService.saveMessage(messageDTO));
    }

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getMessages() {
        return ResponseEntity.ok(messageService.getMessages());
    }

}
