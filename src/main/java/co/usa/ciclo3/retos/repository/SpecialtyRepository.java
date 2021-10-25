/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.repository;


import co.usa.ciclo3.retos.model.Specialty;
import co.usa.ciclo3.retos.repository.crud.SpecialtyCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SpecialtyRepository {
    
    @Autowired
    private SpecialtyCrudRepository specialtyCrudRepository;
    
    public List<Specialty> getAll(){
        return (List<Specialty>) specialtyCrudRepository.findAll();
    }
    
    public Optional<Specialty> getSpecialty(int id){
        return specialtyCrudRepository.findById(id);
    }
    
    public Specialty save(Specialty specialty) {
        return specialtyCrudRepository.save(specialty);
    }

    public void delete(Specialty specialty) {
        specialtyCrudRepository.delete(specialty);
    }

}
