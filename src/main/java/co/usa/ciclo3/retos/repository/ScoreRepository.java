/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.retos.repository;


import co.usa.ciclo3.retos.model.Score;
import co.usa.ciclo3.retos.repository.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    
    public Optional<Score> getScore(int idScore){
        return scoreCrudRepository.findById(idScore);
    }
    
    public Score save(Score score) {
        return scoreCrudRepository.save(score);
    }    

    public void delete(Score score) {
        scoreCrudRepository.delete(score);
    }
  
}
