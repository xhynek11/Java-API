package com.example.demo.employ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployService {

    private final EmployRepository employRepository;

    @Autowired
    public EmployService(EmployRepository employRepository) {
        this.employRepository = employRepository;
    }

    public List<Employ> getEmploy(){
        return employRepository.findAll();
    }

    public void addNewEmploy(Employ employ) {
        Optional<Employ> employOptional = employRepository.findEmployByEmail(employ.getEmail());
        if(employOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        if(EmailValidation(employ.getEmail())==false){
            throw new IllegalStateException("email is not valid");
        }
        employRepository.save(employ);
    }

    public void deleteEmploy(Long employId) {
        boolean exists = employRepository.existsById(employId);
        if(!exists){
            throw new IllegalStateException("employ with id " + employId + " does not exists");
        }
        employRepository.deleteById(employId);
    }

    @Transactional
    public void updateEmploy(Long employId, String name, String email,Integer salary){
        boolean exists = employRepository.existsById(employId);
        if(!exists){
            throw new IllegalStateException("employ with id " + employId + " does not exists");
        }
        Employ employ = employRepository.getById(employId);
        if(name != null){
            employ.setName(name);
        }
        if(email != null) {
            Optional<Employ> employOptional = employRepository.findEmployByEmail(email);
            if (employOptional.isPresent()){
                throw new IllegalStateException("email already taken");
            }
            if(EmailValidation(email)==false){
                throw new IllegalStateException("email is not valid");
            }
            employ.setEmail(email);
        }
        if(salary != null){
            employ.setSalary(salary);
        }
        employRepository.save(employ);
    }

    public boolean EmailValidation(String email){
        final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return (matcher.matches() ? true : false);
    }
}
