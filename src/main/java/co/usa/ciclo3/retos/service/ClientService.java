/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.service;


import co.usa.ciclo3.retos.model.Client;
import co.usa.ciclo3.retos.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int idClient) {
        return clientRepository.getClient(idClient);
    }
    
    public Client save(Client client) {
        if(client.getIdClient() == null) {
            return clientRepository.save(client);
        }
        else {
            Optional<Client> clientOptional = clientRepository.getClient(client.getIdClient());
            if(clientOptional.isEmpty()) {
                return clientRepository.save(client);
            }
            else {
                return client;
            }
        }
    }    

    public Client update(Client client) {
        if(client.getIdClient() != null) {
            Optional<Client> clientOptional = clientRepository.getClient(client.getIdClient());
            if(!clientOptional.isEmpty()) {
                if(client.getEmail() != null) {
                    clientOptional.get().setEmail(client.getEmail());
                }
                if(client.getPassword() != null) {
                    clientOptional.get().setPassword(client.getPassword());
                }
                if(client.getName() != null) {
                    clientOptional.get().setName(client.getName());
                }
                if(client.getAge() != null) {
                    clientOptional.get().setAge(client.getAge());
                }
                clientRepository.save(clientOptional.get());
                return clientOptional.get();
            }
            else {
                return client;
            }
        }
        else {
            return client;
        }
    }
    
    public boolean deleteClient(int idClient) {
        Optional<Client> clientOptional = getClient(idClient);
        if(!clientOptional.isEmpty()) {
            clientRepository.delete(clientOptional.get());
            return true;
        }
        return false;
    }

}
