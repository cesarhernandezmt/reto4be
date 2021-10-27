/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.service;


import co.usa.ciclo3.retos.model.Message;
import co.usa.ciclo3.retos.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int idMessage) {
        return messageRepository.getMessage(idMessage);
    }
    
    public Message save(Message message) {
        if(message.getIdMessage() == null) {
            return messageRepository.save(message);
        }
        else {
            Optional<Message> messageOptional = messageRepository.getMessage(message.getIdMessage());
            if(messageOptional.isEmpty()) {
                return messageRepository.save(message);
            }
            else {
                return message;
            }
        }
    }
    
    public Message update(Message message) {
        if(message.getIdMessage() != null) {
            Optional<Message> messageOptional = messageRepository.getMessage(message.getIdMessage());
            if(!messageOptional.isEmpty()) {
                if(message.getMessageText() != null) {
                    messageOptional.get().setMessageText(message.getMessageText());
                }
                if(message.getDoctor() != null) {
                    messageOptional.get().setDoctor(message.getDoctor());
                }
                if(message.getClient() != null) {
                    messageOptional.get().setClient(message.getClient());
                }
                messageRepository.save(messageOptional.get());
                return messageOptional.get();
            }
            else {
                return message;
            }
        }
        else {
            return message;
        }
    }
    
    public boolean deleteMessage(int idMessage) {
        Optional<Message> messageOptional = getMessage(idMessage);
        if(!messageOptional.isEmpty()) {
            messageRepository.delete(messageOptional.get());
            return true;
        }
        return false;
    }
    
}
