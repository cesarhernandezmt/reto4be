/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.usa.ciclo3.retos.repository.crud;


import co.usa.ciclo3.retos.model.Score;
import org.springframework.data.repository.CrudRepository;


public interface ScoreCrudRepository extends CrudRepository<Score, Integer> {
    
}
