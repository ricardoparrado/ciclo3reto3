package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Machine;
import com.usa.ciclo3.ciclo3.model.Message;
import com.usa.ciclo3.ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message mess) {
        if (mess.getIdMessage() == null) {
            return messageRepository.save(mess);
        } else {
            Optional<Message> messageAuxiliar = messageRepository.getMessage(mess.getIdMessage());
            if (messageAuxiliar.isEmpty()) {
                return messageRepository.save(mess);
            } else {
                return mess;
            }
        }
    }

    public Message update(Message msup) {
        if (msup.getIdMessage() != null) {
            Optional<Message> messageAuxiliar = messageRepository.getMessage(msup.getIdMessage());
            if (messageAuxiliar.isPresent()) {
                if (msup.getMessageText() != null) {
                    messageAuxiliar.get().setMessageText(msup.getMessageText());
                }
                return messageRepository.save(messageAuxiliar.get());
            }
        }
        return msup;

    }

    public boolean deleteMessage(int id) {
        Optional<Message> messageAuxiliar = getMessage(id);
        if (messageAuxiliar.isPresent()) {
            messageRepository.delete(messageAuxiliar.get());
            return true;
        }
        return false;

    }

}
