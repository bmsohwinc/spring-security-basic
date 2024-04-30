package com.bms.simauth.service;

import com.bms.simauth.domain.Message;
import com.bms.simauth.domain.MessageDTO;
import com.bms.simauth.repository.MessageRepository;
import com.bms.simauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    private final UserRepository userRepository;

    public Integer saveMessage(MessageDTO messageDTO) {
        Message message = new Message();

        message.setMessage(messageDTO.getMessage());
        message.setCreatedDate(LocalDateTime.now());

        final String currentUserName = getCurrentUsername();
        message.setUser(userRepository.findByUsername(currentUserName).get());

        Message savedMessage = messageRepository.save(message);
        return savedMessage.getMessageId();
    }

    public List<MessageDTO> getMessages() {
        final String currentUserName = getCurrentUsername();
        List<Message> messages = messageRepository.findByUser(userRepository.findByUsername(currentUserName).get());
        List<MessageDTO> dtos = messages.stream()
                .map(message -> {
                    MessageDTO dto = new MessageDTO();
                    dto.setMessage(message.getMessage());
                    return dto;
                }).toList();
        return dtos;
    }

    private String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
