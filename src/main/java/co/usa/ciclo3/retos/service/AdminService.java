/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.service;


import co.usa.ciclo3.retos.model.Admin;
import co.usa.ciclo3.retos.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int idAdmin) {
        return adminRepository.getAdmin(idAdmin);
    }
    
    public Admin save(Admin admin) {
        if(admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        }
        else {
            Optional<Admin> adminOptional = adminRepository.getAdmin(admin.getIdAdmin());
            if(adminOptional.isEmpty()) {
                return adminRepository.save(admin);
            }
            else {
                return admin;
            }
        }
    }    
    
    public Admin update(Admin admin) {
        if(admin.getIdAdmin() != null) {
            Optional<Admin> adminOptional = adminRepository.getAdmin(admin.getIdAdmin());
            if(!adminOptional.isEmpty()) {
                if(admin.getName() != null) {
                    adminOptional.get().setName(admin.getName());
                }
                if(admin.getEmail() != null) {
                    adminOptional.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword() != null) {
                    adminOptional.get().setPassword(admin.getPassword());
                }
                adminRepository.save(adminOptional.get());
                return adminOptional.get();
            }
            else {
                return admin;
            }
        }
        else {
            return admin;
        }
    }

    public boolean deleteAdmin(int idAdmin) {
        Optional<Admin> adminOptional = getAdmin(idAdmin);
        if(!adminOptional.isEmpty()) {
            adminRepository.delete(adminOptional.get());
            return true;
        }
        return false;
    }
/*
    public boolean deleteAdmin(int idAdmin) {
        Boolean boolDelete = getAdmin(idAdmin).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return boolDelete; 
    }
*/    
}
