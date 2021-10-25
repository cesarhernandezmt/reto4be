/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.service;


import co.usa.ciclo3.retos.model.Doctor;
import co.usa.ciclo3.retos.repository.DoctorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DoctorService {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }
    
    public Optional<Doctor> getDoctor(int id) {
        return doctorRepository.getDoctor(id);
    }
    
    public Doctor save(Doctor doctor) {
        if(doctor.getId() == null) {
            return doctorRepository.save(doctor);
        }
        else {
            Optional<Doctor> doctorOptional = doctorRepository.getDoctor(doctor.getId());
            if(doctorOptional.isEmpty()) {
                return doctorRepository.save(doctor);
            }
            else {
                return doctor;
            }
        }
    }

    public Doctor update(Doctor doctor) {
        if(doctor.getId() != null) {
            Optional<Doctor> doctorOptional = doctorRepository.getDoctor(doctor.getId());
            if(!doctorOptional.isEmpty()) {
                if(doctor.getName() != null) {
                    doctorOptional.get().setName(doctor.getName());
                }
                if(doctor.getDepartment() != null) {
                    doctorOptional.get().setDepartment(doctor.getDepartment());
                }
                if(doctor.getYear() != null) {
                    doctorOptional.get().setYear(doctor.getYear());
                }
                if(doctor.getDescription()!= null) {
                    doctorOptional.get().setDescription(doctor.getDescription());
                }
                if(doctor.getSpecialty() != null) {
                    doctorOptional.get().setSpecialty(doctor.getSpecialty());
                }
                doctorRepository.save(doctorOptional.get());
                return doctorOptional.get();
            }
            else {
                return doctor;
            }
        }
        else {
            return doctor;
        }
    }
    
    public boolean deleteDoctor(int id) {
        Optional<Doctor> doctorOptional = getDoctor(id);
        if(!doctorOptional.isEmpty()) {
            doctorRepository.delete(doctorOptional.get());
            return true;
        }
        return false;
    }
    
}