/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.repository;


import co.usa.ciclo3.retos.model.Doctor;
import co.usa.ciclo3.retos.repository.crud.DoctorCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DoctorRepository {
    
    @Autowired
    private DoctorCrudRepository doctorCrudRepository;
    
    public List<Doctor> getAll(){
        return (List<Doctor>) doctorCrudRepository.findAll();
    }
    
    public Optional<Doctor> getDoctor(int id){
        return doctorCrudRepository.findById(id);
    }
    
    public Doctor save(Doctor doctor) {
        return doctorCrudRepository.save(doctor);
    }

    public void delete(Doctor doctor) {
        doctorCrudRepository.delete(doctor);
    }
 
}
