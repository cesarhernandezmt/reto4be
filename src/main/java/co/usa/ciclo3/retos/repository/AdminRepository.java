/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.repository;


import co.usa.ciclo3.retos.model.Admin;
import co.usa.ciclo3.retos.repository.crud.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AdminRepository {
    
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    
    public Admin save(Admin admin) {
        return adminCrudRepository.save(admin);
    }

    public void delete(Admin admin) {
        adminCrudRepository.delete(admin);
    }

}
