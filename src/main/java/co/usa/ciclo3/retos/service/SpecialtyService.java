/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.service;


import co.usa.ciclo3.retos.model.Specialty;
import co.usa.ciclo3.retos.repository.SpecialtyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SpecialtyService {
    
    @Autowired
    private SpecialtyRepository specialtyRepository;
    
    public List<Specialty> getAll(){
        return specialtyRepository.getAll();
    }
    
    public Optional<Specialty> getSpecialty(int id) {
        return specialtyRepository.getSpecialty(id);
    }
    
    public Specialty save(Specialty specialty) {
        if(specialty.getId() == null) {
            return specialtyRepository.save(specialty);
        }
        else {
            Optional<Specialty> specialtyOptional = specialtyRepository.getSpecialty(specialty.getId());
            if(specialtyOptional.isEmpty()) {
                return specialtyRepository.save(specialty);
            }
            else {
                return specialty;
            }
        }
    }    
    
    public Specialty update(Specialty specialty) {
        if(specialty.getId() != null) {
            Optional<Specialty> specialtyOptional = specialtyRepository.getSpecialty(specialty.getId());
            if(!specialtyOptional.isEmpty()) {
                if(specialty.getName() != null) {
                    specialtyOptional.get().setName(specialty.getName());
                }
                if(specialty.getDescription() != null) {
                    specialtyOptional.get().setDescription(specialty.getDescription());
                }
                specialtyRepository.save(specialtyOptional.get());
                return specialtyOptional.get();
            }
            else {
                return specialty;
            }
        }
        else {
            return specialty;
        }
    }
    
    public boolean deleteSpecialty(int id) {
        Optional<Specialty> specialtyOptional = getSpecialty(id);
        if(!specialtyOptional.isEmpty()) {
            specialtyRepository.delete(specialtyOptional.get());
            return true;
        }
        return false;
    }
    
}
